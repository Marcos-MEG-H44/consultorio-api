package com.tuapp.consultorio.mapper;

import com.tuapp.consultorio.dto.TurnoResponse;
import com.tuapp.consultorio.entity.Turno;

public class TurnoMapper {

    public static TurnoResponse toResponse(Turno turno) {

        return TurnoResponse.builder()
                .id(turno.getId())
                .fecha(turno.getFecha())
                .motivo(turno.getMotivo())
                .pacienteNombre(
                        turno.getPaciente().getNombre() + " " +
                        turno.getPaciente().getApellido()
                )
                .medicoNombre(
                        turno.getMedico().getNombre() + " " +
                        turno.getMedico().getApellido()
                )
                .build();
    }
}