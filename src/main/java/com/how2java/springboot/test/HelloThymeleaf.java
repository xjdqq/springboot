package com.how2java.springboot.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping(value = "/th")
public class HelloThymeleaf {

    @RequestMapping(value = "helloTh")
    public String HelloThy(ModelMap map){
        map.addAttribute("name","Thymeleaf");
        return "helloYang";
    }
}
