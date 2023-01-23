package com.nyist.controller;

import com.nyist.model.Admin;
import com.nyist.model.User;
import com.nyist.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value="/admin")
public class AdminControl {
    @Autowired
    private AdminService adminService;

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping(value="/ToLogin")
    public String ToLogin(){
        return "login";
    }

    /**
     * 跳转到注册页面
     * @return
     */
    @RequestMapping(value="/ToRegister")
    public String ToRegister(){
        return "register";
    }

    /**
     * 跳转到用户信息表页面
     * @return
     */
    @RequestMapping(value="/ToList")
    public String ToList(User user, HttpServletRequest req, HttpSession session){
        List<User> userList = adminService.FindAllUser();
        req.setAttribute("userList",userList);
        return "list";
    }

    /**
     * 登录
     * @param admin
     * @param req
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public String login(Admin admin, HttpServletRequest req, HttpSession session){
        admin = adminService.Login(admin);
        if(admin!=null && !(admin.getId().equals(""))){
            session.setAttribute("admin",admin);
            List<User> userList = adminService.FindAllUser();
            req.setAttribute("userList",userList);
            return "list";
        }
        req.setAttribute("loginDefeat","用户名称或密码不正确，请重新登录");
        return "login";
    }

    /**
     * 注册
     * @param admin
     * @param req
     * @return
     */
    @PostMapping("/register")
    public String register(Admin admin, HttpServletRequest req) {
        int num = 0;
        try {
            num = adminService.Register(admin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(num>0){
            return "login";
        }
        req.setAttribute("RegistDefeat","用户名称已存在");
        return "register";
    }

    /**
     * 退出
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }

    //跳转添加用户页面
    @RequestMapping("/ToAdd")
    public String ToAdd(User user) {
        return "add";
    }

    //添加用户
    @RequestMapping("/add")
    public String save(User user) {
        try {
            adminService.AddUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/ToList";
    }

    //删除数据
    @RequestMapping("/Delete")
    public String Delete(@RequestParam("id") Integer id, HttpServletRequest req) throws IOException {
        adminService.DeleteUser(id);
        adminService.DeleteFile(id);
        List<User> userList = adminService.FindAllUser();
        req.setAttribute("userList",userList);
        return "list";
        /*return "redirect:/admin/Tolist";*/
    }

    /**
     * 跳转修改信息界面
     * @param req
     * @return
     */
    @RequestMapping("/ToUpdate")
    public String ToUpdate(User user, HttpServletRequest req){
        User Myuser = adminService.FindUserById(user.getId());
        req.setAttribute("myuser",Myuser);
        return "update";
    }

    /**
     * 修改用户信息
     * @param req
     * @param user
     * @return
     */
    @RequestMapping("/UpdateAdmin")
    public String Update(HttpServletRequest req, User user) {
        Boolean flag = adminService.UpdateUser(user);
        if(flag){
            List<User> userList = adminService.FindAllUser();
            req.setAttribute("userList",userList);
            return "list";
        }else{
            return "error";
        }
    }

    @GetMapping("/forward/{target}")
    public String Forward(@PathVariable("target") String target){
        return "/"+target;
    }

}
