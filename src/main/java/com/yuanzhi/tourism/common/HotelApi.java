/*
package com.yuanzhi.tourism.common;

import com.show.api.ShowApiRequest;

import javax.xml.crypto.Data;
import java.util.Date;

*/
/**
 * @Author: yuanzhi...
 * @Date: created in  2019/9/26 13:36
 *//*

public class HotelApi {

    */
/**
     * 搜索酒店
     * @param cityName
     * @param inDate
     * @param outDate
     * @return
     *//*

    public String getHotelApi(String cityName,  String inDate, String outDate){
        String res=new ShowApiRequest("http://route.showapi.com/1653-1","105032","1328161ee4a24d03b5d899d26c142568")
                .addTextPara("page","0")
                .addTextPara("cityName",cityName)
                .addTextPara("inDate",inDate)
                .addTextPara("outDate",outDate)
                .addTextPara("sortKey","")
                .addTextPara("star","")
                .addTextPara("minPrice","")
                .addTextPara("maxPrice","")
                .addTextPara("poiKey","")
                .addTextPara("poiCode","")
                .addTextPara("longitude","")
                .addTextPara("latitude","")
                .post();
        return res;
    }

    */
/**
     * 查询酒店详情
     * @param hotelId
     * @return
     *//*

    public String hotelDetail(String hotelId){
        String res=new ShowApiRequest("http://route.showapi.com/1653-3","105032","1328161ee4a24d03b5d899d26c142568")
                .addTextPara("hotelId",hotelId)
                .post();
        return res;
    }

}
*/
