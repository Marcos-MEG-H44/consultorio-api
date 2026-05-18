# API1 - Consultorio Médico

API REST desarrollada con Spring Boot para la gestión de pacientes, médicos y turnos.

Proyecto realizado como práctica de desarrollo Backend utilizando Java + Spring Boot + SQL Server + JWT + JPA.

---

# Tecnologías utilizadas

- Java 21
- Spring Boot
- Spring Security
- JWT Authentication
- Spring Data JPA
- SQL Server
- Maven
- Lombok
- Thunder Client / Postman
- Git + GitHub

---

# Estructura del proyecto

src/main/java/com/tuapp/consultorio

controller/

service/

repository/

entity/

dto/

mapper/

security/

config/

---

# Funcionalidades implementadas

## Pacientes

- Crear pacientes
- Listar pacientes
- Actualizar pacientes
- Eliminar pacientes
- Buscar pacientes

---

## Médicos

- CRUD completo
- Especialidades médicas
- Actualización y eliminación

---

## Turnos

- Gestión de turnos médicos
- Asociación entre pacientes y médicos
- Administración de consultas

---

## Seguridad

Implementada mediante:

- Registro de usuarios
- Login
- JWT Authentication
- Endpoints protegidos
- Spring Security

Endpoints públicos:

POST /auth/register

POST /auth/login

---

# Arquitectura implementada

El proyecto utiliza:

✔ Controllers

✔ Services

✔ DTO Request / Response

✔ Mapper

✔ Repository

✔ Entities JPA

✔ Validaciones

✔ Seguridad JWT

---

# Relaciones implementadas

✔ OneToMany

✔ ManyToOne

✔ ManyToMany

Relaciones entre:

Paciente ↔ Turno

Medico ↔ Turno

Usuarios ↔ Seguridad

---

# Entidades principales

## Paciente

- id
- nombre
- apellido
- dni
- telefono

---

## Médico

- id
- nombre
- especialidad
- matricula

---

## Turno

- id
- fecha
- paciente
- medico

---

## Usuario

- username
- password
- role

---

# Endpoints principales

## Auth

POST /auth/register

POST /auth/login

---

## Pacientes

GET /pacientes

POST /pacientes

PUT /pacientes/{id}

DELETE /pacientes/{id}

---

## Médicos

GET /medicos

POST /medicos

PUT /medicos/{id}

DELETE /medicos/{id}

GET /medicos/buscar?especialidad=...

---

## Turnos

GET /turnos

POST /turnos

PUT /turnos/{id}

DELETE /turnos/{id}

---

# Base de Datos

Script SQL disponible en:

```txt
database/script_consultorio.sql