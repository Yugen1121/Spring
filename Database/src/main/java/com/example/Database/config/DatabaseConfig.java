package com.example.Database.config;

import com.example.Database.dao.impl.AuthorDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    public JdbcTemplate jdbcTemplate(final DataSource dataSource){ return new JdbcTemplate(dataSource); }

}
