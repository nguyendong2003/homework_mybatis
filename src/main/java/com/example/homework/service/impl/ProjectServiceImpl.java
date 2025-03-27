package com.example.homework.service.impl;

import com.example.homework.mapper.ProjectMapper;
import com.example.homework.model.Project;
import com.example.homework.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectMapper projectMapper;

    public ProjectServiceImpl(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    @Override
    public List<Project> getAllProjects() {
        return projectMapper.getAllProjects();
    }

    @Override
    public Optional<Project> getProjectById(Integer id) {
        return Optional.ofNullable(projectMapper.getProjectById(id));
    }

    @Override
    public void createProject(Project project) {
        projectMapper.createProject(project);
    }

    @Override
    public void updateProject(Integer id, Project project) {
        project.setId(id);
        projectMapper.updateProject(project);
    }

    @Override
    public void deleteProject(Integer id) {
        projectMapper.deleteProject(id);
    }

    @Override
    public List<Project> searchProjects(String projectName, String difficulty, Integer departmentId, int limit, int offset) {
        return projectMapper.searchProjects(projectName, difficulty, departmentId, limit, offset);
    }

    @Override
    public int countProjects(String projectName, String difficulty, Integer departmentId) {
        return projectMapper.countProjects(projectName, difficulty, departmentId);
    }
}
