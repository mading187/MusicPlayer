package com.mading.service.impl;

import com.mading.dao.CollectMapper;
import com.mading.pojo.Collect;
import com.mading.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectMapper collectMapper;

    @Override
    public boolean addCollection(Collect collect) {
        return collectMapper.insertSelective(collect) > 0 ? true:false;
    }

    @Override
    public boolean existSongId(Integer userId, Integer songId) {
        return collectMapper.existSongId(userId, songId)>0 ? true:false;
    }



    @Override
    public List<Collect> collectionOfUser(int userId)

    {
        return collectMapper.collectionOfUser(userId);
    }
}
