package cn.fuqi.springbootuselearning.config.exception;

import cn.fuqi.springbootuselearning.common.ApplicationException;
import cn.fuqi.springbootuselearning.common.CommonConstant;
import cn.fuqi.springbootuselearning.common.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author FuQi
 * @date 2021/11/26 23:12
 * @description
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理自定义异常
     *
     * @param exception ApplicationException
     * @return
     */
    @ExceptionHandler({ApplicationException.class})
    public ResultVo<?> handleApplicationException(ApplicationException exception) {
        ServletRequestAttributes requestAttributes =(ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        log.error("request = {} occur an application exception,\r\ncode={}, \r\nmessage: {}",
                requestAttributes.getRequest().getRequestURI(), exception.getCode(), exception.getErrorMsg());
        return new ResultVo<>(exception.getCode(), exception.getErrorMsg());
    }

    /**
     * 处理所有异常
     *
     * @param exception Exception
     * @return
     */
    @ExceptionHandler({Exception.class})
    public ResultVo<?> handleException(Exception exception) {
        ServletRequestAttributes requestAttributes =(ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        log.error("request = {} occur an exception, \r\nmessage type = {}, \r\nmessage content: {}",
                requestAttributes.getRequest().getRequestURI(), exception.getClass(), exception.getLocalizedMessage());
        return new ResultVo<>(CommonConstant.ERROR_CODE, exception.getMessage());
    }
}
