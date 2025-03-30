package com.example.homework.mapper;

import com.example.homework.model.Project;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProjectMapper {
    @Select("SELECT * FROM project WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "projectName", column = "project_name"),
            @Result(property = "difficulty", column = "difficulty"),
            @Result(property = "createdAt", column = "created_at"),
            @Result(property = "updatedAt", column = "updated_at"),
            @Result(property = "version", column = "version"),
            @Result(property = "department.id", column = "department_id"),
            @Result(property = "department.departmentName", column = "department_name")
    })
    Project getProjectById(Integer id);

    @Select("SELECT * FROM project")
    List<Project> getAllProjects();

    @Insert("INSERT INTO project (id, project_name, difficulty, version, department_id) VALUES (#{id}, #{projectName}, #{difficulty}, #{version}, #{department.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void createProject(Project project);

    @Update("UPDATE project SET project_name = #{projectName}, difficulty = #{difficulty}, version = #{version}, department_id = #{department.id} WHERE id = #{id}")
    void updateProject(Project project);

    @Delete("DELETE FROM project WHERE id = #{id}")
    void deleteProject(Integer id);

    // Add this method for pagination
    // @Select("SELECT * FROM project WHERE project_name LIKE CONCAT('%',
    // #{projectName}, '%') AND difficulty = #{difficulty} AND department_id =
    // #{departmentId} LIMIT #{limit} OFFSET #{offset}")
    @Select({ "<script>",
            "SELECT p.*, d.id as department_id, d.department_name",
            "FROM project p",
            "LEFT JOIN department d ON p.department_id = d.id",
            "WHERE 1=1",
            "  <if test='projectName != null and projectName != \"\"'>",
            "    AND p.project_name LIKE CONCAT('%', #{projectName}, '%')",
            "  </if>",
            "  <if test='difficulty != null and difficulty != \"\"'>",
            "    AND p.difficulty = #{difficulty}",
            "  </if>",
            "  <if test='departmentId != null'>",
            "    AND p.department_id = #{departmentId}",
            "  </if>",
            "ORDER BY p.created_at DESC",
            "LIMIT #{limit} OFFSET #{offset}",
            "</script>" })
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "projectName", column = "project_name"),
            @Result(property = "difficulty", column = "difficulty"),
            @Result(property = "createdAt", column = "created_at"),
            @Result(property = "updatedAt", column = "updated_at"),
            @Result(property = "version", column = "version"),
            @Result(property = "department.id", column = "department_id"),
            @Result(property = "department.departmentName", column = "department_name")
    })
    List<Project> searchProjects(String projectName, String difficulty, Integer departmentId, int limit, int offset);

    // @Select("SELECT COUNT(*) FROM project WHERE project_name LIKE CONCAT('%',
    // #{projectName}, '%') AND difficulty = #{difficulty} AND department_id =
    // #{departmentId}")
    @Select({ "<script>",
            "SELECT COUNT(*) FROM project",
            "WHERE 1=1",
            "  <if test='projectName != null and projectName != \"\"'>",
            "    AND project_name LIKE CONCAT('%', #{projectName}, '%')",
            "  </if>",
            "  <if test='difficulty != null and difficulty != \"\"'>",
            "    AND difficulty = #{difficulty}",
            "  </if>",
            "  <if test='departmentId != null'>",
            "    AND department_id = #{departmentId}",
            "  </if>",
            "</script>" })
    int countProjects(String projectName, String difficulty, Integer departmentId);
}