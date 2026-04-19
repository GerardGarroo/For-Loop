package com.for_loop.alquilatusvehiculos.controller;


import com.for_loop.alquilatusvehiculos.model.Vehiculo;
import com.for_loop.alquilatusvehiculos.repository.VehiculoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/vehiculos")
public class VehiculoPublicoController {
    private final VehiculoRepository vehiculoRepository;

    public VehiculoPublicoController(VehiculoRepository vehiculoRepository){
        this.vehiculoRepository = vehiculoRepository;
    }

    @GetMapping
    public String listar(Model model){
        List<Vehiculo> disponibles = vehiculoRepository.findAll().stream()
                .filter(v->v.getEstado()==Vehiculo.EstadoVehiculo.DISPONIBLE)
                .toList();
        model.addAttribute("vehiculos",disponibles);
        model.addAttribute("activePage","vehiculos");
        return "vehiculos/lista-publica";
    }
}
