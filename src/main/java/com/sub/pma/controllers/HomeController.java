package com.sub.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sub.pma.dao.EmployeeRepository;
import com.sub.pma.dao.ProjectRepository;
import com.sub.pma.entities.Employee;
import com.sub.pma.entities.Project;

@Controller
public class HomeController {
	@Autowired
	ProjectRepository proRepo;
	@Autowired
	EmployeeRepository empRepo;
	@GetMapping("/")
	public String displayHome(Model model)
	{
		List<Project> projects= proRepo.findAll();
		model.addAttribute("projectsList", projects);
		
		List<Employee> employees= empRepo.findAll();
		model.addAttribute("employeesList", employees);
		
		return "home";
	}
}
