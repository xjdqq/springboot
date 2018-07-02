package com.how2java.springboot.common.result;

import java.util.List;

public class BizResult<T> {
    // 返回单个结果
    T result;

    // 返回多个结果
    List<T> results;

    // 返回成功码
    String code;

    // 返回信息
    String msg;

    // 是否成功
    boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
