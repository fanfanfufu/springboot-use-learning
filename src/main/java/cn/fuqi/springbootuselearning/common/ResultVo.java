package cn.fuqi.springbootuselearning.common;

import lombok.Getter;
import lombok.Setter;

/**
 * @author FuQi
 * @date 2021/11/23 22:48
 * @description 统一封装的返回数据对象
 */
@Getter
@Setter
public class ResultVo<T> {
    private int code;

    private String message;

    private T data;

    public ResultVo() {
    }

    public ResultVo(int code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    public ResultVo(T data) {
        this.code = CommonConstant.SUCCESS_CODE;
        this.message = null;
        this.data = data;
    }
}
