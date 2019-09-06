package com.dian.mvp_dome.bean;

import java.util.List;


public class BaseArrayBean<T> {

    /**
     * status : 1
     * msg : 获取成功
     * result : [] 数组
     */

    private int status;
    private String message;
    private List<T> result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
