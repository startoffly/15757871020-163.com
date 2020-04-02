package com.xinmove.cwt.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @Auther: CWT
 * @Date: 2020/4/2 11:38
 */
@Configuration
@ConfigurationProperties(prefix = "spring.data.mongodb.test3")
public class Test3MongoConfig extends AbstractMongoConfig{

    @Primary
    @Override
    public @Bean(name = "test3MongoTemplate") MongoTemplate getMongoTemplate() {
        return new MongoTemplate(createFactory());
    }
}
