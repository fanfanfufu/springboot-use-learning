package cn.fuqi.springbootuselearning.common;

import cn.fuqi.springbootuselearning.common.enums.ErrorCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author FuQi
 * @date 2021/11/26 22:55
 * @description 自定义异常
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ApplicationException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = -3171193035578536116L;

    /**
     * 错误状态码
     */
    private final Integer code;

    /**
     * 报错信息
     */
    private final String errorMsg;

    public ApplicationException(Integer code, String errorMsg) {
        this.code = code;
        this.errorMsg = errorMsg;
    }

    public ApplicationException(ErrorCodeEnum errorCodeEnum) {
        this.code = errorCodeEnum.getCode();
        this.errorMsg = errorCodeEnum.getErrorMsg();
    }

    public ApplicationException(Throwable throwable) {
        super(throwable);
        this.code = CommonConstant.ERROR_CODE;
        this.errorMsg = throwable.getMessage();
    }
}
