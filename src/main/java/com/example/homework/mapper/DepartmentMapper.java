package com.example.homework.mapper;

import com.example.homework.model.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    @Select("SELECT * FROM department WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "departmentName", column = "department_name"),
    })
    Department getDepartmentById(Integer id);

    @Select("SELECT * FROM department")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "departmentName", column = "department_name"),
//            @Result(property = "projects", column = "id", javaType = List.class, many = @Many(select = "com.example.homework.mapper.ProjectMapper.getProjectsByDepartmentId"))
    })
    List<Department> getAllDepartments();

    @Insert("INSERT INTO department (department_name) VALUES (#{departmentName})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void createDepartment(Department department);

    @Update("UPDATE department SET department_name = #{departmentName} WHERE id = #{id}")
    void updateDepartment(Department department);

    @Delete("DELETE FROM department WHERE id = #{id}")
    void deleteDepartment(Integer id);
}