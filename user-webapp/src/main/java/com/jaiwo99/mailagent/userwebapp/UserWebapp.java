package com.jaiwo99.mailagent.userwebapp;

import com.jaiwo99.mailagent.common.MongodbConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

/**
 * @author jaiwo99
 */
@SpringBootApplication
@Import(MongodbConfig.class)
public class UserWebapp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(UserWebapp.class, args);
    }
}
