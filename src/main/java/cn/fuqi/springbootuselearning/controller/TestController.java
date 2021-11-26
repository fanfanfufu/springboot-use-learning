package cn.fuqi.springbootuselearning.controller;

import cn.fuqi.springbootuselearning.common.ApplicationException;
import cn.fuqi.springbootuselearning.common.ResultVo;
import cn.fuqi.springbootuselearning.common.enums.ErrorCodeEnum;
import cn.fuqi.springbootuselearning.pojo.vo.UserVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FuQi
 * @date 2021/11/23 23:01
 * @description
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public ResultVo<String> sayHello() {
        String words = "hello, spring boot.";
        return new ResultVo<>(words);
    }

    @GetMapping("/result/auto/package1")
    public String autoPackageResultTest1() {
        return "自动封装返回结果测试";
    }

    @GetMapping("/result/auto/package2")
    public UserVo autoPackageResultTest2() {
        return new UserVo().setId(1L).setUserId("486668455").setUsername("张无忌").setGender(1).setAge(23).setHobby("女");
    }

    @GetMapping("/exception/test1")
    public void testApplicationException() throws ApplicationException {
        throw new ApplicationException(ErrorCodeEnum.ILLEGAL_PARAM);
    }

    @GetMapping("/exception/test2")
    public void testException() {
        throw new NullPointerException();
    }
}
