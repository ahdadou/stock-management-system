package org.sic.Projet_GestionDesStock.services;

import java.util.List;

import org.sic.Projet_GestionDesStock.entity.Customer;
import org.sic.Projet_GestionDesStock.entity.Ordere;
import org.sic.Projet_GestionDesStock.repository.CustomerRepository;
import org.sic.Projet_GestionDesStock.repository.OrdereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private OrdereRepository ordereRepository;

//    Add Item
	public Customer saveItem(Customer customer) {
		return customerRepository.save(customer);
	}

//    Get all Items
	public List<Customer> getAll() {
		return customerRepository.findAll();
	}

//    Get Item By Id
	public Customer getById(long id) {
		return customerRepository.findById(id).get();
	}

//    Delete Item By Id

	public void deleteById(long id) {
      customerRepository.deleteById(id);
	}

	public List<Ordere> getOrdersCustomer(long idCustomer){
		return ordereRepository.getByIdCustomer(idCustomer);
	}

	//	Get Total For One Order
	public double getTotalByCustomerId(long id){
		return ordereRepository.totalByCustomer(id);
	}

    public int getCount() {
			return customerRepository.getCount();
    }



}
