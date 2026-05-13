package com.tuapp.consultorio.service;

import com.tuapp.consultorio.dto.TurnoRequest;
import com.tuapp.consultorio.dto.TurnoResponse;
import com.tuapp.consultorio.entity.Medico;
import com.tuapp.consultorio.entity.Paciente;
import com.tuapp.consultorio.entity.Turno;
import com.tuapp.consultorio.mapper.TurnoMapper;
import com.tuapp.consultorio.repository.MedicoRepository;
import com.tuapp.consultorio.repository.PacienteRepository;
import com.tuapp.consultorio.repository.TurnoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TurnoService {

    private final TurnoRepository turnoRepository;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;

    public List<TurnoResponse> listar() {

        return turnoRepository.findAll()
                .stream()
                .map(TurnoMapper::toResponse)
                .toList();
    }

    public TurnoResponse crear(TurnoRequest dto) {

        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        Medico medico = medicoRepository.findById(dto.getMedicoId())
                .orElseThrow(() -> new RuntimeException("Médico no encontrado"));

        Turno turno = Turno.builder()
                .fecha(dto.getFecha())
                .motivo(dto.getMotivo())
                .paciente(paciente)
                .medico(medico)
                .build();

        return TurnoMapper.toResponse(
                turnoRepository.save(turno)
        );
    }

    public List<TurnoResponse> buscarPorFecha(LocalDate fecha) {

        return turnoRepository.findByFecha(fecha)
                .stream()
                .map(TurnoMapper::toResponse)
                .toList();
    }
}