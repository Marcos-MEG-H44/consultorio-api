package com.tuapp.consultorio.repository;

import com.tuapp.consultorio.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Optional<Paciente> findByDni(String dni);

    List<Paciente> findByNombreContainingIgnoreCase(String nombre);

    @Query("SELECT p FROM Paciente p WHERE p.apellido = :apellido")
    List<Paciente> buscarPorApellido(String apellido);
}