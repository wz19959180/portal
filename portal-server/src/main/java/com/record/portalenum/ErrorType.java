package com.record.portalenum;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum ErrorType {
    /**
     * 错误类型
     */
    OBJECT_NOT_FOUND(10000,"对象不存在"),

    INVALID_PARAMS(10001,"参数不正确"),

    result_not_exist(10002,"记录不存在"),


    ;

    /**
     * 错误码
     */
    private int code;

    /**
     * 提示信息
     */
    private String msg;
}
