package com.jaugusto.AssistenteJarvisAI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "evento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String titulo;
    @Column
    private LocalDateTime dataHoraInicio;
    @Column
    private int duracaoMinutos;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioModel usuario;


}
