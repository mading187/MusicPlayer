package com.mading.service.impl;

import com.mading.dao.SongMapper;
import com.mading.pojo.Song;
import com.mading.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongMapper songMapper;
    @Override
    public List<Song> songOfId(Integer id) {
        return songMapper.songOfId(id);
    }
}
