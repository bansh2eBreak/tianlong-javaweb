package com.nvyao.mapper;

import com.nvyao.pojo.Sect;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SectMapper {

    /**
     * 查询所有门派
     * @return
     */
    @Select("select * from sects")
    @ResultMap("sectResultMap")
    List<Sect> selectAll();

    /**
     * 添加门派
     * @param sect
     */
    @Insert("insert into sects values (null, #{name}, #{createTime}, #{updateTime}, #{introduction})")
    void add(Sect sect);

    /**
     * 根据门派id删除门派
     * @param id
     */
    @Delete("delete from sects where id = #{id}")
    void deleteById(int id);

    /**
     * 根据门派id查询
     * @param id
     * @return
     */
    @Select("select * from sects where id = #{id}")
    @ResultMap("sectResultMap")
    Sect selectById(int id);

    /**
     * 更新门派信息
     * @param sect
     */
    @Update("update sects set name = #{name}, introduction = #{introduction}, update_time = #{updateTime} where id = #{id}")
    void update(Sect sect);

}
