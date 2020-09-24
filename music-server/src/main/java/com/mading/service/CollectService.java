package com.mading.service;

import com.mading.pojo.Collect;

import java.util.List;

public interface CollectService {
    boolean addCollection(Collect collect);

    boolean existSongId(Integer userId, Integer songId);

    List<Collect> collectionOfUser(int parseInt);
}
