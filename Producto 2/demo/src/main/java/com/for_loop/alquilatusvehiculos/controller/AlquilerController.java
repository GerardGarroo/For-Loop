package com.for_loop.alquilatusvehiculos.controller;

import com.for_loop.alquilatusvehiculos.repository.AlquilerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/alquileres")
public class AlquilerController {

    private final AlquilerRepository alquilerRepository;

    public AlquilerController(AlquilerRepository alquilerRepository) {
        this.alquilerRepository = alquilerRepository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("alquileres", alquilerRepository.findAll());
        model.addAttribute("activos", alquilerRepository.findAll().stream()
                .filter(a -> a.getEstado().name().equals("ACTIVO")).count());
        model.addAttribute("pendientes", alquilerRepository.findAll().stream()
                .filter(a -> a.getEstado().name().equals("PENDIENTE")).count());
        return "alquileres/lista";
    }
}