package com.tuapp.consultorio.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MedicoRequest {

    @NotBlank
    private String nombre;

    @NotBlank
    private String especialidad;

    @NotBlank
    private String matricula;
}