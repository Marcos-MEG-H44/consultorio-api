package com.tuapp.consultorio.controller;

import com.tuapp.consultorio.dto.PacienteResponse;
import com.tuapp.consultorio.service.PacienteService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(
        controllers = PacienteController.class,

        excludeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ASSIGNABLE_TYPE,
                        classes = {
                                com.tuapp.consultorio.security.JwtAuthenticationFilter.class,
                                com.tuapp.consultorio.security.SecurityConfig.class
                        }
                )
        }
)

@AutoConfigureMockMvc(addFilters = false)

public class PacienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PacienteService service;

    @Test
    void debeListarPacientes() throws Exception {

        PacienteResponse paciente =
                PacienteResponse.builder()
                        .id(1L)
                        .nombre("Marcos")
                        .apellido("Godoy")
                        .dni("12345678")
                        .telefono("2923")
                        .build();

        when(service.listar())
                .thenReturn(List.of(paciente));

        mockMvc.perform(
                        get("/pacientes")
                                .contentType(MediaType.APPLICATION_JSON)
                )

                .andExpect(status().isOk())

                .andExpect(jsonPath("$[0].nombre")
                        .value("Marcos"));
    }
}