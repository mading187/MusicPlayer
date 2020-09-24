package com.mading.dao;

import com.mading.pojo.SongList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SongListMapper {
    @Select("select * from song_list")
    List<SongList> allSongList();

    @Select("select * from song_list where style like #{style,jdbcType=VARCHAR}")
    List<SongList> likeStyle(String style);
}
