package com.mading.controller;

import com.mading.service.impl.SongListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@RestController
public class SongListController {
    @Autowired
    private SongListServiceImpl songListService;

    @Configuration
    public class MyPicConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/img/songListPic/**").addResourceLocations("file:C:\\Users\\D\\Desktop\\music-website\\music-server\\img\\songListPic\\");
        }
    }

    @RequestMapping(value = "/songList" , method= RequestMethod.GET)
    public Object allSongList(){
        return songListService.allSongList();
    }

}
