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