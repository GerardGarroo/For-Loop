package com.for_loop.alquilatusvehiculos.controller.api;


import com.for_loop.alquilatusvehiculos.model.Vehiculo;
import com.for_loop.alquilatusvehiculos.repository.VehiculoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoApiController {

    private final VehiculoRepository vehiculoRepository;

    public VehiculoApiController(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @GetMapping
    public List<Vehiculo> getAll() {
        return vehiculoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Vehiculo getById(@PathVariable Long id){
        return vehiculoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Vehículo no encontrado"));
    }
}