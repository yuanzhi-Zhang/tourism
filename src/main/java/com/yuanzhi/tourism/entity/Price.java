package com.yuanzhi.tourism.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/12/1 13:57
 */

@Data
public class Price {
    private String type;

    private List<PriceData> priceDataList = new ArrayList();
}
