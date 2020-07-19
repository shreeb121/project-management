package com.sub.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sub.pma.dao.EmployeeRepository;
import com.sub.pma.dao.ProjectRepository;
import com.sub.pma.entities.Employee;
import com.sub.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping
	public String displayProjects(Model model) {
		
		List<Project> projects= proRepo.findAll();
		model.addAttribute("projects", projects);
		return "projects/list-projects";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject= new Project();
		List <Employee> employees= empRepo.findAll();
		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees", employees);
	    return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project,BindingResult bindingResults, @RequestParam List <Long> employees,Model model) {
		//This handles saving to the database
		proRepo.save(project);
		
		Iterable<Employee> chosenEmployees=empRepo.findAllById(employees);
		
		for(Employee emp: chosenEmployees)
		{
			emp.setProject(project);
			empRepo.save(emp);
		}
		//use redirect to avoid duplicate submission 
		return "redirect:/projects/new";
	}
}
