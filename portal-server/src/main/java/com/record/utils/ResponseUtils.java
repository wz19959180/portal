package com.record.utils;

import com.record.entity.Response;

public class ResponseUtils {
    /**
     * 调用成功
     */
    private static final String SUCCESS = "调用成功！";

    public static Response success(Object obj){
        Response res = new Response();
        res.setCode(200);
        res.setData(obj);
        res.setMessage(SUCCESS);
        return res;
    }

    public static Response success(){
        return success(null);
    }

    public static Response error(Integer code, String msg){
        Response res = new Response();
        res.setCode(code);
        res.setMessage(msg);
        return res;
    }

}
