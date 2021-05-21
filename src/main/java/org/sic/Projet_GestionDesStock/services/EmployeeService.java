package org.sic.Projet_GestionDesStock.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.sic.Projet_GestionDesStock.entity.Employee;
import org.sic.Projet_GestionDesStock.repository.EmployeeRepoitory;
import org.sic.Projet_GestionDesStock.repository.RoleRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements UserDetailsService {
	@Autowired
	private EmployeeRepoitory employeeRepoitory;
	@Autowired private RoleRespository roleRepository;
	@Autowired private PasswordEncoder passwordEncoder;




//    Add Item
	public Employee saveItem(Employee employee) {
		String pass = employee.getPassword();
		employee.setPassword(passwordEncoder.encode(pass));
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
	public Employee updateItem(Employee employee) {
		return employeeRepoitory.save(employee);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee employee = employeeRepoitory.findByUsername(username);
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		employee.getRoles().forEach(r -> {
			authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
		});

		return new User(employee.getUsername(),employee.getPassword(),authorities);
	}

	public Employee findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return employeeRepoitory.findByUsername(username);
	}
}
