package org.sic.Projet_GestionDesStock.services;

import java.util.List;

import org.sic.Projet_GestionDesStock.entity.Category;
import org.sic.Projet_GestionDesStock.entity.Employee;
import org.sic.Projet_GestionDesStock.repository.EmployeeRepoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepoitory employeeRepoitory;

//    Add Item
	public Employee saveItem(Employee employee) {
		return employeeRepoitory.save(employee);
	}

	// Get all Items
	public List<Employee> getAll() {

		return employeeRepoitory.findAll();
	}

//    Get Item By Id
	public Employee getById(long id) {
		return employeeRepoitory.findById(id).get();
	}

//    Delete Item By Id
	public void deeleteById(long id) {
		employeeRepoitory.deleteById(id);
	}

//    Update Item
	public Category updateItem(Employee employee) {
		return null;
	}
}
