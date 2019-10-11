package com.yuanzhi.tourism.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/9/28 10:31
 */
@Data
public class WordValue {

    private String word;
    private Integer frequecy;

    public WordValue() {
    }

    public WordValue(String word, Integer frequecy) {
        this.word = word;
        this.frequecy = frequecy;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getFrequecy() {
        return frequecy;
    }

    public void setFrequecy(Integer frequecy) {
        this.frequecy = frequecy;
    }
}
