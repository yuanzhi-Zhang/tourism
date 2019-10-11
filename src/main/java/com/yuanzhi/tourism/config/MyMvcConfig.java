package com.yuanzhi.tourism.config;

import com.yuanzhi.tourism.component.LoginHandlerInterceptor;
import com.yuanzhi.tourism.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/9/22 7:21
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //所有的WebMvcConfigurer组件都会一起起作用
    @Bean //将组件注册在容器
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer adapter = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("user/index");
                registry.addViewController("/index.html").setViewName("admin/login");
                registry.addViewController("/adminMain.html").setViewName("admin/adminIndex");
                registry.addViewController("/destiny.html").setViewName("user/destiny");
                registry.addViewController("/userLogin.html").setViewName("user/userLogin");
            }

            //注册拦截器
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/index.html","/","/admin/login","/destiny.html","/password","/account","/albumworld","/self",
//                                "/userLogin.html","/css/**","/js/**","/images/**","/public/**","/asserts/**","/webjars/**","/journeyDetail",
//                                "/flight","/hotel","/setting","/setting/ownImg","/setting/modifyPwd","/setting/blackBan","/setting/ownAttended",
//                                "/setting/ownFan","/signout","/strategy","/strategyDetail","/register","/regist");
//            }
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }

}
