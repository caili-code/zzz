package com.zls.zzz.tool;

import com.zls.zzz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TTT {
    @Autowired
    private UserService userService;

    public void kk (){
        userService.findAll();
    }

}
