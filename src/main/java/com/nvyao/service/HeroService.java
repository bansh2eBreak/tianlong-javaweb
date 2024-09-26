package com.nvyao.service;

import com.nvyao.mapper.HeroMapper;
import com.nvyao.pojo.Hero;
import com.nvyao.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class HeroService {
    // 调用 util下面的SqlSessionFactoryUtils类的getSqlSessionFactory方法来获取sqlSessionFactory
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查询所有英雄
     * @return sects
     */
    public List<Hero> selectAll(){
        //1.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.获取SectMapper代理对象
        HeroMapper mapper = sqlSession.getMapper(HeroMapper.class);
        //3.执行sql
        List<Hero> heroes = mapper.selectAll();
        //4.释放资源
        sqlSession.close();
        return heroes;
    }

    /**
     * 根据id删除英雄
     * @param id
     */
    public void deleteById(int id){
        //1.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.获取SectMapper代理对象
        HeroMapper mapper = sqlSession.getMapper(HeroMapper.class);
        //3.执行sql
        mapper.deleteById(id);
        //4.提交事物
        sqlSession.commit();
        //5.释放资源
        sqlSession.close();
    }

    /**
     * 添加英雄
     * @param hero
     */
    public void add(Hero hero){
        //1.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.获取SectMapper代理对象
        HeroMapper mapper = sqlSession.getMapper(HeroMapper.class);
        //3.执行sql
        mapper.add(hero);
        //4.提交事物
        sqlSession.commit();
        //5.释放资源
        sqlSession.close();
    }

    /**
     * 根据英雄id搜索
     * @param id
     * @return
     */
    public Hero selectById(int id) {
        //1.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.获取SectMapper代理对象
        HeroMapper mapper = sqlSession.getMapper(HeroMapper.class);
        //3.执行sql
        Hero hero = mapper.selectById(id);
        //4.释放资源
        sqlSession.close();
        return hero;
    }

    /**
     * 更新英雄个人信息
     * @param hero
     */
    public void update(Hero hero) {
        //1.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.获取SectMapper代理对象
        HeroMapper mapper = sqlSession.getMapper(HeroMapper.class);
        //3.执行sql
        mapper.update(hero);
        //4.提交事物
        sqlSession.commit();
        //5.释放资源
        sqlSession.close();
    }
}
