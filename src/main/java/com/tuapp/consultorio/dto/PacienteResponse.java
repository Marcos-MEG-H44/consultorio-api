package com.tuapp.consultorio.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PacienteResponse {

    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
}