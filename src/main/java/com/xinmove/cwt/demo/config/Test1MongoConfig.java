package com.xinmove.cwt.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
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
    public @Bean(name = "test1MongoTemplate") MongoTemplate getMongoTemplate(MongoMappingContext context) {
        //去除_class
        MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(createFactory()), context);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return new MongoTemplate(createFactory(), converter);
    }
}
