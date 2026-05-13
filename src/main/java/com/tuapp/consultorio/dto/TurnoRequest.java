package com.tuapp.consultorio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TurnoRequest {

    @NotNull
    private LocalDate fecha;

    @NotBlank
    private String motivo;

    @NotNull
    private Long pacienteId;

    @NotNull
    private Long medicoId;
}