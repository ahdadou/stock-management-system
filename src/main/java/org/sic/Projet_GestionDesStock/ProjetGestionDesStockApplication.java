package org.sic.Projet_GestionDesStock;

import org.sic.Projet_GestionDesStock.entity.Category;
import org.sic.Projet_GestionDesStock.entity.Customer;
import org.sic.Projet_GestionDesStock.entity.Product;
import org.sic.Projet_GestionDesStock.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot
		.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
public class ProjetGestionDesStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetGestionDesStockApplication.class, args);
	}




}
