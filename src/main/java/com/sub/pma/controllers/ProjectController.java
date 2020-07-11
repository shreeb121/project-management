package com.sub.pma.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProjectController {
	@RequestMapping("/new")
	public String displayProjectForm() {
	    return "new-project";
	}
}
