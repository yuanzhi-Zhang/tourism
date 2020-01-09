package com.yuanzhi.tourism.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Scene {
    private Integer sceneId;

    private String sceneName;

    private String sceneCityName;

    private String sceneAreaName;

    private String sceneAddress;

    private String scenePrice;

    private String sceneProvinceName;

    private String sceneSummary;

    private String sceneAttention;

    private String sceneOpentime;

    private String sceneCoupon;

    private String scenePics;

    private String sceneStar;

    /*private List<Price> priceList = new ArrayList();

    private List<Pic> picList = new ArrayList();*/
}