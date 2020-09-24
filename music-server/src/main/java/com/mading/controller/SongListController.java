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

import javax.servlet.http.HttpServletRequest;

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

    //返回所有歌单
    @RequestMapping(value = "/songList" , method= RequestMethod.GET)
    public Object allSongList(){
        return songListService.allSongList();
    }

    //    返回指定类型的歌单
    @RequestMapping(value = "/songList/style/detail", method = RequestMethod.GET)
    public Object songListOfStyle(HttpServletRequest req){
        String style = req.getParameter("style").trim();
        return songListService.likeStyle('%'+ style + '%');
    }

}
