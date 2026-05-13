package com.tuapp.consultorio.controller;

import com.tuapp.consultorio.dto.PacienteRequest;
import com.tuapp.consultorio.dto.PacienteResponse;
import com.tuapp.consultorio.service.PacienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService service;

    @GetMapping
    public List<PacienteResponse> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public PacienteResponse buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/buscar")
    public List<PacienteResponse> buscarPorNombre(
            @RequestParam String nombre) {

        return service.buscarPorNombre(nombre);
    }

    @PostMapping
    public PacienteResponse crear(
            @Valid @RequestBody PacienteRequest dto) {

        return service.crear(dto);
    }

    @PutMapping("/{id}")
    public PacienteResponse actualizar(
            @PathVariable Long id,
            @Valid @RequestBody PacienteRequest dto) {

        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}