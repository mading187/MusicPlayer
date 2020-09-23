package com.mading.dao;

import com.mading.pojo.Singer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Mapper
public interface SingerMapper {
    @Select("select * from singer")
    List<Singer> allSinger();
}
