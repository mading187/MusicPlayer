package com.mading.dao;

import com.mading.pojo.Collect;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CollectMapper {

    /**
     *
     * @return
     */
    List<Collect> allCollect();

    /**
     * 用户收藏歌曲
     * @param collect
     * @return
     */
    @Insert("<script>" +
            "insert into collect\n" +
            "    <trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" >\n" +
            "      <if test=\"id != null\" >\n" +
            "        id,\n" +
            "      </if>\n" +
            "      <if test=\"userId != null\" >\n" +
            "        user_id,\n" +
            "      </if>\n" +
            "      <if test=\"type != null\" >\n" +
            "        type,\n" +
            "      </if>\n" +
            "      <if test=\"songId != null\" >\n" +
            "        song_id,\n" +
            "      </if>\n" +
            "      <if test=\"songListId != null\" >\n" +
            "        song_list_id,\n" +
            "      </if>\n" +
            "      <if test=\"createTime != null\" >\n" +
            "        create_time,\n" +
            "      </if>\n" +
            "    </trim>\n" +
            "    <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >\n" +
            "      <if test=\"id != null\" >\n" +
            "        #{id,jdbcType=INTEGER},\n" +
            "      </if>\n" +
            "      <if test=\"userId != null\" >\n" +
            "        #{userId,jdbcType=INTEGER},\n" +
            "      </if>\n" +
            "      <if test=\"type != null\" >\n" +
            "        #{type,jdbcType=TINYINT},\n" +
            "      </if>\n" +
            "      <if test=\"songId != null\" >\n" +
            "        #{songId,jdbcType=INTEGER},\n" +
            "      </if>\n" +
            "      <if test=\"songListId != null\" >\n" +
            "        #{songListId,jdbcType=INTEGER},\n" +
            "      </if>\n" +
            "      <if test=\"createTime != null\" >\n" +
            "        #{createTime,jdbcType=TIMESTAMP},\n" +
            "      </if>\n" +
            "    </trim>" +
            "</script>")
    @Results({
            @Result(property = "userId" ,column = "user_id"),
            @Result(property = "songId" ,column = "song_id"),
            @Result(property = "songListId" , column = "song_list_id"),
            @Result(property = "creatTime" , column = "creat_time")
    })
    int insertSelective(Collect collect);

    @Select("select count(*) from collect where user_id = #{userId, jdbcType=INTEGER} and song_id = #{songId, jdbcType=INTEGER} ;")
    int existSongId(@Param("userId") Integer userId, @Param("songId") Integer songId);

    @Select("select * from collect where user_id = #{userId}")
    @Results({
            @Result(property = "userId" ,column = "user_id"),
            @Result(property = "songId" ,column = "song_id"),
            @Result(property = "songListId" , column = "song_list_id"),
            @Result(property = "creatTime" , column = "creat_time")
    })
    List<Collect> collectionOfUser(Integer userId);
}
