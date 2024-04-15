package com.record.portalHandler;
import com.record.entity.Response;
import com.record.portalexception.PortalException;
import com.record.utils.ResponseUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: wz
 * @Date: 2024-04-14 10:11
 * @Description:
 */

@ControllerAdvice
public class ServiceExceptionHandler {

    /**
     * @ExceptionHandler相当于controller的@RequestMapping
     * 如果抛出的的是ServiceException，则调用该方法
     * @param se 业务异常
     * @return
     */
    @ExceptionHandler(PortalException.class)
    @ResponseBody
    public Response handle(PortalException se){
        return ResponseUtils.error(se.getCode(),se.getMessage());
    }
}