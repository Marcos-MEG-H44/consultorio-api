package com.tuapp.consultorio.mapper;

import com.tuapp.consultorio.dto.*;
import com.tuapp.consultorio.entity.Paciente;

public class PacienteMapper {

    public static Paciente toEntity(PacienteRequest dto) {
        return Paciente.builder()
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .dni(dto.getDni())
                .telefono(dto.getTelefono())
                .build();
    }

    public static PacienteResponse toResponse(Paciente paciente) {
        return PacienteResponse.builder()
                .id(paciente.getId())
                .nombre(paciente.getNombre())
                .apellido(paciente.getApellido())
                .dni(paciente.getDni())
                .telefono(paciente.getTelefono())
                .build();
    }
}