package com.mading.dao;

import com.mading.pojo.Consumer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ConsumerMapper {

    @Select("select count(*) from consumer where username= #{username} and password = #{password}")
    int verifyPassword(@Param("username") String nickname , @Param("password") String password);

    @Select("select * from consumer where username = #{username}")
    List<Consumer> loginStatus(@Param("username")String username);

    @Select("select * from consumer where id = #{id}")
    List<Consumer> userOfId(@Param("id") Integer id);
}
