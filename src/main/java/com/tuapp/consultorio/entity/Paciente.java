package com.tuapp.consultorio.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "pacientes")

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor

@Builder
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(unique = true, nullable = false)
    private String dni;

    @Column(nullable = false)
    private String telefono;

    // RELACION CON TURNOS
    @OneToMany(mappedBy = "paciente")
    private List<Turno> turnos;

    // MANY TO MANY
    @ManyToMany
    @JoinTable(
            name = "pacientes_obras_sociales",

            joinColumns =
            @JoinColumn(name = "paciente_id"),

            inverseJoinColumns =
            @JoinColumn(name = "obra_social_id")
    )
    private List<ObraSocial> obrasSociales;
}