CREATE DATABASE IF NOT EXISTS project_mybatis_db;
USE project_mybatis_db;

-- Create Department Table
CREATE TABLE IF NOT EXISTS department (
    id INT AUTO_INCREMENT PRIMARY KEY,
    department_name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Insert initial data into the department table
INSERT INTO department (department_name)
VALUES
    ('Nhân sự'),
    ('Kinh doanh'),
    ('Công nghệ thông tin');

-- Create User Table
CREATE TABLE IF NOT EXISTS user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create User Roles Table
/*
CREATE TABLE IF NOT EXISTS user_roles (
    user_id BIGINT NOT NULL,
    role VARCHAR(50) NOT NULL,
    PRIMARY KEY (user_id, role),
    FOREIGN KEY (user_id) REFERENCES user(id)
);
*/

CREATE TABLE IF NOT EXISTS user_roles (
    user_id BIGINT NOT NULL,
    role VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES user(id)
);

-- -- Insert initial data into the user table
-- INSERT INTO user (username, password)
-- VALUES
--     ('admin', '$2a$10$DowJonesIndex'), -- Replace with actual hashed password
--     ('user', '$2a$10$DowJonesIndex'); -- Replace with actual hashed password

-- Insert initial data into the user_roles table
INSERT INTO user_roles (user_id, role)
VALUES
    (1, 'ADMIN'),
    (2, 'USER');

-- Create Project Table
CREATE TABLE IF NOT EXISTS project (
    id INT PRIMARY KEY,
    project_name VARCHAR(255) NOT NULL,
    difficulty VARCHAR(50),
    version DECIMAL(3, 1),
    department_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (department_id) REFERENCES department(id)
);
    