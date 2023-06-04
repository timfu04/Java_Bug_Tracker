package com.clementlee.bugtrackerapi.repositories;

import com.clementlee.bugtrackerapi.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    List<Project> findByUserId(int userId); // Find projects by user id (derived query method)

}
