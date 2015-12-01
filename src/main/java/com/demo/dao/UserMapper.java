package com.demo.dao;

import com.demo.model.User;

import java.util.List;

/**
 * Created by Administrator on 2015/11/28.
 */
public interface UserMapper {

    public User selectPersionById(int id) throws Exception;

    public void addUser(User user) throws Exception;

    public void delUser(int id)  throws Exception;

    public void updateUser(User user) throws Exception;

    public List<User> findAllUser() throws Exception;
}
