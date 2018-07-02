package com.how2java.springboot.controller;

import com.how2java.springboot.common.result.BizResult;
import com.how2java.springboot.constant.Constant;
import com.how2java.springboot.dao.bean.users;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/login.html")
    @ResponseBody
    public String login(HttpSession session, String name, String password){
        BizResult<Boolean> biz = new BizResult<>();
        Subject subject = SecurityUtils.getSubject();
        System.out.println(name+" "+password);
        try{
            UsernamePasswordToken token=new UsernamePasswordToken(name,password);
            subject.login(token);
            biz.setMsg("登录成功");
            biz.setSuccess(true);
            users user=(users) subject.getSession().getAttribute(Constant.USER);
        }catch(Exception e){
            e.printStackTrace();
            biz.setSuccess(false);
            biz.setMsg("账号密码错误");
        }
        return JSONObject.fromObject(biz).toString();
    }
    @RequestMapping("/loginOut.html")
    public String loginOut(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
}
