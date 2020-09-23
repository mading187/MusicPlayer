package com.mading.service;

import com.mading.pojo.Rank;

public interface RankService {
    int rankOfSongListId(Long songListId);

    boolean addRank(Rank rank);
}
