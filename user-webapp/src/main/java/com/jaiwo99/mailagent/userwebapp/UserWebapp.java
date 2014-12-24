package com.jaiwo99.mailagent.userwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * @author jaiwo99
 */
@SpringBootApplication
public class UserWebapp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(UserWebapp.class, args);
    }
}
