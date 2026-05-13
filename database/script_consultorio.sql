CREATE DATABASE consultorio_db;

USE consultorio_db;

CREATE TABLE pacientes (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    dni VARCHAR(255) UNIQUE NOT NULL,
    telefono VARCHAR(255) NOT NULL
);

CREATE TABLE medicos (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    especialidad VARCHAR(255),
    matricula VARCHAR(255)
);

CREATE TABLE turnos (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    fecha DATE,
    hora VARCHAR(255),

    paciente_id BIGINT,
    medico_id BIGINT,

    FOREIGN KEY (paciente_id)
        REFERENCES pacientes(id),

    FOREIGN KEY (medico_id)
        REFERENCES medicos(id)
);

CREATE TABLE obras_sociales (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    nombre VARCHAR(255)
);

CREATE TABLE pacientes_obras_sociales (

    paciente_id BIGINT,
    obra_social_id BIGINT,

    FOREIGN KEY (paciente_id)
        REFERENCES pacientes(id),

    FOREIGN KEY (obra_social_id)
        REFERENCES obras_sociales(id)
);