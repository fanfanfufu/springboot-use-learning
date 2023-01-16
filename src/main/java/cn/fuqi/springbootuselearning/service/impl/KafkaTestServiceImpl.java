package cn.fuqi.springbootuselearning.service.impl;

import cn.fuqi.springbootuselearning.service.KafkaTestService;
import cn.fuqi.springbootuselearning.service.producer.TestKafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author FuQi
 * @date 2023/1/15 20:43
 * @description
 */
@Slf4j
@Service
public class KafkaTestServiceImpl implements KafkaTestService {
    @Resource
    private TestKafkaProducer kafkaProducer;

    @Override
    public void testSendMessage(String message) {
        if (StringUtils.isBlank(message)) {
            log.info("消息为空，不发送");
            return;
        }
        kafkaProducer.send(message);
    }
}
