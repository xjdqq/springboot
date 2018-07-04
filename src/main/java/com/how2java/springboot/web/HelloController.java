package com.how2java.springboot.web;

import com.how2java.springboot.biz.shiro.UsersAuthBiz;
import com.how2java.springboot.constant.Constant;
import com.how2java.springboot.dao.bean.user;
import com.how2java.springboot.dao.bean.users;
import com.how2java.springboot.dao.mapper.userMapper;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.apache.shiro.subject.Subject;
import java.text.DateFormat;
import java.util.Date;

@Controller
public class HelloController {
    @Autowired
    userMapper userMapper;
    @Autowired
    UsersAuthBiz usersAuthBiz;
    @RequestMapping(value = "/hello.html")
    public String hello(Model m){
        System.out.println("yesgithub");
        usersAuthBiz.a();
        //user user=userMapper.selectOne("1");
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));

        return "login";
    }

    @RequestMapping(value="/login1.html",method = RequestMethod.POST)
    public String login(user user){
        System.out.println("123");
        System.out.println(user.toString());
        //m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));

        return "errorPage";
    }
    @RequestMapping(value="/addOrder")
    public String login11(){
        System.out.println("测试成功");

        //m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));

        return "errorPage";
    }
    @RequestMapping(value="/listProduct")
    public String login12(){
        System.out.println("测试成功");
        //m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        Subject subject = SecurityUtils.getSubject();
        users user=(users) subject.getSession().getAttribute(Constant.USER);

        return "errorPage";
    }
    @RequestMapping(value="/listProduct1")
    public String login121(){
        System.out.println("测试成功");
        //m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        Subject subject = SecurityUtils.getSubject();

        System.out.println(subject.hasRole("1"));
        System.out.println(subject.hasRole("2"));
        System.out.println(subject.hasRole("3"));
        subject.checkPermission("5");
        System.out.println();
        return "errorPage";
    }
}
