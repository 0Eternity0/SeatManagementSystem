package com.web.core.controller;



import com.web.core.pojo.User;
import com.web.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public  String hello(Model model){
        model.addAttribute("mes","success!");

        return "index";
    }

    @RequestMapping(value = "register",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;charset=utf-8")
    @ResponseBody()
    public String register(User user){
        System.out.println(user.toString());
        userService.addUser(user);
        return "注册成功";

    }
}
