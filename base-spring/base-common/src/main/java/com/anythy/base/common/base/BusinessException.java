package com.anythy.base.common.base;

/**
 * 统一异常处理
 * @author Leach
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private int code;
    private String message;

    public BusinessException() {
        this(BusinessException.Errors.DEFAULT_ERROR.getCode(), BusinessException.Errors.DEFAULT_ERROR.getMessage());
    }

    public BusinessException(BusinessException.Errors error) {
        this(error.getCode(), error.getMessage());
    }

    public BusinessException(String message) {
        this(BusinessException.Errors.DEFAULT_ERROR.getCode(), message);
    }

    public BusinessException(BusinessException.Errors error, String message) {
        this(error.getCode(), message);
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static enum Errors {
        UN_PROCESSABLE(400, "非法请求"),
        DEFAULT_ERROR(700, "内部错误"),
        DATA_EXISTS(901, "记录已存在")
        ;

        private int code;
        private String message;

        private Errors(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }
    }
}
