package com.tuapp.consultorio.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MedicoResponse {

    private Long id;

    private String nombre;

    private String especialidad;

    private String matricula;
}