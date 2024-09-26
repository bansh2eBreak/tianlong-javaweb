package com.nvyao.mapper;

import com.nvyao.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    /**
     * 根据用户名和密码查询用户对象
     * @param username
     * @param password
     * @return
     */
    @Select("select * from user where username = #{username} and password = #{password}")
    User select(@Param("username") String username, @Param("password") String password);

    /**
     * 根据用户名密码查询用户列表，为了sql注入
     * @param username
     * @param password
     * @return
     */
    @Select("select * from user where username = '${username}' and password = '${password}'")
    List<User> selectAll(@Param("username") String username, @Param("password") String password);

    /**
     * 根据用户名查询用户对象
     * @param username
     * @return
     */
    @Select("select * from user where username = #{username}")
    User selectByUsername(@Param("username") String username);

    /**
     * 添加用户
     * @param user
     */
    @Insert("insert into user values(null, #{username}, #{password})")
    void add(User user);
}