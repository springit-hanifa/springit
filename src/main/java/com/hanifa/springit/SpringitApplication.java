package com.hanifa.springit;

import com.hanifa.springit.config.SpringitProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableConfigurationProperties(SpringitProperties.class)
public class SpringitApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);
    @Autowired
    private SpringitProperties springitProperties;

    public static void main(String[] args) {
        SpringApplication.run(SpringitApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            log.error("command line");
            System.out.println("welcome message: "+ springitProperties.getWelcomeMsg());
        };
    }
}
