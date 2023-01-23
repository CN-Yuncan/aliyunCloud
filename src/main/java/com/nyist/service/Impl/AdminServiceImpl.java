package com.nyist.service.Impl;

import com.nyist.mapper.AdminMapper;
import com.nyist.model.Admin;
import com.nyist.model.User;
import com.nyist.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Admin> FindAllAdmin() {
        return adminMapper.FindAllAdmin();
    }

    @Override
    public int AddUser(User user)  throws Exception{
        return adminMapper.AddUser(user);
    }

    @Override
    public Integer DeleteUser(int id) {
        return adminMapper.DeleteUser(id);
    }


    @Override
    public boolean UpdateUser(User user) {
        int count = adminMapper.UpdateUser(user);
        if(count > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int Register(Admin admin)  throws Exception{return adminMapper.Register(admin);}

    @Override
    public Admin Login(Admin admin) {return adminMapper.Login(admin);}

    @Override
    public List<User> FindAllUser() {
        return adminMapper.FindAllUser();
    }

    @Override
    public Integer DeleteFile(Integer id) {
        return adminMapper.DeleteFile(id);
    }

    @Override
    public User FindUserById(Integer id) {
        return adminMapper.FindUserById(id);
    }
}
