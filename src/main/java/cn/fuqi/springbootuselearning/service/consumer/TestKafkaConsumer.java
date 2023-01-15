package cn.fuqi.springbootuselearning.service.consumer;

import cn.fuqi.springbootuselearning.service.producer.TestKafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author FuQi
 * @date 2023/1/15 20:38
 * @description
 */
@Slf4j
@Component
public class TestKafkaConsumer {

    @KafkaListener(topics = TestKafkaProducer.TOPIC_NAME, groupId = "test-kafka")
    public void receive(String message) {
        log.info("receive the {} message from {}", message, TestKafkaProducer.TOPIC_NAME);
    }
}
