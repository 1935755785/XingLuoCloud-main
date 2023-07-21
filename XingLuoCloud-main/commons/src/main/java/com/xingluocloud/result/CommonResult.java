package com.xingluocloud.result;

import lombok.Data;

import javax.annotation.Nullable;

/**
 * @Description: 统一封装返回数据格式
 * @Author: SJF
 * @Date: 2023/7/17
 **/
@Data
public class CommonResult <T>{

    private Integer code;
    private String message;
    private T data;

    /**
     * 构造私有化
     */
    private CommonResult(){
    }

    /**
     * 成功的返回结果:无返回数据
     */
    public static<T> CommonResult<T> ok(){
        return build(null,ResultCodeEnum.SUCCESS);
    }

    /**
     * 成功的返回结果:有返回数据
     */
    public static<T> CommonResult<T> ok(T data){
        return build(data,ResultCodeEnum.SUCCESS);
    }

    /**
     * 失败的返回结果:无返回数据
     */
    public static<T> CommonResult<T> fail(){
        return build(null,ResultCodeEnum.FAIL);
    }

    /**
     * 失败的返回结果:有返回数据
     */
    public static<T> CommonResult<T> fail(T data){
        return build(data,ResultCodeEnum.FAIL);
    }

    /**
     * 封装返回的数据
     */
    public static<T> CommonResult<T> build(@Nullable T body, ResultCodeEnum resultCodeEnum){
        CommonResult<T> result = new CommonResult<>();
        // 封装数据，数据不是必须的，要进行判断
        if(body != null){
            result.setData(body);
        }
        // 封装状态码
        result.setCode(resultCodeEnum.getCode());
        // 封装返回信息
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }

    /**
     * 自定义返回信息
     */
    public CommonResult<T> message(String msg){
        this.setMessage(msg);
        return this;
    }

    /**
     * 自定义返回状态码
     */
    public CommonResult<T> code(Integer code){
        this.setCode(code);
        return this;
    }
}
