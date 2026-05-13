package com.tuapp.consultorio.controller;

import com.tuapp.consultorio.dto.TurnoRequest;
import com.tuapp.consultorio.dto.TurnoResponse;
import com.tuapp.consultorio.service.TurnoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/turnos")
@RequiredArgsConstructor
public class TurnoController {

    private final TurnoService service;

    @GetMapping
    public List<TurnoResponse> listar() {
        return service.listar();
    }

    @PostMapping
    public TurnoResponse crear(@Valid @RequestBody TurnoRequest dto) {
        return service.crear(dto);
    }

    @GetMapping("/buscar")
    public List<TurnoResponse> buscarPorFecha(
            @RequestParam LocalDate fecha
    ) {
        return service.buscarPorFecha(fecha);
    }
}