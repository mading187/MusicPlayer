package com.mading.service;

import com.mading.pojo.Collect;

public interface CollectService {
    boolean addCollection(Collect collect);

    boolean existSongId(Integer userId, Integer songId);
}
