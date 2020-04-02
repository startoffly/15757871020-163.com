package com.xinmove.cwt.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * @Auther: CWT
 * @Date: 2020/4/2 11:38
 */
@Configuration
@ConfigurationProperties(prefix = "spring.data.mongodb.test1")
public class Test1MongoConfig extends AbstractMongoConfig{

    @Primary
    @Override
    public @Bean(name = "test1MongoTemplate") MongoTemplate getMongoTemplate() {
        return new MongoTemplate(createFactory());
    }
}
