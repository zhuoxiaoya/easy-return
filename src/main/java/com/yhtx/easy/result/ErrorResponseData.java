package com.yhtx.easy.result;

public class ErrorResponseData extends ResponseData {

    public ErrorResponseData(String code, String message) {
        super(Boolean.FALSE, code, message, (Object)null);
    }

    public ErrorResponseData(String code, String message, Object object) {
        super(Boolean.FALSE, code, message, object);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ErrorResponseData;
    }

}

