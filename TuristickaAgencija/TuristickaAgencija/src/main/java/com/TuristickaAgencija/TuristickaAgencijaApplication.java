package com.TuristickaAgencija;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("model")
public class TuristickaAgencijaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TuristickaAgencijaApplication.class, args);
	}

}
