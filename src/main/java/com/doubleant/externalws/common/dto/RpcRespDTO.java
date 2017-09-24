package com.doubleant.externalws.common.dto;

import com.doubleant.externalws.common.constant.ResultCommonConstant;

import java.io.Serializable;

/**
 * Created by Administrator
 * on 2017/9/23.
 */
public class RpcRespDTO<T> implements Serializable{

    private static final long serialVersionUID = -3384289257248979426L;

    private String code;

    private String msg;

    private T data;

    public RpcRespDTO() {}

    public RpcRespDTO(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public RpcRespDTO(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 判断结果
     * @return
     */
    public boolean isSuccess(){
        return ResultCommonConstant.CODE_SUCCESS.equals(code) ? true : false;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
