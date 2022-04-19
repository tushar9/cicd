package com.example.training.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository //Creates object for EmployeeRepository
public class EmployeeRepository {
	private List<Employee> database;
	public EmployeeRepository() {
		database = new ArrayList();
		database.add(new Employee(100, "James Cooper", 12345.6, "Trainer", "Training", "HYD"));
		database.add(new Employee(200, "Steven King", 12345.6, "Developer", "Banking", "BLR"));
	}
	
	public Employee findEmployeeById(Integer id) {
		System.out.println("EmployeeRepository.findEmployeeById: Parameter id is " + id);
		for(Employee emp:database) {
			if(emp.getId().equals(id))
				return emp;
		}
		return null;
	}
	
	public List<Employee> getAllEmployees(){
		return database;
	}
	
	public void createEmployee(Employee emp) {
		database.add(emp);		
	}
	
	public void deleteEmployee(Integer empId) {
		for(int i=0; i<database.size(); i++) {
			if(database.get(i).getId().equals(empId))
				database.remove(i);
		}		
	}
	
	public void updateEmployee(Integer empId, Employee emp) {
		this.deleteEmployee(empId);
		database.add(emp);
	}
}