package com.yhtx.easy.exception;

public enum ExceptionEnum {

    NUMBERFORMAT_ERROR(500,"类型转换错误"),
    SYSTEM_ERROR(500,"系统错误，工程师正在处理中"),
    PARAM_IS_INVALID(500, "参数无效"),
    ;


    ExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
