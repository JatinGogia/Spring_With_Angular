package com.projects.project1.handler;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.projects.project1.codeFlowImageGenerationCode.TraceFlow;
import com.projects.project1.dtos.sqldb.dto.performanceDTO;

@Component
public class SqlDbHandler {

    @Autowired
    JdbcTemplate jdbcTemplate;
     
    @TraceFlow
    public List<performanceDTO> fetchDataFromPerfotmanceTesting(){
          try{
            preProcessingData();
             return jdbcTemplate.query("select * from perfotmanceTesting;",new BeanPropertyRowMapper<>(performanceDTO.class));
        }
        catch(Exception e){
                System.out.println(e);
                return  Collections.emptyList();
        }
    }


    @TraceFlow
    public void preProcessingData(){
        System.out.println("All the preprocessing of the data should be done here");
    }

}
