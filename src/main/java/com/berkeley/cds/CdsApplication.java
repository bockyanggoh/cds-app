package com.berkeley.cds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class CdsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CdsApplication.class, args);
    }

}
