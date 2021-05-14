package org.sic.Projet_GestionDesStock.Controllers;

import java.util.List;

import org.sic.Projet_GestionDesStock.entity.Employee;
import org.sic.Projet_GestionDesStock.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class EmployeeConttroller {

	@Autowired
	private EmployeeService employeeService;
	// get all Employees

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
