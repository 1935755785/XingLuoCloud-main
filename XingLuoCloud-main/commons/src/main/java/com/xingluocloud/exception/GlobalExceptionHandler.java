package com.xingluocloud.exception;

import com.xingluocloud.result.CommonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.sasl.AuthenticationException;

/**
 * @Description: 全局异常处理
 * @Author: SJF
 * @Date: 2023/7/18
 **/
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 全局异常处理
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResult<Object> globalException(Exception exception){
        return CommonResult.fail().message(exception.getMessage());
    }

    /**
     * 自定义异常处理
     */
    @ExceptionHandler(value = CustomException.class)
    @ResponseBody
    public CommonResult<Object> customException(CustomException exception){
        return CommonResult.fail().message(exception.getMessage())
                .code(exception.getCode());
    }

    /**
     * 登录认证失败时抛出磁异常
     */
    @ExceptionHandler(value = AuthenticationException.class)
    @ResponseBody
    public CommonResult<Object> authenticationException(AuthenticationException exception){
        return CommonResult.fail().message("登录认证失败");
    }

}
