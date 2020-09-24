package com.mading.dao;

import com.mading.pojo.Singer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Mapper
public interface SingerMapper {
    /**
     * 查找所有歌手
     * @return
     */
    @Select("select * from singer")
    List<Singer> allSinger();

    /**
     * 根据歌手性别查找歌手，sex=0表示女歌手 ， 1表示男歌手 ， 2表示组合歌手
     * @param sex
     * @return
     */
    @Select("select * from singer where sex=#{sex, jdbcType=INTEGER}")
    List<Singer> singerOfSex(int sex);
}
