package com.projects.project1.configs;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.sqlite.SQLiteDataSource;

@Configuration
public class SqlDBConfig {

    @Value("${spring.datasource.url}")
    String dbUrl;

    @Bean
    public DataSource dataSource() {
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(dbUrl);
        return dataSource;
    }

    
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
