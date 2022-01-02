package com.zls.zzz.controller;

import com.zls.zzz.entity.User;
import com.zls.zzz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/add")
    public Boolean add(@RequestBody User user){
        System.out.println(1111);
        return userService.add(user);
    }

    @RequestMapping("/test")
    public String TEST(User user){
        System.out.println(1111);
        return "hello";
    }
    @GetMapping("del/{id}")
    public Boolean del(@PathVariable int id){
        return userService.del(id);
    }
    @PostMapping("edit")
    public Boolean edit(User user){
        return userService.edit(user);
    }
    @GetMapping("findAll")
    public User findAll(){
        return userService.findAll();
    }
    @GetMapping("findOne/{id}")
    public User findOne(@PathVariable int id){
        return userService.findOne(id);
    }

}
