package com.web.core.controller;




import com.web.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;



@Controller
public class UserController {

    @Autowired
    private UserService userService;



}
