package com.for_loop.alquilatusvehiculos.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role; // Ej: "ROLE_ADMIN", "ROLE_USER"

    @Column(nullable = false)
    private LocalDate fechaRegistro = LocalDate.now();
}
