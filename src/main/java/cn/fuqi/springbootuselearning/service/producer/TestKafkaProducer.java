package cn.fuqi.springbootuselearning.service.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author FuQi
 * @date 2023/1/15 20:34
 * @description
 */
@Component
@Slf4j
public class TestKafkaProducer {
    public static final String TOPIC_NAME = "test_kafka";

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message) {
        kafkaTemplate.send(TOPIC_NAME, message);
        log.info("producer send {} message to {}.", message, TOPIC_NAME);
    }
}
