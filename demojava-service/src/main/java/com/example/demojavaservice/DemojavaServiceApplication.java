package com.example.demojavaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class DemojavaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemojavaServiceApplication.class, args);
	}

}
