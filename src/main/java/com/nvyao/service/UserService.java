package com.nvyao.service;

import com.nvyao.mapper.UserMapper;
import com.nvyao.pojo.User;
import com.nvyao.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserService {
    // 调用 util下面的SqlSessionFactoryUtils类的getSqlSessionFactory方法来获取sqlSessionFactory
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password){
        //2、获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3、获取userMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //4、调用方法
        User user = mapper.select(username, password);
        //5、释放资源
        sqlSession.close();
        return user;
    }

    /**
     * 演示sql注入
     * @param username
     * @param password
     * @return
     */
    public List<User> loginSqlin(String username, String password){
        //2、获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3、获取userMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //4、调用方法
        List<User> users = mapper.selectAll(username, password);
        //5、释放资源
        sqlSession.close();
        return users;
    }


    /**
     * 注册方法
     * @return
     */
    public boolean register(User user){
        //2、获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3、获取userMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //4、判断用户是否存在
        User u = mapper.selectByUsername(user.getUsername());

        if(u == null){
            //用户名不存在
            mapper.add(user);
            sqlSession.commit();
        }
        sqlSession.close();

        return u == null;
    }
}
