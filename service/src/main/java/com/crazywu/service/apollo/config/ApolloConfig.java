package com.crazywu.service.apollo.config;

import org.springframework.context.annotation.Bean;

//@Configuration
//@EnableApolloConfig
public class ApolloConfig {

    @Bean
    public UserConfig userConfig() {
        return new UserConfig();
    }
}
