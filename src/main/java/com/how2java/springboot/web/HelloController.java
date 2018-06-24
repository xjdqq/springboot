package com.how2java.springboot.web;

import com.gzkit.httpUtils.HttpRequestUtils;
import com.how2java.springboot.dao.bean.user;
import com.how2java.springboot.dao.mapper.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import java.text.DateFormat;
import java.util.Date;

@Controller
public class HelloController {
@Autowired
userMapper userMapper;
    @RequestMapping("/hello")
    public String hello(Model m){
        System.out.println("yesgithub");
        int b=1/0;
        int a=1/0;
        user user=userMapper.selectOne("1");
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));

        return "HelloWorld";
    }
}
