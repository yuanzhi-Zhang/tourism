package com.yuanzhi.tourism.common;

import com.show.api.ShowApiRequest;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/9/26 13:43
 */
public class PhoneApi {

    public String getPhoneApi(String phone){
        String res=new ShowApiRequest("http://route.showapi.com/6-1","105032","1328161ee4a24d03b5d899d26c142568")
                .addTextPara("num",phone)
                .post();
        return res;
    }

}
