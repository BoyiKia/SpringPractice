package com.example.demo.service;


import com.example.demo.Utils.Response;

public interface UserService {
    Response getUser(long userId);

    Response userRegister(String name,String pwd);

    Response userLogin(String name,String pwd);

}
