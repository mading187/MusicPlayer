package com.mading.dao;

import com.mading.pojo.Song;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SongMapper {

    @Select("select * from song where id = #{id, jdbcType=INTEGER}")
    List<Song> songOfId(Integer id);
}
