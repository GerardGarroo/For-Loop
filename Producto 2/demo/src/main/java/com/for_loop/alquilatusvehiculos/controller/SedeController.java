package com.for_loop.alquilatusvehiculos.controller;

import com.for_loop.alquilatusvehiculos.repository.SedeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sedes")
public class SedeController {

    private final SedeRepository sedeRepository;

    public SedeController(SedeRepository sedeRepository) {
        this.sedeRepository = sedeRepository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("sedes", sedeRepository.findAll());
        return "sedes/lista";
    }
}