package com.xingluocloud.entity.base.device;

import com.xingluocloud.entity.common.Base;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Device extends Base {
    //设备id
    private String devId;
    //设备名称
    private String devName;
    //设备类型
    private String devType;
    //设备型号
    private String devModel;
    //设备序列号
    private String devNumber;
    //上次维护日期
    private String lastDate;
    //预计下次维护日期
    private String nextDate;
    //设备状态
    private String devStatus;

}
