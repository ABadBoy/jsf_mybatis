package com.demo.service;

import com.demo.dao.UserMapper;
import com.demo.model.User;
import com.demo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2015/11/29.
 */
@ManagedBean
@ApplicationScoped
public class UserService implements Serializable {

    private List<User> filteredUsers;

    public List<User> getAllUsers() throws Exception {

        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory().openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = userMapper.findAllUser();

        return userList;

    }

    public void addUser(User user) throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory().openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.addUser(user);
        sqlSession.commit();
        sqlSession.close();
    }


    public void deleteUser(User user) throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory().openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.delUser(user.getId());
        sqlSession.commit();
        sqlSession.close();
    }

    public void update(User user) throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory().openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.updateUser(user);
        sqlSession.commit();
        sqlSession.close();
    }
}
