package com.xingluocloud.entity.base.material;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MaterialUtils {

    private static int dailyCounter = 0;

    public static String generateMaterialNumber() {
        String prefix = "M"; // 假设使用"M"作为物料编号前缀
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String date = dateFormat.format(new Date());
        String materialNumber = prefix + date + String.format("%03d", dailyCounter);
        dailyCounter++;
        return materialNumber;
    }

//    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            String materialNumber = generateMaterialNumber();
//            System.out.println("生成的物料编号：" + materialNumber);
//        }
//    }
}
