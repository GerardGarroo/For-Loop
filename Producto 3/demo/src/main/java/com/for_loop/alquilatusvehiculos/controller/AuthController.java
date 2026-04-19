package com.for_loop.alquilatusvehiculos.controller;

import com.for_loop.alquilatusvehiculos.model.Cliente;
import com.for_loop.alquilatusvehiculos.repository.ClienteRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;


@Controller
public class AuthController {

    private final ClienteRepository clienteRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(ClienteRepository clienteRepository, PasswordEncoder passwordEncoder){
        this.clienteRepository = clienteRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @GetMapping("/login")
    public String login(){
        return "auth/login";
    }

    @GetMapping("/registro")
    public String mostrarRegistro(Model model){
        model.addAttribute("cliente",new Cliente());
        return "auth/registro";
    }

    @PostMapping("/registro")
    public String registrar(@ModelAttribute Cliente cliente){
        cliente.setPassword(passwordEncoder.encode(cliente.getPassword()));
        cliente.setRol(Cliente.RolUsuario.USER);
        cliente.setFechaRegistro(LocalDate.now());
        clienteRepository.save(cliente);
        return "redirect:/login";
    }

}
