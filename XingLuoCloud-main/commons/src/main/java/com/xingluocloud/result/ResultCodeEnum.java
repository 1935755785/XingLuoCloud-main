package com.xingluocloud.result;

import lombok.Getter;

/**
 * @Description: 响应返回值枚举类
 * @Author: SJF
 * @Date: 2023/7/17
 **/
@Getter
public enum ResultCodeEnum {
    // 响应成功
    SUCCESS(200,"成功"),
    // 响应失败
    FAIL(400,"失败"),
    ;

    /**
     * 响应状态码
     */
    private final Integer code;
    /**
     * 具体信息
     */
    private final String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
