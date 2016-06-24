package com.chinadaas.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xie on 16/6/23.
 */
public class CommonDTO {

    protected String msg = "ok";
    protected int code = 200;

    private Map<String,Object> dataMap = new HashMap<String,Object>();

    public CommonDTO setAttribute(String attName,Object attValue) {
        if(attName != null) {
            dataMap.put(attName, attValue);
        }
        return this;
    }

    public CommonDTO setError(Object error) {
        dataMap.put("error", error);
        return this;
    }

    public CommonDTO setCode(int code) {
        this.code = code;
        this.dataMap.put("code", code);
        return this;
    }

    public CommonDTO setMsg (String msg) {
        this.msg = msg;
        this.dataMap.put("msg", msg);
        return this;
    }

    public Object toDTO() {
        if(dataMap.get("msg") == null) dataMap.put("msg", msg);
        if(dataMap.get("code") == null) dataMap.put("code", code);
        return dataMap;
    }
}
