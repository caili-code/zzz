package com.zls.zzz.service;


import com.zls.zzz.entity.Hilist_b;
import com.zls.zzz.entity.His_mdi_info_new;
import com.zls.zzz.entity.Mcs_info_b_all_wq;
import com.zls.zzz.entity.User;
import com.zls.zzz.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserMapper userMapper;
    public Boolean add(User user){
        Boolean bl=userMapper.add(user);
        System.out.println(22222);
        System.out.println(bl);
        return bl;
    }
    public Boolean addHc(His_mdi_info_new hmin){
        Boolean bl=userMapper.addHc(hmin);
        System.out.println(22222);
        System.out.println(bl);
        return bl;
    }
    public Boolean del(int id){
        return userMapper.del(id);

    }
    public Boolean edit(User user){
        return userMapper.edit(user);
    }
    public List<User> findAll(){
        return userMapper.findAll();
    }
    public User findOne(int id){
        return userMapper.findOne(id);
    }
    public Hilist_b find27dmbyhilist_b(String hc27dm){
        System.out.println(387);
        System.out.println(userMapper.find27dmbyhilist_b(hc27dm));

        return userMapper.find27dmbyhilist_b(hc27dm);
    }
    public Mcs_info_b_all_wq find27byHcName(String hc27dm){
        return userMapper.find27byHcName(hc27dm);
    }

}
