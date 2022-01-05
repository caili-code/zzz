package com.zls.zzz;

import com.zls.zzz.entity.Haocai;
import com.zls.zzz.entity.Hilist_b;
import com.zls.zzz.entity.His_mdi_info_new;
import com.zls.zzz.service.UserService;
import com.zls.zzz.tool.Excelff;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class ZzzApplicationTests {
    @Autowired
    UserService userService;
    @Autowired
    Excelff excelff;

    @Test
    void contextLoads() {
        System.out.println(1234);
        List<Haocai> listExcel = excelff.getAllByExcel("D:\\Desktop\\中软\\work\\杨凯耗材\\12月30日新增耗材2.xls");
        System.out.println("contextloads____________________________________________________");
        System.out.println(listExcel);
        for (Haocai userInfo : listExcel) {
            System.out.println(userInfo.getHcdm());
        }


    }

    @Test
    void contextLoads1() {
        Hilist_b bl = userService.find27dmbyhilist_b("C01022600700007101480000051");
        System.out.println("gg");

        System.out.println(bl);
        //System.out.println(listExcel);


    }

    @Test
    void contextLoads2() {
        List<Haocai> listExcel = excelff.getAllByExcel("D:\\Desktop\\中软\\work\\杨凯耗材\\12月30日新增耗材2.xls");

        for (Haocai hc : listExcel) {
            His_mdi_info_new hmin = new His_mdi_info_new();
            hmin.set医保目录编码(hc.getHcdm());
            String sfxmdj = null;
            String zfbl = null;
            switch (hc.getSfxmlb()) {
                case "甲类":
                    sfxmdj = "01";
                    zfbl = "0";
                    break;
                case "乙类":
                    sfxmdj = "02";
                    zfbl = "0.2";
                    break;
                case "丙类":
                    sfxmdj = "03";
                    zfbl = "1";
                    break;
                default:
                    System.out.println("default");
            }
            hmin.set自付比例(zfbl);
            hmin.set收费项目等级(sfxmdj);
            userService.addHc(hmin);

        }
    }

    @Test
    void contextLoads3() {
        System.out.println("haha-----------------------------------------");
        System.out.println(userService.find27byHcName("C01010100101007049370004483"));


    }

    @Test
    void contextLoads4() {
        //生成唯一id
        String id = UUID.randomUUID().toString();
        //替换uuid中的"-"
        id = id.replace("-", "");
        System.out.println(id);


    }

    private static final DateTimeFormatter FORMAT_NINETEEN = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Test
    void contextLoads5() {
        System.out.println(FORMAT_NINETEEN.format(LocalDateTime.now()));
    }

    @Test
    void contextLoads6() {

        Boolean b=excelff.exportExcel("E:\\hcrk\\999.xls","D:\\Desktop\\中软\\work\\杨凯耗材\\1月4日新增耗材3.xls");
        System.out.println(b);
    }



}
