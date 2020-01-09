package com.yuanzhi.tourism.entity;

import lombok.Data;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/12/1 14:00
 */

@Data
public class Pic {
    private String picUrl;

    @Override
    public String toString() {
        return picUrl + '\'';
    }
}
