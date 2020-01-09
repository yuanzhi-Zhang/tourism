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
    private Integer frequency;

    public WordValue() {
    }

    public WordValue(String word, Integer frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }
}
