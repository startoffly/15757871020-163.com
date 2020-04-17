package com.xinmove.cwt.demo.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.xinmove.cwt.demo.utils.MD5Util;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;


/**
 * @Auther: CWT
 * @Date: 2020/4/2 11:25
 * @Description:
 */
public abstract class AbstractMongoConfig {
    private static final Map<String, MongoClient> clientUriPool = new HashMap<>();

    public static final int DEFAULT_PORT = 27017;
    public static final String DEFAULT_URI = "mongodb://localhost/test";
    private String host = null;
    private Integer port = null;
    private String uri;
    private String database;
    private String authenticationDatabase;
    private String gridFsDatabase;
    private String username;
    private char[] password;
    private Class<?> fieldNamingStrategy;
    private Boolean autoIndexCreation;

    MongoDbFactory createFactory(){
        MongoClient mongoClient = null;
        //此处仅实现了uri创建方式
        if (nonNull(uri)){
            String key = MD5Util.getMD5(uri);
            if (clientUriPool.containsKey(key)){
                mongoClient = clientUriPool.get(key);
            }else {
                mongoClient = MongoClients.create(uri);
                clientUriPool.put(key,mongoClient);
            }
        }
        //MongoClient创建,也可使用host port方式创建
        return new SimpleMongoClientDbFactory(mongoClient, database);
    }


    abstract public MongoTemplate getMongoTemplate(MongoMappingContext context);

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getAuthenticationDatabase() {
        return authenticationDatabase;
    }

    public void setAuthenticationDatabase(String authenticationDatabase) {
        this.authenticationDatabase = authenticationDatabase;
    }

    public String getGridFsDatabase() {
        return gridFsDatabase;
    }

    public void setGridFsDatabase(String gridFsDatabase) {
        this.gridFsDatabase = gridFsDatabase;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public Class<?> getFieldNamingStrategy() {
        return fieldNamingStrategy;
    }

    public void setFieldNamingStrategy(Class<?> fieldNamingStrategy) {
        this.fieldNamingStrategy = fieldNamingStrategy;
    }

    public Boolean getAutoIndexCreation() {
        return autoIndexCreation;
    }

    public void setAutoIndexCreation(Boolean autoIndexCreation) {
        this.autoIndexCreation = autoIndexCreation;
    }
}
