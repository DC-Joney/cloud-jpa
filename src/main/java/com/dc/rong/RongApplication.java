package com.dc.rong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.dc.rong.dao")
@SpringBootApplication
public class RongApplication {

    public static void main(String[] args) {
        SpringApplication.run(RongApplication.class, args);
    }

}
