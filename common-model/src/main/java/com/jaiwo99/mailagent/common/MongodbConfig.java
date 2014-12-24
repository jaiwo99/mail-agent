package com.jaiwo99.mailagent.common;

import com.mongodb.WriteConcern;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author jaiwo99
 */
@Configuration
@ComponentScan
@EnableMongoRepositories
@EnableMongoAuditing
@PropertySource("classpath:/mongo.properties")
public class MongodbConfig {

    @Value("${mongodb.host}")
    String host;
    @Value("${mongodb.port}")
    int port;
    @Value("${mongodb.database}")
    String database;

    @Bean
    MongoFactoryBean mongoFactoryBean() {
        final MongoFactoryBean mongoFactoryBean = new MongoFactoryBean();
        mongoFactoryBean.setWriteConcern(WriteConcern.SAFE);
        mongoFactoryBean.setHost(host);
        mongoFactoryBean.setPort(port);
        return mongoFactoryBean;
    }

    @Bean
    MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(mongoFactoryBean().getObject(), database);
    }
}
