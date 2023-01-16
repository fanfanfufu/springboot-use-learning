package cn.fuqi.springbootuselearning.controller;

import cn.fuqi.springbootuselearning.service.KafkaTestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author FuQi
 * @date 2023/1/15 20:44
 * @description
 */
@Slf4j
@RestController
@RequestMapping("/kafka")
@Api(tags = "Kafka练习使用接口集合")
public class KafkaTestController {
    @Resource
    private KafkaTestService kafkaService;

    @ApiOperation("测试发送Kafka消息")
    @GetMapping("/test/send")
    public void testSendMessage(@RequestParam(value = "message", required = false) String message) {
        kafkaService.testSendMessage(message);
    }
}
