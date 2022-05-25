package com.engineeringwithramaa.etlspringbatchparalleljobs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class EtlSpringBatchParallelJobsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtlSpringBatchParallelJobsApplication.class, args);
	}

}
