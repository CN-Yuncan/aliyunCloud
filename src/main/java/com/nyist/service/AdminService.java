package com.nyist.service;


import com.nyist.model.Admin;
import com.nyist.model.User;

import java.util.List;

public interface AdminService {
    //查询全部管理员
    List<Admin> FindAllAdmin();
    //新增用户
    int AddUser(User user) throws Exception;
    //删除用户
    Integer DeleteUser(int id);
    //删除用户对应的文件
    Integer DeleteFile(Integer id);
    //根据用户名查找
    User FindUserById(Integer id);
    //更新数据
    boolean UpdateUser(User user);
    //注册
    public int Register(Admin admin) throws Exception;
    //登录
    public Admin Login(Admin admin);
    //查找所有用户
    List<User> FindAllUser();

}
