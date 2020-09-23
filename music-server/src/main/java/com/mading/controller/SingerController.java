package com.mading.controller;

import com.mading.service.impl.SingerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@RestController
public class SingerController {
    @Autowired
    private SingerServiceImpl singerService;

    @Configuration
    public class MyPicConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/img/singerPic/**").addResourceLocations("file:C:\\Users\\D\\Desktop\\music-website\\music-server\\img\\singerPic\\");
        }
    }

    //返回所有歌手
    @ResponseBody
    @RequestMapping(value = "/singer"  ,method = RequestMethod.GET)
    public Object allSinger(){
        System.out.println("获取所有歌手信息");return singerService.allSinger();}

}
