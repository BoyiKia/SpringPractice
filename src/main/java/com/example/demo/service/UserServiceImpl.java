package com.example.demo.service;

import com.example.demo.Utils.CommonTools;
import com.example.demo.Utils.Response;
import com.example.demo.domain.People;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public Response getUser(long userId) {

        People one = (People) userRepository.getOne(userId);
        if(one==null){
            return new Response("1","用户不存在");
        }else{
            return new Response("2",one);

        }

    }

    @Override
    public Response userRegister(String name, String pwd) {
        if(CommonTools.isEmpty(name)){
            return new Response("1","用户名不能为空");
        }
        if(CommonTools.isEmpty(pwd)){
            return new Response("1","密码不能为空");
        }

        People byUserName = userRepository.findByUserName(name);
        if(byUserName!=null){
            return new Response("1","该用户已经存在");
        }
        People people=new People();
        people.setUserName(name);
        people.setUserPassword(pwd);
        People save = userRepository.save(people);

        if(save!=null){
            return new Response("0","注册成功");
        }else{
            return new Response("1","数据库插入异常");
        }

    }

    @Override
    public Response userLogin(String name, String pwd) {
        if(CommonTools.isEmpty(name)){
            return new Response("1","用户名不能为空");
        }
        if(CommonTools.isEmpty(pwd)){
            return new Response("1","密码不能为空");
        }
        People byUserName = userRepository.findByUserName(name);
        if(byUserName==null){
            return new Response("1","用户不存在");
        }

        if(byUserName.getUserPassword().equals(pwd)){
            return new Response("0",byUserName);
        }else{
            return new Response("1","密码错误");
        }
    }
}
