package com.nvyao.mapper;

import com.nvyao.pojo.Hero;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface HeroMapper {

    /**
     * 查询所有英雄
     * @return
     */
    @Select("select * from heroes;")
    @ResultMap("heroResultMap")
    List<Hero> selectAll();

    /**
     * 根据id删除英雄
     * @param id
     */
    @Delete("delete from heroes where id = #{id}")
    void deleteById(int id);

    /**
     * 添加英雄
     * @param hero
     */
    @Insert("insert into heroes values (null, #{username}, #{password}, #{name}, #{kongfu}, #{gender}, null, #{level}, #{birthdate}, #{sectId}, #{createTime}, #{updateTime})")
    void add(Hero hero);

    /**
     * 根据英雄id查询
     * @param id
     * @return
     */
    @Select("select * from heroes where id = #{id}")
    @ResultMap("heroResultMap")
    Hero selectById(int id);

    /**
     * 更新英雄个人信息
     * @param hero
     */
    @Update("update heroes set name = #{name}, password = #{password}, kongfu = #{kongfu}, gender = #{gender},image = #{image} ,level = #{level}, sect_id = #{sectId} where id = #{id}")
    void update(Hero hero);

}
