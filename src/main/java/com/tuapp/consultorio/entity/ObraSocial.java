package com.tuapp.consultorio.entity;

import jakarta.persistence.*;

import lombok.*;

import java.util.List;

@Entity
@Table(name = "obras_sociales")

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor

@Builder
public class ObraSocial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // MANY TO MANY
    @ManyToMany(mappedBy = "obrasSociales")
    private List<Paciente> pacientes;
}