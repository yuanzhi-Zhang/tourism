package com.yuanzhi.tourism.common;

import com.show.api.ShowApiRequest;

import java.util.Date;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/9/26 13:36
 */
public class HotelApi {

    public String getHotelApi(String customerName, String contactPhone, String contactName, Date inDate,Date outDate){
        String res=new ShowApiRequest("http://route.showapi.com/1653-6","my_appId","my_appSecret")
                .addTextPara("customerName",customerName)
                .addTextPara("ratePlanId","1_200_34526_1718090820")
                .addTextPara("hotelId","851523")
                .addTextPara("specialRemarks","")
                .addTextPara("contactName",contactName)
                .addTextPara("contactPhone",contactPhone)
                .addTextPara("contactEmail","")
                .addTextPara("inDate","2018-07-30")
                .addTextPara("outDate","2018-07-31")
                .addTextPara("man","1")
                .addTextPara("customerArriveTime","09:20:30")
                .addTextPara("callback","")
                .post();
        return res;
    }

}
