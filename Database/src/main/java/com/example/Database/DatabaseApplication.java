package com.example.Database;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@Log
public class DatabaseApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}

	private final DataSource dataSource;

	public DatabaseApplication(DataSource dataSource){
			this.dataSource = dataSource;
	}


	@Override
	public void run(String... args) throws Exception {
		log.info("Database: " + this.dataSource.toString());
		JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
		restTemplate.execute("select 1");
	}
}
