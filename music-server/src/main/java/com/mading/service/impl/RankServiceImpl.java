package com.mading.service.impl;

import com.mading.dao.RankMapper;
import com.mading.pojo.Rank;
import com.mading.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankServiceImpl implements RankService {

    @Autowired
    private RankMapper rankMapper;
    @Override
    public int rankOfSongListId(Long songListId) {
        int num = rankMapper.selectRankNum(songListId);
        if(num != 0){
            return rankMapper.selectScoreSum(songListId) / rankMapper.selectRankNum(songListId);
        }
        return 0;
    }

    @Override
    public boolean addRank(Rank rank) {
        System.out.println(rank.toString());
        return rankMapper.insertSelective(rank) > 0 ? true:false;
    }
}
