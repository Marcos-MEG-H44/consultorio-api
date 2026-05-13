# API Consultorio Médico

Proyecto realizado con Spring Boot para la gestión de pacientes, médicos y turnos.

---

# Tecnologías utilizadas

* Java 21
* Spring Boot
* Spring Security
* JWT
* Spring Data JPA
* SQL Server
* Maven
* Lombok

---

# Funcionalidades

## Pacientes

* Crear pacientes
* Listar pacientes
* Actualizar pacientes
* Eliminar pacientes
* Buscar pacientes

## Médicos

* CRUD completo
* Especialidades médicas

## Turnos

* Gestión de turnos
* Relación entre pacientes y médicos

## Seguridad

* Registro de usuarios
* Login
* JWT Authentication
* Endpoints protegidos

---

# Relaciones implementadas

* OneToMany
* ManyToOne
* ManyToMany

---

# Testing

* Test de Service
* Test de Controller

---

# Base de Datos

El script SQL se encuentra en:

database/script_consultorio.sql

---

# Cómo ejecutar el proyecto

## Ejecutar API

```bash
.\mvnw spring-boot:run
```

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

---

## Turnos

GET /turnos

POST /turnos

---

# Autor

Marcos Godoy
