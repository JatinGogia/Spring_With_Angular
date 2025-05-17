package com.projects.project1.service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.projects.project1.dtos.sqldb.dto.performanceDTO;

@Component
public class PerformanceService {

     @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertBulkData(){
            System.out.println("Starting bulk insert...");

        int total = 100_000;
        int batchSize = 1000;

        for (int i = 0; i < total; i += batchSize) {
            StringBuilder sql = new StringBuilder("INSERT INTO perfotmanceTesting (id, ");
            for (int c = 1; c <= 45; c++) {
                sql.append("col").append(c);
                if (c != 45) sql.append(", ");
            }
            sql.append(") VALUES ");

            for (int j = 0; j < batchSize; j++) {
                String id = UUID.randomUUID().toString();
                sql.append("('").append(id).append("'");

                for (int k = 1; k <= 45; k++) {
                    sql.append(", '").append(randomString()).append("'");
                }

                sql.append(")");
                if (j != batchSize - 1) sql.append(", ");
            }

            jdbcTemplate.execute(sql.toString());
            System.out.println("Inserted " + (i + batchSize) + " records...");
        }

        System.out.println("Finished inserting 1 lakh rows.");
    }

    
    private String randomString() {
        String[] data = {"alpha", "beta", "gamma", "delta", "omega", "theta", "lambda"};
        return data[ThreadLocalRandom.current().nextInt(data.length)];
    }


    public List<performanceDTO> fetchDataFromDb(){
        
        try{
             return jdbcTemplate.query("select * from perfotmanceTesting;",new BeanPropertyRowMapper<>(performanceDTO.class));
        }
        catch(Exception e){
                System.out.println(e);
        }
        return null;
    }







}
