package com.zls.zzz.controller;

import com.zls.zzz.entity.Haocai;
import com.zls.zzz.entity.Hilist_b;
import com.zls.zzz.entity.User;
import com.zls.zzz.service.UserService;
import com.zls.zzz.tool.Excelff;
import com.zls.zzz.tool.TTT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private Excelff excelff;
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
    public List<User> findAll(){
        return userService.findAll();
    }
    @GetMapping("findOne/{id}")
    public User findOne(@PathVariable int id){
        return userService.findOne(id);
    }
    @PostMapping("/selhc27dm")
    public Hilist_b find27dmbyhilist_b(@RequestBody Hilist_b selhc27dm){
        List<Haocai> listExcel=excelff.getAllByExcel("D:\\Desktop\\中软\\work\\杨凯耗材\\12月30日新增耗材2.xls");
        System.out.println(selhc27dm);
        String a=selhc27dm.getHilistCode();

        System.out.println(userService.find27dmbyhilist_b(a));
        return userService.find27dmbyhilist_b(a);
    }

    @Autowired
    private TTT ttt;
    @ResponseBody
    @RequestMapping("test2")
    public String test(){
        ttt.kk();
        userService.findAll();
        return "shit";
    }
}
