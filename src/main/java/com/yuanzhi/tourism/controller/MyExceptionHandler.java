package com.yuanzhi.tourism.controller;

import com.yuanzhi.tourism.exception.UserNotExit;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/9/22 7:55
 */

@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(UserNotExit.class)
    public String handleException(Exception e, HttpServletRequest request){

        Map<String,Object> map = new HashMap<>();
        //传入我们自己的错误状态码  4xx 5xx，否则就不会进入定制错误页面的解析流程
        /**
         * Integer statusCode = (Integer) request
         .getAttribute("javax.servlet.error.status_code");
         */
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user.notexit");
        map.put("message",e.getMessage());
        //转发到/error
        return "forward:/error";

    }
}
