package com.dian.mvp_dome.bean;




public class BaseObjectBean<T> {

    /**
     * status : 1
     * msg : 获取成功
     * result : {} 对象
     */

    private int status;
    private String message;
    private T result;

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

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
