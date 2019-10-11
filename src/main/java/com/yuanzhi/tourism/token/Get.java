package com.yuanzhi.tourism.token;

import com.google.gson.Gson;
import com.yuanzhi.tourism.utils.QiniuUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/10/1 19:25
 */

@Controller
public class Get {

    @RequestMapping("/token")
    public void token(HttpServletRequest request, HttpServletResponse response) throws Exception {

//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
//
//        String key = request.getParameter("key");
//        PrintWriter out = response.getWriter(); // 用PrintWriter对象将返回结果写入服务器
//        Map<String, String> map = new HashMap<>();
//        String token = QiniuUtils.getToken(key); 	// 生成普通上传的Token
//        map.put("token", token);
//        out.print(new Gson().toJson(map));
//        out.flush();
//        out.close();

    }

}
