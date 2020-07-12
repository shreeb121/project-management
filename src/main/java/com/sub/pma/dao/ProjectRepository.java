package com.sub.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.sub.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

}
