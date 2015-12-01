package com.demo.view;


import com.demo.model.User;
import com.demo.service.UserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2015/11/28.
 */
@ManagedBean
@SessionScoped
public class UserBean implements Serializable {

    private String userName;
    private Integer age;
    private Integer phone;
    private String email;

    private User currentEditUser;

    @ManagedProperty("#{userService}")
    private UserService userService;

    public List<User> getAllUsers() throws Exception {
        return userService.getAllUsers();
    }


    public void addUser() throws Exception {
        User user = new User();
        user.setName(userName);
        user.setAge(age);
        user.setPhone(phone);
        user.setEmail(email);
        userService.addUser(user);
    }

    public  void deleteUser(User u) throws Exception {
        userService.deleteUser(u);
    }

    public void editUser(User user){
        this.currentEditUser = user;
    }

    public void updateUser(User user) throws Exception {
        userService.update(user);
    }

    public void cleanProperties(){
        userName = null;
        age = null;
        phone = null;
        email = null;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getCurrentEditUser() {
        return currentEditUser;
    }

    public void setCurrentEditUser(User currentEditUser) {
        this.currentEditUser = currentEditUser;
    }
}
