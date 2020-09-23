package com.mading.dao;

import com.mading.pojo.Comment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentMapper {

    /**
     *查询歌单的评价信息
     * @param songListId
     * @return
     */
    @Select("select * from comment where song_list_id = #{songListId, jdbcType=INTEGER}")
    @Results({
            @Result(property = "userId" ,column = "user_id"),
            @Result(property = "songId" ,column = "song_id"),
            @Result(property = "songListId" , column = "song_list_id"),
            @Result(property = "creatTime" , column = "creat_time")
    })
    List<Comment> commentOfSongListId(int songListId);

    /**
     * 对歌曲或者歌单添加评论
     * @param comment
     * @return
     */
    @Insert("<script>" +
            "insert into comment\n" +
            "    <trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" >\n" +
            "      <if test=\"id != null\" >\n" +
            "        id,\n" +
            "      </if>\n" +
            "      <if test=\"userId != null\" >\n" +
            "        user_id,\n" +
            "      </if>\n" +
            "      <if test=\"songId != null\" >\n" +
            "        song_id,\n" +
            "      </if>\n" +
            "      <if test=\"songListId != null\" >\n" +
            "        song_list_id,\n" +
            "      </if>\n" +
            "      <if test=\"content != null\" >\n" +
            "        content,\n" +
            "      </if>\n" +
            "      <if test=\"createTime != null\" >\n" +
            "        create_time,\n" +
            "      </if>\n" +
            "      <if test=\"type != null\" >\n" +
            "        type,\n" +
            "      </if>\n" +
            "      <if test=\"up != null\" >\n" +
            "        up,\n" +
            "      </if>\n" +
            "    </trim>\n" +
            "    <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >\n" +
            "      <if test=\"id != null\" >\n" +
            "        #{id,jdbcType=INTEGER},\n" +
            "      </if>\n" +
            "      <if test=\"userId != null\" >\n" +
            "        #{userId,jdbcType=INTEGER},\n" +
            "      </if>\n" +
            "      <if test=\"songId != null\" >\n" +
            "        #{songId,jdbcType=INTEGER},\n" +
            "      </if>\n" +
            "      <if test=\"songListId != null\" >\n" +
            "        #{songListId,jdbcType=INTEGER},\n" +
            "      </if>\n" +
            "      <if test=\"content != null\" >\n" +
            "        #{content,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"createTime != null\" >\n" +
            "        #{createTime,jdbcType=TIMESTAMP},\n" +
            "      </if>\n" +
            "      <if test=\"type != null\" >\n" +
            "        #{type,jdbcType=TINYINT},\n" +
            "      </if>\n" +
            "      <if test=\"up != null\" >\n" +
            "        #{up,jdbcType=INTEGER},\n" +
            "      </if>\n" +
            "    </trim>" +
            "</script>")
    @Results({
            @Result(property = "userId" ,column = "user_id"),
            @Result(property = "songId" ,column = "song_id"),
            @Result(property = "songListId" , column = "song_list_id"),
            @Result(property = "creatTime" , column = "creat_time")
    })
    int insertSelective(Comment comment);

    /**
     * 点赞
     * @param comment
     * @return
     */
    @Update("<script>" +
            "update comment\n" +
            "    <set >\n" +
            "      <if test=\"userId != null\" >\n" +
            "        user_id = #{userId,jdbcType=INTEGER},\n" +
            "      </if>\n" +
            "      <if test=\"songId != null\" >\n" +
            "        song_id = #{songId,jdbcType=INTEGER},\n" +
            "      </if>\n" +
            "      <if test=\"songListId != null\" >\n" +
            "        song_list_id = #{songListId,jdbcType=INTEGER},\n" +
            "      </if>\n" +
            "      <if test=\"content != null\" >\n" +
            "        content = #{content,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"createTime != null\" >\n" +
            "        create_time = #{createTime,jdbcType=TIMESTAMP},\n" +
            "      </if>\n" +
            "      <if test=\"type != null\" >\n" +
            "        type = #{type,jdbcType=TINYINT},\n" +
            "      </if>\n" +
            "      <if test=\"up != null\" >\n" +
            "        up = #{up,jdbcType=INTEGER},\n" +
            "      </if>\n" +
            "    </set>\n" +
            "    where id = #{id,jdbcType=INTEGER}" +
            "</script>")
    @Results({
            @Result(property = "userId" ,column = "user_id"),
            @Result(property = "songId" ,column = "song_id"),
            @Result(property = "songListId" , column = "song_list_id"),
            @Result(property = "creatTime" , column = "creat_time")
    })
    int updateCommentMsg(Comment comment);
}
