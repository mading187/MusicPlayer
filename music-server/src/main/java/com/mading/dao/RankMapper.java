package com.mading.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RankMapper {

    /**
     * 查总分
     * @param songListId
     * @return
     */
    @Select("SELECT COALESCE(sum(score),0) as score from `rank` where songListId = #{songListId}")
    int selectScoreSum(Long songListId);

    /**
     * 查总评分人数
     * @param songListId
     * @return
     */
    @Select("SELECT COALESCE(count(id),0) as num from `rank` where songListId = #{songListId} ;")
    int selectRankNum(Long songListId);
}
