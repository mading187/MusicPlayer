package com.mading.dao;

import com.mading.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
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
    public List<Comment> commentOfSongListId(int songListId);
}
