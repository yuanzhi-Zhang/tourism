package com.yuanzhi.tourism.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/10/18 10:48
 *
 * mybatis分页插件配置
 */

@Configuration
public class PageHelperConfig {
    @Bean
    public PageHelper paeHelper(){
        PageHelper pageHelper= new PageHelper();
        Properties p = new Properties();

        //设置为true时，会将RowBounds第一个参数offset当成pageNum页码使用
        p.setProperty("offsetAsPageNum","true");

        //设置为true时，使用RowBounds分页会进行count查询
        p.setProperty("rowBoundsWithCount","true");
        p.setProperty("reasonalbe","true");
        pageHelper.setProperties(p);
        return pageHelper;
    }
}
