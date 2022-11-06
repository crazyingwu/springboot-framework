package com.crazywu.service.apollo.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Value("${age:101}")
    private int age;


    public int getAge() {
        return age;
    }
}
