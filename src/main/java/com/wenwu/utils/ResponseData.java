package com.wenwu.utils;

import org.springframework.stereotype.Component;

/**
 * Created by lvchuan on 17/6/30.
 */
@Component
public class ResponseData {
    public int msgcode = 11111;
    public String msg = "normal";
    public Object Data = null;
    public int getMsgcode() {
        return msgcode;
    }

    public ResponseData setMsgcode(int msgcode) {
        this.msgcode = msgcode;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResponseData setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return Data;
    }

    public ResponseData setData(Object data) {
        Data = data;
        return this;
    }


}
