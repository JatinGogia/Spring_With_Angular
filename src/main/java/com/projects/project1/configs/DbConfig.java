package com.projects.project1.configs;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfig {
    
    @Value("${spring.data.mongodb.host}")  
    String HOST;

    @Value("${spring.data.mongodb.port}")  
    String PORT = "27017";
    
    @Value("${spring.data.mongodb.database}")  
    String DB = "admin";

    @Value("${spring.data.mongodb.username}")
    String USER = "admin";
    
    @Value("${spring.data.mongodb.password}")
    String PASS = "admin";

}
