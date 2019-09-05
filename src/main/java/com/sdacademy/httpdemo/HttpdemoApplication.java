package com.sdacademy.httpdemo;

import java.util.Base64;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HttpdemoApplication {

    public static void main(String[] args) {
        //Base64.getEncoder().encode()
        //Base64.getDecoder().decode()
        SpringApplication.run(HttpdemoApplication.class, args);
    }

}
