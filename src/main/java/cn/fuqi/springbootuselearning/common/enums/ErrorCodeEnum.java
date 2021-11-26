package cn.fuqi.springbootuselearning.common.enums;

import lombok.Getter;

/**
 * @author FuQi
 * @date 2021/11/26 23:01
 * @description
 */
@Getter
public enum ErrorCodeEnum {
    /**
     * 自定义异常枚举
     */
    UNKNOWN_ERROR(500, "系统未知错误"),
    ILLEGAL_PARAM(1001, "参数错误"),
    ;

    private final Integer code;

    private final String errorMsg;

    ErrorCodeEnum(Integer code, String errorMsg) {
        this.code = code;
        this.errorMsg = errorMsg;
    }
}
