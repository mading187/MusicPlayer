package com.mading.dao;

import com.mading.pojo.Rank;
import org.apache.ibatis.annotations.Insert;
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

    /**
     * 给歌单评分
     * @param rank
     * @return
     */
    @Insert("<script>" +
            "insert into `rank`\n" +
            "    <trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" >\n" +
            "\n" +
            "      <if test=\"songListId != null\" >\n" +
            "        songListId,\n" +
            "      </if>\n" +
            "      <if test=\"consumerId != null\" >\n" +
            "        consumerId,\n" +
            "      </if>\n" +
            "      <if test=\"score != null\" >\n" +
            "        score,\n" +
            "      </if>\n" +
            "    </trim>\n" +
            "    <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >\n" +
            "      <if test=\"songListId != null\" >\n" +
            "        #{songListId,jdbcType=BIGINT},\n" +
            "      </if>\n" +
            "      <if test=\"consumerId != null\" >\n" +
            "        #{consumerId,jdbcType=BIGINT},\n" +
            "      </if>\n" +
            "      <if test=\"score != null\" >\n" +
            "        #{score,jdbcType=INTEGER},\n" +
            "      </if>\n" +
            "    </trim>" +
            "</script>")
    int insertSelective(Rank rank);
}
