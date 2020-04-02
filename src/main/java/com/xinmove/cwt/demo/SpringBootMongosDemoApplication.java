package com.xinmove.cwt.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

//@EnableConfigurationProperties({Test1MongoConfig.class, Test2MongoConfig.class, Test3MongoConfig.class})
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class SpringBootMongosDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongosDemoApplication.class, args);
    }

}
