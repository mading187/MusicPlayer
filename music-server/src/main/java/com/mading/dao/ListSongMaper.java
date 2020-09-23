package com.mading.dao;

import com.mading.pojo.ListSong;
import com.mading.pojo.Song;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ListSongMaper {

    @Select("select * from list-song")
    List<Song> allListSong();

    @Select("select * from list_song where song_list_id = #{songListId}")
    @Results({
            @Result(property = "songId" ,column = "song_id"),
            @Result(property = "songListId" ,column = "song_list_id")
    })
    List<ListSong> listSongOfSongId(int songListId);
}
