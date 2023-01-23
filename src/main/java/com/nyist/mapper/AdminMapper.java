package com.nyist.mapper;

import com.nyist.model.Admin;
import com.nyist.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {

        //注册
        @Insert("insert into admin (username,password,name,phone,email) values (#{username},#{password},#{name},#{phone},#{email})")
        public int Register(Admin admin) throws Exception;
        //登录
        @Select("select * from admin where username=#{username} and password=#{password}")
        public Admin Login(Admin admin);

        //查询全部
        @Select("select * from admin")
        List<Admin> FindAllAdmin();

        //新增管理员
        @Insert("insert into admin (username,password,name,phone,email) values (#{username},#{password},#{name},#{phone},#{email});")
        public int AddAdmin(Admin admin) throws Exception;

        //新增用户user
        @Insert("insert into user (username,password,nickname) values (#{username},#{password},#{nickname});")
        public int AddUser(User user) throws Exception;

        //删除用户数据
        @Delete("delete from user where id = #{id}")
        public int DeleteUser(int id);

        //删除文件数据
        @Delete("delete from myfile where user_id = #{id}")
        public int DeleteFile(int id);

        //根据id查找
        @Select("select * from admin where id = #{id}")
        public Admin FindAdminById(int id);

        //根据id查找用户
        @Select("select * from user where id = #{id}")
        public User FindUserById(int id);

        //查询全部用户
        @Select("select * from user")
        List<User> FindAllUser();

        //修改用户
        @Update("update user set password=#{password},nickname=#{nickname} where id=#{id}")
        public int UpdateUser(User user);
}
