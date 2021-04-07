package com.yhtx.easy.result;

public class SuccessResponseData extends ResponseData {
    public SuccessResponseData() {
        super(Boolean.TRUE, "200", "请求成功", (Object)null);
    }

    public SuccessResponseData(Object object) {
        super(Boolean.TRUE, "200", "请求成功", object);
    }

    public SuccessResponseData(String code, String message, Object object) {
        super(Boolean.TRUE, code, message, object);
    }
}
