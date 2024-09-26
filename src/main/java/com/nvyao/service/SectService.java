package com.nvyao.service;

import com.nvyao.mapper.SectMapper;
import com.nvyao.pojo.Sect;
import com.nvyao.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class SectService {
    // 调用 util下面的SqlSessionFactoryUtils类的getSqlSessionFactory方法来获取sqlSessionFactory
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查询所有门派
     * @return sects
     */
    public List<Sect> selectAll() {
        //1.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.获取SectMapper代理对象
        SectMapper mapper = sqlSession.getMapper(SectMapper.class);
        //3.执行sql
        List<Sect> sects = mapper.selectAll();
        //4.释放资源
        sqlSession.close();
        return sects;
    }

    /**
     * 根据门派id删除门派
     * @param id
     */
    public void deleteById(int id) {
        //1.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.获取SectMapper代理对象
        SectMapper mapper = sqlSession.getMapper(SectMapper.class);
        //3.执行sql
        mapper.deleteById(id);
        //4.提交事物完成删除操作
        sqlSession.commit();
        //5.释放资源
        sqlSession.close();
    }

    /**
     * 添加门派
     * @param sect
     */
    public void add(Sect sect) {
        //1.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.获取SectMapper代理对象
        SectMapper mapper = sqlSession.getMapper(SectMapper.class);
        //3.执行sql
        mapper.add(sect);
        //4.提交事物完成删除操作
        sqlSession.commit();
        //5.释放资源
        sqlSession.close();
    }

    /**
     * 根据门派id查询
     * @param id
     * @return
     */
    public Sect selectById(int id) {
        //1.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.获取SectMapper代理对象
        SectMapper mapper = sqlSession.getMapper(SectMapper.class);
        //3.执行sql
        Sect sect = mapper.selectById(id);
        //4.释放资源
        sqlSession.close();
        return sect;
    }

    public void update(Sect sect) {
        //1.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.获取SectMapper代理对象
        SectMapper mapper = sqlSession.getMapper(SectMapper.class);
        //3.执行sql
        mapper.update(sect);
        //4.提交事物完成删除操作
        sqlSession.commit();
        //5.释放资源
        sqlSession.close();
    }
}
