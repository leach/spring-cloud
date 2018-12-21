package com.anythy.base.configure.common;

import com.anythy.base.common.base.BusinessException;
import com.anythy.base.common.base.BusinessException.Errors;
import com.anythy.base.common.base.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;

/**
 * 统一异常处理
 * @author Leach
 */
@RestControllerAdvice
@ResponseStatus(HttpStatus.OK)
public class CommonExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public CommonExceptionHandler() {
    }

    @ExceptionHandler
    public Object handleBusinessException(BusinessException ex, HttpServletRequest request) {
        this.logger.warn("[REQUEST EXCEPTION] uri: {}, message: {}", request.getRequestURI(), ex.getMessage());
        return CommonResult.fail(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public Object handleIllegalArgumentException(IllegalArgumentException ex, HttpServletRequest request) {
        this.logger.warn("[REQUEST EXCEPTION] uri: {}, message: {}", request.getRequestURI(), ex.getMessage());
        return CommonResult.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
    }

    @ExceptionHandler({ValidationException.class})
    public Object handleValidationException(ValidationException ex, HttpServletRequest request) {
        this.logger.warn("[REQUEST EXCEPTION] uri: {}, message: {}", request.getRequestURI(), ex.getMessage());
        return CommonResult.fail(Errors.UN_PROCESSABLE.getCode(), ex.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        this.logger.warn("[REQUEST EXCEPTION] uri: {}, message: {}", request.getRequestURI(), ex.getMessage());
        return CommonResult.fail(Errors.UN_PROCESSABLE.getCode(), ex.getMessage());
    }

    @ExceptionHandler({Exception.class})
    public Object handleException(Exception ex, HttpServletRequest request) {
        this.logger.warn("[REQUEST EXCEPTION] uri: {}, message: {}", request.getRequestURI(), ex.getMessage());
        return CommonResult.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
    }
}
