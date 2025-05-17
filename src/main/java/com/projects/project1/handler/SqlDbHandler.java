package com.projects.project1.handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SqlDbHandler {

    @Autowired
    JdbcTemplate jdbcTemplate;

    

}
