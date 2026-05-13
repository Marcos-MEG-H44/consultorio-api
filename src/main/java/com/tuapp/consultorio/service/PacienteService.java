package com.tuapp.consultorio.service;

import com.tuapp.consultorio.dto.PacienteRequest;
import com.tuapp.consultorio.dto.PacienteResponse;
import com.tuapp.consultorio.entity.Paciente;
import com.tuapp.consultorio.mapper.PacienteMapper;
import com.tuapp.consultorio.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository repository;

    public List<PacienteResponse> listar() {
        return repository.findAll()
                .stream()
                .map(PacienteMapper::toResponse)
                .toList();
    }

    public PacienteResponse buscarPorId(Long id) {

        Paciente paciente = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Paciente no encontrado"));

        return PacienteMapper.toResponse(paciente);
    }

    public List<PacienteResponse> buscarPorNombre(String nombre) {

        return repository.findByNombreContainingIgnoreCase(nombre)
                .stream()
                .map(PacienteMapper::toResponse)
                .toList();
    }

    public PacienteResponse crear(PacienteRequest dto) {

        if (repository.findByDni(dto.getDni()).isPresent()) {
            throw new RuntimeException("Ya existe un paciente con ese DNI");
        }

        Paciente paciente = PacienteMapper.toEntity(dto);

        return PacienteMapper.toResponse(repository.save(paciente));
    }

    public PacienteResponse actualizar(Long id, PacienteRequest dto) {

        Paciente paciente = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Paciente no encontrado"));

        paciente.setNombre(dto.getNombre());
        paciente.setApellido(dto.getApellido());
        paciente.setDni(dto.getDni());
        paciente.setTelefono(dto.getTelefono());

        return PacienteMapper.toResponse(repository.save(paciente));
    }

    public void eliminar(Long id) {

        Paciente paciente = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Paciente no encontrado"));

        repository.delete(paciente);
    }
}