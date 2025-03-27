package com.example.homework.mapper;

import com.example.homework.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Set;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE id = #{id}")
    User getUserById(Long id);

    @Select("SELECT * FROM user")
    List<User> getAllUsers();

    @Insert("INSERT INTO user (username, password) VALUES (#{username}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void createUser(User user);

    @Update("UPDATE user SET username = #{username}, password = #{password} WHERE id = #{id}")
    void updateUser(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    void deleteUser(Long id);

    // Add this method to fetch user by username
    @Select("SELECT * FROM user WHERE username = #{username}")
    User getUserByUsername(String username);

    // Add this method to check if a username exists
    @Select("SELECT COUNT(*) > 0 FROM user WHERE username = #{username}")
    boolean existsByUsername(String username);

    @Select("SELECT r.role FROM user_roles r WHERE r.user_id = #{id}")
    Set<String> getUserRoles(Long id);

}