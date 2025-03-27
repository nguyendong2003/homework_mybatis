package com.example.homework.service;

import com.example.homework.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<Project> getAllProjects();
    Optional<Project> getProjectById(Integer id);
    void createProject(Project project);
    void updateProject(Integer id, Project project);
    void deleteProject(Integer id);

    // Modify this method to accept pagination parameters
    List<Project> searchProjects(String projectName, String difficulty, Integer departmentId, int limit, int offset);
    int countProjects(String projectName, String difficulty, Integer departmentId);
}