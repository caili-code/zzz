package com.zls.zzz.tool;

import com.zls.zzz.entity.Haocai;
import com.zls.zzz.entity.Hilist_b;
import com.zls.zzz.entity.His_mdi_info_new;
import com.zls.zzz.service.UserService;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class Excelff {
    @Autowired
    private UserService userService;
    private static final DateTimeFormatter FORMAT_NINETEEN = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    /**
     * 查询指定目录中电子表格中所有的数据
     *
     * @param file 文件完整路径
     * @return
     */

    public List<Haocai> getAllByExcel(String file) {
        List<Haocai> list = new ArrayList<Haocai>();
        List<String> list1 = new ArrayList<String>();
        try {
            System.out.println("11111111111111-----------------------");

            Workbook rwb = Workbook.getWorkbook(new File(file));
            System.out.println("766666666666666666-----------------------");

            Sheet rs = rwb.getSheet("Sheet1");//或者rwb.getSheet(0)
            System.out.println("999999999999999999-----------------------");

            System.out.println(rs);
            System.out.println("77777777777777-----------------------");
            int clos = rs.getColumns();//得到所有的列
            int rows = rs.getRows();//得到所有的行

            System.out.println(clos + " rows:" + rows);
            for (int j = 1; j < rows; j++) {
                //第一个是列数，第二个是行数
                String hcdm = rs.getCell(0, j).getContents();
                hcdm = hcdm.replaceAll("\\s", "").
                        replaceAll("\\n", "").replaceAll("\\t", "").replaceAll("\\r", "");
                StringBuilder sb = new StringBuilder(hcdm);
                hcdm = sb.replace(0, 1, "C").toString();
                Hilist_b hb = userService.find27dmbyhilist_b(hcdm);

                if (hcdm.length() != 27 || list1.contains(hcdm) || hb != null||userService.find27byHcName(hcdm)==null) {
                    continue;
                };

                String sfxmlb = rs.getCell(5, j).getContents();
                String sfxmlb1 = sfxmlb.replaceAll("\\s", "").
                        replaceAll("\\n", "").replaceAll("\\t", "").replaceAll("\\r", "");
                System.out.println("id:" + j + " hcdm:" + hcdm + " sfxmlb:" + sfxmlb);
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

    public Boolean exportExcel(String fileName,String filePath) {
        try {
            WritableWorkbook wwb = null;
            // 创建可写入的Excel工作簿
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            //以fileName为文件名来创建一个Workbook
            wwb = Workbook.createWorkbook(file);
            // 创建工作表
            WritableSheet ws = wwb.createSheet("sheet1", 0);
            //查询数据库中所有的数据
            //List<UserInfo> list= UserService.getAllByDb();
            List<Haocai> listExcel = getAllByExcel(filePath);

            //要插入到的Excel表格的行号，默认从0开始
            Label 医保目录编码 = new Label(0, 0, "医保目录编码");//表示第
            Label 开始日期 = new Label(1, 0, "开始日期");
            Label 参保所属医保区划 = new Label(2, 0, "参保所属医保区划");
            Label 医保目录名称 = new Label(3, 0, "医保目录名称");
            Label 结束日期 = new Label(4, 0, "结束日期");
            Label 医疗收费项目类别 = new Label(5, 0, "医疗收费项目类别");
            Label 收费项目等级 = new Label(6, 0, "收费项目等级");
            Label 限制使用标志 = new Label(7, 0, "限制使用标志");
            Label 目录类别 = new Label(8, 0, "目录类别");
            Label 医疗使用标志 = new Label(9, 0, "医疗使用标志");
            Label 生育使用标志 = new Label(10, 0, "生育使用标志");
            Label 医保目录使用类别 = new Label(11, 0, "医保目录使用类别");
            Label 限复方使用类型 = new Label(12, 0, "限复方使用类型");
            Label 五笔助记码 = new Label(13, 0, "五笔助记码");
            Label 拼音助记码 = new Label(14, 0, "拼音助记码");
            Label 备注 = new Label(15, 0, "备注");
            Label 有效标志 = new Label(16, 0, "有效标志");
            Label 数据唯一记录号 = new Label(17, 0, "数据唯一记录号");
            Label 数据更新时间 = new Label(18, 0, "数据更新时间");
            Label 创建人ID = new Label(19, 0, "创建人ID");
            Label 创建人姓名 = new Label(20, 0, "创建人姓名");
            Label 数据创建时间 = new Label(21, 0, "数据创建时间");
            Label 创建机构编号 = new Label(22, 0, "创建机构编号");
            Label 经办人ID = new Label(23, 0, "经办人ID");
            Label 经办人姓名 = new Label(24, 0, "经办人姓名");
            Label 经办时间 = new Label(25, 0, "经办时间");
            Label 经办机构编号 = new Label(26, 0, "经办机构编号");
            Label 统筹区编号 = new Label(27, 0, "统筹区编号");
            Label 医保目录自付比例人员类别 = new Label(28, 0, "医保目录自付比例人员类别");
            Label 表名 = new Label(29, 0, "表名");
            Label 目录自付比例类别 = new Label(30, 0, "目录自付比例类别");
            Label 自付比例 = new Label(31, 0, "自付比例");
            Label 医保目录限价类型 = new Label(32, 0, "医保目录限价类型");
            Label 医保目录超限处理方式 = new Label(33, 0, "医保目录超限处理方式");
            Label 医保目录定价上限金额 = new Label(34, 0, "医保目录定价上限金额");
            ws.addCell(医保目录编码);
            ws.addCell(开始日期);
            ws.addCell(参保所属医保区划);
            ws.addCell(医保目录名称);
            ws.addCell(结束日期);
            ws.addCell(医疗收费项目类别);
            ws.addCell(收费项目等级);
            ws.addCell(限制使用标志);
            ws.addCell(目录类别);
            ws.addCell(医疗使用标志);
            ws.addCell(生育使用标志);
            ws.addCell(医保目录使用类别);
            ws.addCell(限复方使用类型);
            ws.addCell(五笔助记码);
            ws.addCell(拼音助记码);
            ws.addCell(备注);
            ws.addCell(有效标志);
            ws.addCell(数据唯一记录号);
            ws.addCell(数据更新时间);
            ws.addCell(创建人ID);
            ws.addCell(创建人姓名);
            ws.addCell(数据创建时间);
            ws.addCell(创建机构编号);
            ws.addCell(经办人ID);
            ws.addCell(经办人姓名);
            ws.addCell(经办时间);
            ws.addCell(经办机构编号);
            ws.addCell(统筹区编号);
            ws.addCell(医保目录自付比例人员类别);
            ws.addCell(表名);
            ws.addCell(目录自付比例类别);
            ws.addCell(自付比例);
            ws.addCell(医保目录限价类型);
            ws.addCell(医保目录超限处理方式);
            ws.addCell(医保目录定价上限金额);
            for (int i=0;i<listExcel.size();i++) {
                Haocai hc=listExcel.get(i);

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
                String id = UUID.randomUUID().toString();
                //替换uuid中的"-"
                id = id.replace("-", "");
                System.out.println(id);
                System.out.println(FORMAT_NINETEEN.format(LocalDateTime.now()));

                    Label 医保目录编码1 = new Label(0, i + 1, hc.getHcdm());
                    Label 开始日期1 = new Label(1, i + 1, "2021-01-01 00:00:00");
                    Label 参保所属医保区划1 = new Label(2, i + 1, "610400");
                    Label 医保目录名称1 = new Label(3, i + 1, userService.find27byHcName(hc.getHcdm()).get单件产品名称());
                    Label 结束日期1 = new Label(4, i + 1, " ");
                    Label 医疗收费项目类别1 = new Label(5, i + 1, "1401");
                    Label 收费项目等级1 = new Label(6, i + 1, sfxmdj);
                    Label 限制使用标志1 = new Label(7, i + 1, "0");
                    Label 目录类别1 = new Label(8, i + 1, "301");
                    Label 医疗使用标志1 = new Label(9, i + 1, "1");
                    Label 生育使用标志1 = new Label(10, i + 1, "1");
                    Label 医保目录使用类别1 = new Label(11, i + 1, "0");
                    Label 限复方使用类型1 = new Label(12, i + 1, "9");
                    Label 五笔助记码1 = new Label(13, i + 1, " ");
                    Label 拼音助记码1 = new Label(14, i + 1, " ");
                    Label 备注1 = new Label(15, i + 1, " ");
                    Label 有效标志1 = new Label(16, i + 1, "1");
                    Label 数据唯一记录号1 = new Label(17, i + 1, id);
                    Label 数据更新时间1 = new Label(18, i + 1, FORMAT_NINETEEN.format(LocalDateTime.now()));
                    Label 创建人ID1 = new Label(19, i + 1, "pingan");
                    Label 创建人姓名1 = new Label(20, i + 1, "数据迁移");
                    Label 数据创建时间1 = new Label(21, i + 1, FORMAT_NINETEEN.format(LocalDateTime.now()));
                    Label 创建机构编号1 = new Label(22, i + 1, "610400");
                    Label 经办人ID1 = new Label(23, i + 1, "pingan");
                    Label 经办人姓名1 = new Label(24, i + 1, "数据迁移");
                    Label 经办时间1 = new Label(25, i + 1, FORMAT_NINETEEN.format(LocalDateTime.now()));
                    Label 医保目录定价上限金额1 = new Label(34, i + 1, "0");
                    Label 经办机构编号1 = new Label(26, i + 1, "610400");
                    Label 统筹区编号1 = new Label(27, i + 1, "610400");
                    Label 医保目录自付比例人员类别1 = new Label(28, i + 1, "390");
                    Label 表名1 = new Label(29, i + 1, "YIYONGHAOCAI");
                    Label 目录自付比例类别1 = new Label(30, i + 1, "10");
                    Label 自付比例1 = new Label(31, i + 1, zfbl);
                    Label 医保目录限价类型1 = new Label(32, i + 1, "0");
                    Label 医保目录超限处理方式1 = new Label(33, i + 1, "1");
                    ws.addCell(医保目录编码1);
                    ws.addCell(开始日期1);
                    ws.addCell(参保所属医保区划1);
                    ws.addCell(医保目录名称1);
                    ws.addCell(结束日期1);
                    ws.addCell(医疗收费项目类别1);
                    ws.addCell(收费项目等级1);
                    ws.addCell(限制使用标志1);
                    ws.addCell(目录类别1);
                    ws.addCell(医疗使用标志1);
                    ws.addCell(生育使用标志1);
                    ws.addCell(医保目录使用类别1);
                    ws.addCell(限复方使用类型1);
                    ws.addCell(五笔助记码1);
                    ws.addCell(拼音助记码1);
                    ws.addCell(备注1);
                    ws.addCell(有效标志1);
                    ws.addCell(数据唯一记录号1);
                    ws.addCell(数据更新时间1);
                    ws.addCell(创建人ID1);
                    ws.addCell(创建人姓名1);
                    ws.addCell(数据创建时间1);
                    ws.addCell(创建机构编号1);
                    ws.addCell(经办人ID1);
                    ws.addCell(经办人姓名1);
                    ws.addCell(经办时间1);
                    ws.addCell(经办机构编号1);
                    ws.addCell(统筹区编号1);
                    ws.addCell(医保目录自付比例人员类别1);
                    ws.addCell(表名1);
                    ws.addCell(目录自付比例类别1);
                    ws.addCell(自付比例1);
                    ws.addCell(医保目录限价类型1);
                    ws.addCell(医保目录超限处理方式1);
                    ws.addCell(医保目录定价上限金额1);
                }



            //写进文档
            wwb.write();
            // 关闭Excel工作簿对象
            wwb.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
