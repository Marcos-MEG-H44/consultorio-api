package com.tuapp.consultorio.repository;

import com.tuapp.consultorio.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

    List<Medico> findByEspecialidadContainingIgnoreCase(String especialidad);
}