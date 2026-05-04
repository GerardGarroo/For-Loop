package com.for_loop.alquilatusvehiculos.controller;

import com.for_loop.alquilatusvehiculos.model.Cliente;
import com.for_loop.alquilatusvehiculos.repository.ClienteRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

    @Controller
    @RequestMapping("/user")

    public class UserController{
        private final ClienteRepository clienteRepository;

        public UserController(ClienteRepository clienteRepository){
            this.clienteRepository = clienteRepository;
        }

        @GetMapping("/mis-alquileres")
        public String misAlquileres(Authentication authentication, Model model){
            String email = authentication.getName();
            Cliente cliente = clienteRepository.findByEmail(email)
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            model.addAttribute("cliente",cliente);
            model.addAttribute("activePage","mis-alquileres");
            return "user/mis-alquileres";

        }
    }