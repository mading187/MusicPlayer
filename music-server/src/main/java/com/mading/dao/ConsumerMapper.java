package com.mading.dao;

import com.mading.pojo.Consumer;
import org.apache.ibatis.annotations.*;
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


//    @Update("update consumer set username = #{username},password = #{password},sex = #{sex},phone_num = #{phoneNum}," +
//            "email = #{email},birth = #{birth},introduction = #{introduction},location = #{location},avator = #{avator}," +
//            "create_time = #{createTime},update_time = #{updateTime} where id = #{id}")
    @Update("<script>" +
            "update consumer\n" +
            "    <set >\n" +
            "      <if test=\"username != null\" >\n" +
            "        username = #{username,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"password != null\" >\n" +
            "        password = #{password,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"sex != null\" >\n" +
            "        sex = #{sex,jdbcType=TINYINT},\n" +
            "      </if>\n" +
            "      <if test=\"phoneNum != null\" >\n" +
            "        phone_num = #{phoneNum,jdbcType=CHAR},\n" +
            "      </if>\n" +
            "      <if test=\"email != null\" >\n" +
            "        email = #{email,jdbcType=CHAR},\n" +
            "      </if>\n" +
            "      <if test=\"birth != null\" >\n" +
            "        birth = #{birth,jdbcType=TIMESTAMP},\n" +
            "      </if>\n" +
            "      <if test=\"introduction != null\" >\n" +
            "        introduction = #{introduction,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"location != null\" >\n" +
            "        location = #{location,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"avator != null\" >\n" +
            "        avator = #{avator,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"createTime != null\" >\n" +
            "        create_time = #{createTime,jdbcType=TIMESTAMP},\n" +
            "      </if>\n" +
            "      <if test=\"updateTime != null\" >\n" +
            "        update_time = #{updateTime,jdbcType=TIMESTAMP},\n" +
            "      </if>\n" +
            "    </set>\n" +
            "    where id = #{id,jdbcType=INTEGER} " +
            "</script>")
    int updateUserMsg(Consumer consumer);


    @Insert("<script>" +
            "insert into consumer\n" +
            "    <trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" >\n" +
            "      <if test=\"username != null\" >\n" +
            "        username,\n" +
            "      </if>\n" +
            "      <if test=\"password != null\" >\n" +
            "        password,\n" +
            "      </if>\n" +
            "      <if test=\"sex != null\" >\n" +
            "        sex,\n" +
            "      </if>\n" +
            "      <if test=\"phoneNum != null\" >\n" +
            "        phone_num,\n" +
            "      </if>\n" +
            "      <if test=\"email != null\" >\n" +
            "        email,\n" +
            "      </if>\n" +
            "      <if test=\"birth != null\" >\n" +
            "        birth,\n" +
            "      </if>\n" +
            "      <if test=\"introduction != null\" >\n" +
            "        introduction,\n" +
            "      </if>\n" +
            "      <if test=\"location != null\" >\n" +
            "        location,\n" +
            "      </if>\n" +
            "      <if test=\"avator != null\" >\n" +
            "        avator,\n" +
            "      </if>\n" +
            "      <if test=\"createTime != null\" >\n" +
            "        create_time,\n" +
            "      </if>\n" +
            "      <if test=\"updateTime != null\" >\n" +
            "        update_time,\n" +
            "      </if>\n" +
            "    </trim>\n" +
            "    <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >\n" +
            "      <if test=\"username != null\" >\n" +
            "        #{username,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"password != null\" >\n" +
            "        #{password,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"sex != null\" >\n" +
            "        #{sex,jdbcType=TINYINT},\n" +
            "      </if>\n" +
            "      <if test=\"phoneNum != null\" >\n" +
            "        #{phoneNum,jdbcType=CHAR},\n" +
            "      </if>\n" +
            "      <if test=\"email != null\" >\n" +
            "        #{email,jdbcType=CHAR},\n" +
            "      </if>\n" +
            "      <if test=\"birth != null\" >\n" +
            "        #{birth,jdbcType=TIMESTAMP},\n" +
            "      </if>\n" +
            "      <if test=\"introduction != null\" >\n" +
            "        #{introduction,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"location != null\" >\n" +
            "        #{location,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"avator != null\" >\n" +
            "        #{avator,jdbcType=VARCHAR},\n" +
            "      </if>\n" +
            "      <if test=\"createTime != null\" >\n" +
            "        #{createTime,jdbcType=TIMESTAMP},\n" +
            "      </if>\n" +
            "      <if test=\"updateTime != null\" >\n" +
            "        #{updateTime,jdbcType=TIMESTAMP},\n" +
            "      </if>\n" +
            "    </trim>" +
            "</script>")
    int insertSelective(Consumer consumer);
}
