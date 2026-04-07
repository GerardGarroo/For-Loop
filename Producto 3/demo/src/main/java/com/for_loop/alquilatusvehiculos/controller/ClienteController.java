package com.for_loop.alquilatusvehiculos.controller;

import com.for_loop.alquilatusvehiculos.repository.ClienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // LISTAR
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("clientes", clienteRepository.findAll());
        return "clientes/lista";
    }

    // VER FICHA
    @GetMapping("/{id}")
    public String ver(@PathVariable Long id, Model model) {
        model.addAttribute("cliente", clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado")));
        return "clientes/ficha";
    }
}