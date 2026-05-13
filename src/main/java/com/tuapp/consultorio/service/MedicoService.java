package com.tuapp.consultorio.service;

import com.tuapp.consultorio.dto.*;
import com.tuapp.consultorio.entity.Medico;
import com.tuapp.consultorio.mapper.MedicoMapper;
import com.tuapp.consultorio.repository.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoService {

    private final MedicoRepository repository;

    public List<MedicoResponse> listar() {

        return repository.findAll()
                .stream()
                .map(MedicoMapper::toResponse)
                .toList();
    }

    public MedicoResponse crear(MedicoRequest dto) {

        Medico medico = MedicoMapper.toEntity(dto);

        return MedicoMapper.toResponse(
                repository.save(medico)
        );
    }

    public MedicoResponse actualizar(Long id, MedicoRequest dto) {

        Medico medico = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Médico no encontrado"));

        medico.setNombre(dto.getNombre());
        medico.setEspecialidad(dto.getEspecialidad());
        medico.setMatricula(dto.getMatricula());

        return MedicoMapper.toResponse(
                repository.save(medico)
        );
    }

    public void eliminar(Long id) {

        repository.deleteById(id);
    }

    public List<MedicoResponse> buscarPorEspecialidad(String especialidad) {

        return repository
                .findByEspecialidadContainingIgnoreCase(especialidad)
                .stream()
                .map(MedicoMapper::toResponse)
                .toList();
    }
}