package org.sic.Projet_GestionDesStock.services;

import java.util.List;

import org.sic.Projet_GestionDesStock.dto.CustomerResponse;
import org.sic.Projet_GestionDesStock.entity.Customer;
import org.sic.Projet_GestionDesStock.entity.Ordere;
import org.sic.Projet_GestionDesStock.repository.CustomerRepository;
import org.sic.Projet_GestionDesStock.repository.OrdereRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	Logger logger = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private OrdereRepository ordereRepository;

	public Customer saveItem(Customer customer) {
		logger.info("Saving customer");
		return customerRepository.save(customer);
	}

	public List<Customer> getAll() {
		logger.info("Getting all customers");
		return customerRepository.findAll();
	}

	public Customer getById(long id) {
		logger.info("Getting customer by id");
		return customerRepository.findById(id).get();
	}

	public void deleteById(long id) {
		logger.info("Deleting customer by id");
      	customerRepository.deleteById(id);
	}

	public List<Ordere> getOrdersCustomer(long idCustomer){
		logger.info("Getting orders by customer");
		return ordereRepository.getByIdCustomer(idCustomer);
	}

	public double getTotalByCustomerId(long id){
		return ordereRepository.totalByCustomer(id);
	}

    public int getCount() {
			return customerRepository.getCount();
    }



}
