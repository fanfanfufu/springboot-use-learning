package cn.fuqi.springbootuselearning.controller;

import cn.fuqi.springbootuselearning.common.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 监听器测试控制器
 * 
 * @author fuqi
 * @date 2024-01-01
 */
@Slf4j
@RestController
@RequestMapping("/listener")
@Api(tags = "监听器测试接口")
public class ListenerTestController {

    @GetMapping("/test")
    @ApiOperation("测试监听器功能")
    public ResultVo<String> testListener() {
        log.info("监听器测试接口被调用");
        return new ResultVo<>("监听器功能正常，请查看启动日志确认监听器是否正常工作");
    }
    
    @GetMapping("/info")
    @ApiOperation("获取监听器信息")
    public ResultVo<String> getListenerInfo() {
        String info = "本应用包含以下启动监听器：\n" +
                     "1. ApplicationStartupListener - 实现ApplicationListener接口\n" +
                     "2. SimpleStartupListener - 使用@EventListener注解\n" +
                     "\n启动应用时，这些监听器会在应用启动完成后自动执行自定义逻辑。";
        
        return new ResultVo<>(info);
    }
} 