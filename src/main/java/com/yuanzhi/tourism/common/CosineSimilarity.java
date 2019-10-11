package com.yuanzhi.tourism.common;

import com.yuanzhi.tourism.entity.WordValue;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.yuanzhi.tourism.utils.IKSUtil.getStringList;

/**
 * @Author: yuanzhi...
 *
 * 获取文本关键词
 * 过滤停用词
 * 计算词频
 * 转换为向量并计算两个文本的余弦相似度
 *
 * @Date: created in  2019/9/28 10:33
 */
public class CosineSimilarity {

    /**
     * 向量余弦
     * @param text1 文本1
     * @param text2 文本2
     * @return 向量余弦
     */
    public double cos(String text1, String text2) {
        if (StringUtils.isBlank(text2 + text1)) {
            return 0.0;
        }
        List<String> words = parse(text1);
        List<String> words1 = parse(text2);
        Set<String> set = mergeList(words, words1);
        List<WordValue> wordValueList = computeWordCount(words);
        List<WordValue> wordValueList1 = computeWordCount(words1);
        int[] vector = wordToVector(set, wordValueList);
        int[] vector1 = wordToVector(set, wordValueList1);
        int moduleA = 0;
        int moduleB = 0;
        int AMutiplyB = 0;
        for (int i = 0; i < vector.length; i++) {
            moduleA += vector[i] * vector[i];
            moduleB += vector1[i] * vector1[i];
            AMutiplyB += vector[i] * vector1[i];
        }
        return (double) AMutiplyB / (Math.sqrt(moduleA) * Math.sqrt(moduleB));
    }

    /**
     * 转换为向量
     * @param set 所有词表
     * @param list 词信息
     * @return 向量
     */
    private int[] wordToVector(Set<String> set, List<WordValue> list) {
        if (set == null || set.size() == 0 || list == null || list.size() == 0) {
            return null;
        }
        List<String> mergeList = new ArrayList<String>(set);
        int[] vector = new int[mergeList.size()];

        for (int i = 0; i < mergeList.size(); i++) {
            for (WordValue wordValue : list) {
                if (wordValue.getWord().equals(mergeList.get(i))) {
                    vector[i] = wordValue.getFrequecy();
                    break;
                } else {
                    vector[i] = 0;
                }
            }
        }
        return vector;
    }

    /**
     * 获取所有词
     * @param str1 文本1分词结果
     * @param str2 文本2分词结果
     * @return 返回所有的词，不重复
     */
    private Set<String> mergeList(List<String> str1, List<String> str2) {
        if (str1 == null || str1.size() == 0
                || str2 == null || str2.size() == 0) {
            return null;
        }
        Set<String> set = new HashSet<String>();
        for (String ele : str1) {
            set.add(ele);
        }
        for (String ele : str2) {
            set.add(ele);
        }
        return set;
    }

    /**
     * 分词
     * @param text 文本
     * @return 分词结果
     */
    private List<String> parse(String text) {
        //判断文本是否为空
        if (StringUtils.isBlank(text)) {
            return null;
        }

        List<String> stringList = null;
        try {
            stringList = getStringList(text);
            if (stringList == null || stringList.size() == 0) {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(stringList);
        return stringList;
    }

    /**
     * 计算词频
     * @param list 分词结果
     * @return 词频
     */
    private List<WordValue> computeWordCount(List<String> list) {
        List<WordValue> wordValueList = new ArrayList<WordValue>();
        for (String element : list) {
            if (isInWordValueList(element, wordValueList)) {
                WordValue wordValue = wordValueList.get(getElementIndex(element, wordValueList));
                wordValue.setFrequecy(wordValue.getFrequecy() + 1);
            } else {
                WordValue wordValue = new WordValue(element, 1);
                wordValueList.add(wordValue);
            }
        }
        return wordValueList;
    }

    private int getElementIndex(String word, List<WordValue> wordValueList) {
        if (StringUtils.isBlank(word) || wordValueList == null || wordValueList.size() == 0) {
            return -1;
        }
        for (int i = 0; i < wordValueList.size(); i++) {
            if (wordValueList.get(i).getWord().equals(word)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isInWordValueList(String str, List<WordValue> wordValueList) {
        if (StringUtils.isBlank(str) || wordValueList == null || wordValueList.size() == 0) {
            return false;
        }
        for (WordValue wordValue : wordValueList) {
            if (wordValue.getWord().equals(str)) {
                return true;
            }
        }
        return false;
    }

}
