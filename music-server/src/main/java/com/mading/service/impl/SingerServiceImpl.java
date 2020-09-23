package com.mading.service.impl;

import com.mading.dao.SingerMapper;
import com.mading.pojo.Singer;
import com.mading.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingerServiceImpl implements SingerService {
    @Autowired
    private SingerMapper singerMapper;
    @Override
    public List<Singer> allSinger() {
        return singerMapper.allSinger();
    }
}
