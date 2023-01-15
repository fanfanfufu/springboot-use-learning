package cn.fuqi.springbootuselearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class SpringbootUseLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootUseLearningApplication.class, args);
    }

}
