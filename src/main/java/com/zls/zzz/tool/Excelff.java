package com.zls.zzz.tool;

import com.zls.zzz.entity.Haocai;
import com.zls.zzz.entity.Hilist_b;
import com.zls.zzz.service.UserService;
import jxl.Sheet;
import jxl.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
@Component
public class Excelff {
    @Autowired
    private UserService userService;

    /**
     * 查询指定目录中电子表格中所有的数据
     * @param file 文件完整路径
     * @return
     */

    public  List<Haocai> getAllByExcel(String file){
        List<Haocai> list=new ArrayList<Haocai>();
        List<String> list1=new ArrayList<String>();
        try {
            Workbook rwb=Workbook.getWorkbook(new File(file));
            Sheet rs=rwb.getSheet("Sheet1");//或者rwb.getSheet(0)
            int clos=rs.getColumns();//得到所有的列
            int rows=rs.getRows();//得到所有的行

            System.out.println(clos+" rows:"+rows);
                for ( int j = 1; j < rows; j++) {
                    //第一个是列数，第二个是行数
                    String hcdm=rs.getCell(0, j).getContents();
                    hcdm = hcdm.replaceAll("\\s","").
                            replaceAll("\\n","").replaceAll("\\t","").replaceAll("\\r","");
                    StringBuilder sb = new StringBuilder(hcdm);
                    hcdm=sb.replace(0,1,"C").toString();
                    Hilist_b hb=userService.find27dmbyhilist_b(hcdm);
                    if(hcdm.length()!=27||list1.contains(hcdm)||hb!=null){
                        continue;
                    };

                    String sfxmlb=rs.getCell(5, j).getContents();
                    String sfxmlb1 = sfxmlb.replaceAll("\\s","").
                            replaceAll("\\n","").replaceAll("\\t","").replaceAll("\\r","");
                    System.out.println("id:"+j+" hcdm:"+hcdm+" sfxmlb:"+sfxmlb);
                    list.add(new Haocai(Integer.parseInt(String.valueOf(j)), hcdm, sfxmlb1));
                    list1.add(hcdm);
                    System.out.println(list);
                    System.out.println(list.size());
                    System.out.println(list1);
                    System.out.println(list1.size());

                }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;

    }
}
