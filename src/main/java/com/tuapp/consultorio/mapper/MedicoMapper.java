package com.tuapp.consultorio.mapper;

import com.tuapp.consultorio.dto.*;
import com.tuapp.consultorio.entity.Medico;

public class MedicoMapper {

    public static Medico toEntity(MedicoRequest dto) {

        return Medico.builder()
                .nombre(dto.getNombre())
                .especialidad(dto.getEspecialidad())
                .matricula(dto.getMatricula())
                .build();
    }

    public static MedicoResponse toResponse(Medico medico) {

        return MedicoResponse.builder()
                .id(medico.getId())
                .nombre(medico.getNombre())
                .especialidad(medico.getEspecialidad())
                .matricula(medico.getMatricula())
                .build();
    }
}