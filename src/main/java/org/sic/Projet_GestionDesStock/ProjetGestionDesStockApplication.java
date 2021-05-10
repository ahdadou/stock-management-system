package org.sic.Projet_GestionDesStock;

import org.sic.Projet_GestionDesStock.entity.Category;
import org.sic.Projet_GestionDesStock.entity.Customer;
import org.sic.Projet_GestionDesStock.entity.Product;
import org.sic.Projet_GestionDesStock.entity.Supplier;
import org.sic.Projet_GestionDesStock.repository.CategoryRepository;
import org.sic.Projet_GestionDesStock.repository.CustomerRepository;
import org.sic.Projet_GestionDesStock.repository.ProductRepository;
import org.sic.Projet_GestionDesStock.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
public class ProjetGestionDesStockApplication {

	@Autowired ProductRepository productRepository;
	@Autowired CategoryRepository categoryRepository;
	@Autowired CustomerRepository customerRepository;
	@Autowired SupplierRepository supplierRepository;




	public static void main(String[] args) {
		SpringApplication.run(ProjetGestionDesStockApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(){
		return  args -> {
//			Category : Faker save Data
			Stream.of("aaa","bbb","ccc","ddd")
					.forEach(c -> categoryRepository.save(new Category(1,c,null)));
//			Product : Faker save Data
			Stream.of("aaa","bbb","ccc","ddd")
					.forEach(c -> {
						Product product = new Product(1,c,null, 100+new Random().nextDouble()*1000,new Date(),null,null,100+new Random().nextInt()*1000,null);
						productRepository.save(product);
					});

//			Customer : Faker save Data
			Stream.of("aaa","bbb","ccc","ddd")
					.forEach(c -> {
						Customer customer = new Customer(1,c,c,c+"@gmail.com",null,null,new Date(),null);
						customerRepository.save(customer);
					});
//			Supplier : Faker save Data
			Stream.of("aaa","bbb","ccc","ddd")
					.forEach(c -> {
						Supplier supplier = new Supplier(1,c,c,c+"@gmail.com",null,null,new Date(),null);
						supplierRepository.save(supplier);
					});
		};

	}

}
