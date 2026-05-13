package com.tuapp.consultorio.controller;

import com.tuapp.consultorio.dto.*;
import com.tuapp.consultorio.service.MedicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoService service;

    @GetMapping
    public List<MedicoResponse> listar() {

        return service.listar();
    }

    @PostMapping
    public MedicoResponse crear(
            @Valid @RequestBody MedicoRequest dto) {

        return service.crear(dto);
    }

    @PutMapping("/{id}")
    public MedicoResponse actualizar(
            @PathVariable Long id,
            @Valid @RequestBody MedicoRequest dto) {

        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {

        service.eliminar(id);
    }

    @GetMapping("/buscar")
    public List<MedicoResponse> buscarPorEspecialidad(
            @RequestParam String especialidad) {

        return service.buscarPorEspecialidad(especialidad);
    }
}