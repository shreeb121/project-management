package com.sub.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sub.pma.dao.EmployeeRepository;
import com.sub.pma.entities.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		
		Employee anEmployee= new Employee();
		model.addAttribute("employee", anEmployee);
	    return "employees/new-employee";
	}
	
	@PostMapping("/save")
	public String createEmployee(Employee employee, Model model) {
		//This handles saving to the database
		empRepo.save(employee);
		
		//use redirect to avoid duplicate submission 
		return "redirect:/employees/new";
	}
}
