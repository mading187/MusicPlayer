package com.mading.dao;

import com.mading.pojo.ListSong;
import com.mading.pojo.Song;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ListSongMaper {

    @Select("select * from list-song")
    List<Song> allListSong();

    @Select("select * from list_song where song_list_id = #{songListId}")
    List<ListSong> listSongOfSongId(int songListId);
}
