package com.for_loop.alquilatusvehiculos.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "sedes")
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String ciudad;

    @Column(nullable = false, length = 200)
    private String direccion;

    @Column(nullable = false, length = 15)
    private String telefono;

    @OneToMany(mappedBy = "sedeRecogida")
    private List<Alquiler> alquileresRecogida;

    @OneToMany(mappedBy = "sedeDevolucion")
    private List<Alquiler> alquileresDevolucion;
    @ManyToMany
    @JoinTable(
            name = "vehiculo_sede",
            joinColumns = @JoinColumn(name = "sede_id"),
            inverseJoinColumns = @JoinColumn(name = "vehiculo_id")
    )
    private List<Vehiculo> vehiculos;
}