package com.example.cxfdemo.service;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Model<T> {

    public static <T> Model<T> newSuccess(T data) {
        if (data == null) {
            return new Model<T>().setSuccess(false).setMsg("数据不存在");
        }
        return new Model<T>().setData(data).setSuccess(true);
    }

    public static <T> Model<T> newFail(String msg) {
        return new Model<T>().setMsg(msg).setSuccess(false);
    }


    public static <T> Model<T> newSuccess(String msg, Boolean isSuccess) {
        return new Model<T>().setMsg(msg).setSuccess(isSuccess);
    }

    private boolean success = false;

    private String msg = "";

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public boolean isSuccess() {
        return success;
    }

    public Model<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Model<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public Model<T> setData(T data) {
        this.data = data;
        return this;
    }

}
