package org.sic.Projet_GestionDesStock.Controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.sic.Projet_GestionDesStock.entity.Employee;
import org.sic.Projet_GestionDesStock.entity.Role;
import org.sic.Projet_GestionDesStock.repository.RoleRespository;
import org.sic.Projet_GestionDesStock.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@CrossOrigin(value = "http://localhost:4200")
public class EmployeeConttroller {

	@Autowired
	private EmployeeService employeeService;
	// get all Employees
	@Autowired
	private RoleRespository roleRespository;


	@PostMapping("/register")
	public ResponseEntity<?> saveItem(@RequestBody EmployeeRequest employeeRequest) {
		try {
			Employee appuser = employeeService.findUserByUsername(employeeRequest.getUsername());

			if(appuser != null) throw new RuntimeException("this employee Username already exists");

			Employee employee = new Employee();
			employee.setName(employeeRequest.getName());
			employee.setPassword(employeeRequest.getPassword());
			employee.setUsername(employeeRequest.getUsername());

			Collection<Role> roles = new ArrayList<>();
			Role role = roleRespository.findByRoleName(employeeRequest.getRole());
			if(role!=null)
				roles.add(role);
			else
				roles.add(roleRespository.findByRoleName("SOUS_ADMIN"));
			employee.setRoles(roles);


			employee = employeeService.saveItem(employee);
//			employeeService.addRoleToEmployee(employee.getUsername(),employeeRequest.getRole());



			return new ResponseEntity<>(employee, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("CAN'T ADD Employee", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/Employees/list")
	public ResponseEntity<List<Employee>> getAll() {
		return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
	}
	// add Employee

	@PostMapping("/Employee/add")
	public ResponseEntity<?> saveItem(@RequestBody Employee employee) {
		try {

			Employee Employees = employeeService.saveItem(employee);
			return new ResponseEntity<>(Employees, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("CAN'T ADD Employee", HttpStatus.BAD_REQUEST);
		}
	}

	// add Employee by id

	@GetMapping("/Employee/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable long id) {
		try {
			Employee Employee = employeeService.getById(id);
			return new ResponseEntity<>(Employee, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("UNSPECTED ERROR OCCURS :  " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	// update Employee

	@PutMapping("/Employee/update")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
		try {
			employeeService.updateItem(employee);
			return new ResponseEntity<>("Employee UPDATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("CAN'T Update Employee", HttpStatus.BAD_REQUEST);
		}
	}
	// delete mployee by id

	@DeleteMapping(value = "/Employee/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
		try {
			employeeService.deeleteById(id);
			return new ResponseEntity<>("Employee DELETED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("CAN'T DELETE Employee", HttpStatus.BAD_REQUEST);
		}
	}
}
