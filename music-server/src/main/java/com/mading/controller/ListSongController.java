package com.mading.controller;

import com.mading.service.impl.ListSongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
@RestController
public class ListSongController {

    @Autowired
    private ListSongServiceImpl listSongService;

    //    返回歌单里包含的所有歌曲
    @RequestMapping(value = "/listSong", method = RequestMethod.GET)
    public Object allListSong(){
        return listSongService.allListSong();
    }

    //    返回指定iD的歌单的所有歌曲
    @RequestMapping(value = "/listSong/detail", method = RequestMethod.GET)
    public Object listSongOfSongId(HttpServletRequest req){
        String songListId = req.getParameter("songListId");
        return listSongService.listSongOfSongId(Integer.parseInt(songListId));
    }

}
