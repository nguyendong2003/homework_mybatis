package com.example.homework.service.impl;

import com.example.homework.mapper.DepartmentMapper;
import com.example.homework.model.Department;
import com.example.homework.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentMapper departmentMapper;

    public DepartmentServiceImpl(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartments();
    }

    @Override
    public Department getDepartmentById(Integer id) {
        return departmentMapper.getDepartmentById(id);
    }

    @Override
    public void saveDepartment(Department department) {
        if (department.getId() == null) {
            departmentMapper.createDepartment(department);
        } else {
            departmentMapper.updateDepartment(department);
        }
    }

    @Override
    public void deleteDepartment(Integer id) {
        departmentMapper.deleteDepartment(id);
    }
}
