package com.intercom.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication

public class Application_RunAsMicroService {
	public static void main(String[] args) {
        SpringApplication.run(Application_RunAsMicroService.class, args);
        
    }
}
