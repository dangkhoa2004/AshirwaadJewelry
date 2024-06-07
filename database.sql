USE master;
GO
CREATE DATABASE Jewelry;
GO
USE Jewelry;
GO

CREATE TABLE Material
(
    id INT PRIMARY KEY,
    name NVARCHAR(50) NOT NULL
);

CREATE TABLE Type
(
    id INT PRIMARY KEY,
    name NVARCHAR(50) NOT NULL
);

CREATE TABLE Gender
(
    id INT PRIMARY KEY,
    name NVARCHAR(50) NOT NULL
);

-- Create the Mouse table
CREATE TABLE Jewelry
(
    id INT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    price INT,
    saleprice INT,
    material_id INT,
    type_id INT,
    gender_id INT,
    FOREIGN KEY (material_id) REFERENCES Material(id),
    FOREIGN KEY (type_id) REFERENCES Type(id),
    FOREIGN KEY (gender_id) REFERENCES Gender(id)
);

-- Tạo bảng Account
CREATE TABLE Account
(
    id INT IDENTITY PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255),
    avt VARCHAR(255),
    name VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(50),
    sex VARCHAR(10),
    status INT
);

-- Thêm dữ liệu vào bảng Account
INSERT INTO Account
    (username, password, name, email, phone, sex, status)
VALUES
    ('admin', '123', 'Quản Trị Viên', 'khoacdpp02847@fpt.edu.vn', '0869938981', 'Male', 1),
    ('user', '123', 'Người Dùng', 'khoacdpp02847@fpt.edu.vn', '0869938981', 'Male', 1);


