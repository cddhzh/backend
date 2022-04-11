package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Value("${file.staticPatternPath}")
    private String staticPatternPath;
    @Value(("${file.uploadFolder}"))
    private String uploadFolder;

    //springboot中springmvc让程序开发者去配置文件上传的额外的静态资源服务的配置
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(staticPatternPath).addResourceLocations("file:"+uploadFolder);
    }

}
