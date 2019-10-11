package com.yuanzhi.tourism.common;

import com.show.api.ShowApiRequest;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/9/26 13:17
 */
public class FlightApi {

    public String getFlightApi(String realname,String phone){
        String res=new ShowApiRequest("http://route.showapi.com/1122-2","105032","1328161ee4a24d03b5d899d26c142568")
                .addTextPara("RealName",realname)
                .addTextPara("Telephone",phone)
                .addTextPara("Page","1")
                .post();
        return res;
    }

}
