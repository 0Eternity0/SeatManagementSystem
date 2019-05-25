package com.web.core.controller;


import com.web.core.pojo.User;
import com.web.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register",method ={RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String register(User user)
    {
        int i=userService.insert(user);
        {
            if(i>0)
                return "1";
            else
                return "0";
        }

    }

    @RequestMapping(value = "/login",method ={RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String login(String username,String password,HttpSession httpsession)
    {
        System.out.println(username+" "+password);
        User user = userService.selectBynamepwd(username,password);
        if (user==null)
        {
            System.out.println("用户不存在");
            return "0";
        }
        else {
            httpsession.setAttribute("User",user);
            System.out.println("登陆成功");
            return "1";
        }
    }

    @RequestMapping(value = "/quit")
    @ResponseBody
    public String quit(HttpSession httpSession)
    {
       httpSession.removeAttribute("User");
        return "1";
    }
}
