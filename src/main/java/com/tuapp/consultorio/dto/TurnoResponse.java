package com.tuapp.consultorio.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class TurnoResponse {

    private Long id;

    private LocalDate fecha;

    private String motivo;

    private String pacienteNombre;

    private String medicoNombre;
}