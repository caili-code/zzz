package com.zls.zzz;

import com.zls.zzz.entity.Haocai;
import com.zls.zzz.entity.Hilist_b;
import com.zls.zzz.service.UserService;
import com.zls.zzz.tool.Excelff;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ZzzApplicationTests {
    @Autowired
    UserService userService;
    @Autowired
    Excelff excelff;
    @Test
    void contextLoads() {
        System.out.println(1234);
        List<Haocai> listExcel=excelff.getAllByExcel("D:\\Desktop\\中软\\work\\杨凯耗材\\12月30日新增耗材2.xls");
        System.out.println(listExcel);


    }

    @Test
    void contextLoads1() {
        Hilist_b bl=userService.find27dmbyhilist_b("大老板11");
        System.out.println("gg");

        System.out.println(bl);
        //System.out.println(listExcel);


    }

}
