package org.sic.Projet_GestionDesStock;

import org.sic.Projet_GestionDesStock.entity.*;
import org.sic.Projet_GestionDesStock.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot
		.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
public class ProjetGestionDesStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetGestionDesStockApplication.class, args);
	}


	@Autowired
	private EmployeeService employeeService;

	@Bean
	CommandLineRunner run(){
		return etc -> {
//			Employee employee = new Employee();
//			employee.setName("admin");
//			employee.setRole("admin");
//			employee.setPassword("admin");
//			employeeService.saveItem(employee);
		};
	}





}
