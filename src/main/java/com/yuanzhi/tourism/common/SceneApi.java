package com.yuanzhi.tourism.common;

import com.show.api.ShowApiRequest;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/9/26 9:10
 */
public class SceneApi {
    public String getSceneApi(String keyword){
        String res = new ShowApiRequest("http://route.showapi.com/268-1","105032","1328161ee4a24d03b5d899d26c142568")
                .addTextPara("keyword",keyword)
                .addTextPara("proId","")
                .addTextPara("cityId","")
                .addTextPara("areaId","")
                .addTextPara("page","")
                .post();
        return res;
    }
}
