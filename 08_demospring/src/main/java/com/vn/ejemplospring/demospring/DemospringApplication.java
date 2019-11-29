package com.vn.ejemplospring.demospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemospringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemospringApplication.class, args);
		System.out.println(">>> APLICACION ARRANCADA.");
		System.out.println(">>> A ROBAR SE HA DICHO!");
	}

}
