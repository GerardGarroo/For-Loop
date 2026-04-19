package com.for_loop.alquilatusvehiculos.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellidos;

    @Column(nullable = false, unique = true, length = 9)
    private String dni;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 15)
    private String telefono;

    @Column(length = 200)
    private String direccion;

    @Column(nullable = false)
    private LocalDate fechaRegistro;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RolUsuario rol;

    @OneToMany(mappedBy = "cliente")
    private List<Alquiler> alquileres;

       public enum RolUsuario{
        ADMIN, USER
    }

}