package com.record.portalexception;

import com.record.portalenum.ErrorType;
import lombok.Getter;
@Getter
public class PortalException extends RuntimeException{
    private Integer code;

    /**
     * 使用已有的错误类型
     * @param type 枚举类中的错误类型
     */
    public PortalException(ErrorType type){
        super(type.getMsg());
        this.code = type.getCode();
    }

    /**
     * 自定义错误类型
     * @param code 自定义的错误码
     * @param msg 自定义的错误提示
     */
    public PortalException(Integer code, String msg){
        super(msg);
        this.code = code;
    }
}
