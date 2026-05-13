package com.tuapp.consultorio.service;

import com.tuapp.consultorio.dto.PacienteRequest;
import com.tuapp.consultorio.entity.Paciente;
import com.tuapp.consultorio.repository.PacienteRepository;

import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PacienteServiceTest {

    @Mock
    private PacienteRepository repository;

    @InjectMocks
    private PacienteService service;

    public PacienteServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void debeCrearPaciente() {

        PacienteRequest request = new PacienteRequest();

        request.setNombre("Marcos");
        request.setApellido("Godoy");
        request.setDni("12345678");
        request.setTelefono("2923");

        Paciente paciente = Paciente.builder()
                .id(1L)
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .dni(request.getDni())
                .telefono(request.getTelefono())
                .build();

        when(repository.save(any(Paciente.class)))
                .thenReturn(paciente);

        var response = service.crear(request);

        assertNotNull(response);

        assertEquals("Marcos", response.getNombre());

        verify(repository, times(1))
                .save(any(Paciente.class));
    }
}