package com.yuanzhi.tourism.utils;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yuanzhi...
 *      分词工具类
 * @Date: created in  2019/9/28 10:22
 */
public class IKSUtil {

    public static List<String> getStringList(String text) throws Exception{
        //独立Lucene实现
        StringReader re = new StringReader(text);
        IKSegmenter ik = new IKSegmenter(re, true);
        Lexeme lex;
        List<String> s = new ArrayList<>();
        while ((lex = ik.next()) != null) {
            s.add(lex.getLexemeText());
        }
        return s;
    }

}
