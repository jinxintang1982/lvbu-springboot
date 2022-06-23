package com.sanguo.springboot.entity;

public class BaseResponse {
    public BaseResponse(Boolean success, Integer code, String errorMsg) {
        this.success = success;
        this.code = code;
        this.errorMsg = errorMsg;
    }

    private Boolean success = false;
    private Integer code = null;
    private String errorMsg= null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
