package com.mading.service.impl;

import com.mading.dao.ListSongMaper;
import com.mading.pojo.ListSong;
import com.mading.pojo.Song;
import com.mading.service.ListSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListSongServiceImpl implements ListSongService {
    @Autowired
    private ListSongMaper listSongMapper;

    @Override
    public List<Song> allListSong() {
        return listSongMapper.allListSong();
    }

    @Override
    public List<ListSong> listSongOfSongId(int songListId) {
        return listSongMapper.listSongOfSongId(songListId);
    }
}
