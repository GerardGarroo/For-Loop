package com.for_loop.alquilatusvehiculos.model;

import java.util.List;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "vehiculos")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 10)
    private String matricula;

    @Column(nullable = false, length = 50)
    private String marca;

    @Column(nullable = false, length = 50)
    private String modelo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoVehiculo tipo;

    @Column(nullable = false)
    private Integer anio;

    @Column(nullable = false)
    private Double precioDia;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoVehiculo estado;

    @OneToMany(mappedBy = "vehiculo")
    private List<Alquiler> alquileres;

    public enum TipoVehiculo {
        COCHE, MOTO, FURGONETA
    }

    public enum EstadoVehiculo {
        DISPONIBLE, ALQUILADO, MANTENIMIENTO
    }
}