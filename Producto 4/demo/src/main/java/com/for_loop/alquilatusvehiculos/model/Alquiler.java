package com.for_loop.alquilatusvehiculos.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "alquileres")
public class Alquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fechaInicio;

    @Column(nullable = false)
    private LocalDate fechaFin;

    @Column(nullable = false)
    private Double precioTotal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoAlquiler estado;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id", nullable = false)
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "sede_recogida_id", nullable = false)
    private Sede sedeRecogida;

    @ManyToOne
    @JoinColumn(name = "sede_devolucion_id", nullable = false)
    private Sede sedeDevolucion;

    public enum EstadoAlquiler {
        PENDIENTE, ACTIVO, FINALIZADO, CANCELADO
    }
}