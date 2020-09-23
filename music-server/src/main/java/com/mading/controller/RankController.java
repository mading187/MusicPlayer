package com.mading.controller;

import com.mading.service.impl.RankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
@RestController
public class RankController {

    @Autowired
    private RankServiceImpl rankService;
    //    获取指定歌单的评分
    @RequestMapping(value = "/rank", method = RequestMethod.GET)
    public Object rankOfSongListId(HttpServletRequest req){
        String songListId = req.getParameter("songListId");
        return rankService.rankOfSongListId(Long.parseLong(songListId));
    }
}
