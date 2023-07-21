package com.xingluocloud.entity.base.device;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DeviceUtils {
    private static int dailyCounter = 0;

    public static String generateDeviceNumber() {
        String prefix = "M"; // 假设使用"M"作为产品编号前缀
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String date = dateFormat.format(new Date());
        String productNumber = prefix + date + String.format("%03d", dailyCounter);
        dailyCounter++;
        return productNumber;
    }
}
