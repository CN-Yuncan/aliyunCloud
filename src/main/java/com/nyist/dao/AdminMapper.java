package com.nyist.dao;

import com.nyist.model.Admin;
import com.nyist.model.User;

import java.util.List;

public interface AdminMapper {

    //注册
    public int Register(Admin admin) throws Exception;
    //登录
    public Admin Login(Admin admin);

    //查询全部
    List<Admin> FindAllAdmin();

    //查询全部用户
    List<User> FindAllUser();

    //新增数据
    public int AddAdmin(User user) throws Exception;

    //删除数据
    public int DeleteUser(int id);

    //根据id查找
    public Admin FindAdminById(int id);

    //根据id查找
    public User FindUserById(int id);

    //修改数据
    public int UpdateAdmin(User user);

}
