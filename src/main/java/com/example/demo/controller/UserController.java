package com.example.demo.controller;

import com.example.demo.Utils.Response;
import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService=new UserServiceImpl();


    @RequestMapping(value = "/regist" ,method = RequestMethod.GET)
    public Response  userRegist(@RequestParam("name") String name,
                                @RequestParam("pwd") String pwd){

       return userService.userLogin(name,pwd);

    }


}
