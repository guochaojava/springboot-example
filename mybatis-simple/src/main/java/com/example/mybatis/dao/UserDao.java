package com.example.mybatis.dao;

import com.example.mybatis.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {

    @Insert("INSERT INTO user(name,telephone) VALUES(#{name},#{telephone})")
    int insert(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    int delete(Integer id);

    @Update("UPDATE user SET name=#{name},telephone=#{telephone} WHERE id =#{id}")
    int update(User user);

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "telephone", column = "telephone")
    })
    User getUserById(Integer id);

    @Select("SELECT * FROM user")
    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "telephone", column = "telephone")
    })
    List<User> list();


}
