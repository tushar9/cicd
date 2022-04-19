package com.example.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.training.domain.Employee;
import com.example.training.domain.EmployeeService;

@Controller
@RequestMapping("/employees")
@SessionAttributes({"employees"}) //Model Attribute employees should be kept on Session by name 'employees'
public class EmployeeController {
	@Autowired
	EmployeeService service;
	
	@RequestMapping(path="/json/{paramId}", method=RequestMethod.GET)
	public Employee getEmployee(@PathVariable("paramId") Integer pId) {
		return service.getEmployeeById(pId);
	}
	
	//http://localhost:8080/employeemvc/mvc/employees/100
	@RequestMapping(path="{paramId}", method=RequestMethod.GET)
	public String getEmployee(@PathVariable("paramId") Integer pId, Model model) {
		Employee emp = service.getEmployeeById(pId);
		System.out.println("EmployeeController.getEmployee: Param Id is " + pId);
		System.out.println("EmployeeController.getEmployee: Employee Name is " + emp.getName());
		model.addAttribute("employee", emp);
		return "employeedetails";
	}
	
	@RequestMapping(path="/all", method=RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("employees", service.getAllEmployees());
		return "employeelist";
	}
	
	@RequestMapping(path="/delete", method=RequestMethod.GET)
	public String deleteEmployee(@RequestParam("paramId") Integer pId, Model model) {
		service.removeEmployee(pId);
		model.addAttribute("employees", service.getAllEmployees());
		return "redirect:/mvc/employees/all";
	}
	
	@RequestMapping(path="/create", method=RequestMethod.GET)
	public String createEmployee(Model model) {
		Employee newEmployee = new Employee();
		model.addAttribute("newEmployee", newEmployee);
		return "employeecreate";
	}
	
	@RequestMapping(path="/create", method=RequestMethod.POST)
	public String createEmployee(@ModelAttribute("newEmployee") Employee newEmployee) {
		service.hireEmployee(newEmployee);
		return "redirect:/mvc/employees/all";
	}
	
	@RequestMapping(path="/update/{paramId}", method=RequestMethod.GET)
	public String updateEmployee(@PathVariable("paramId") Integer id, Model model) {
		Employee employee = service.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "employeeupdate";
	}	
	@RequestMapping(path="/update/{paramId}", method=RequestMethod.POST)
	public String updateEmployee(@PathVariable("paramId") Integer id, @ModelAttribute("employee") Employee employee) {
		service.updateEmployee(id, employee);
		return "redirect:/mvc/employees/all";
	}
	
}
