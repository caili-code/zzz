package com.zls.zzz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@MapperScan("com.zls.zzz.mapper")
public class ZzzApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZzzApplication.class, args);
        System.out.println("启动成功");
    }

}
