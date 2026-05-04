package com.for_loop.alquilatusvehiculos.controller.api;

import com.for_loop.alquilatusvehiculos.model.Cliente;
import com.for_loop.alquilatusvehiculos.repository.ClienteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

@SecurityRequirement(name = "Bearer Authentication")
@RestController
@RequestMapping("/api/clientes")
public class ClienteApiController {
    private final ClienteRepository clienteRepository;

    public ClienteApiController(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public List<Cliente> getAll(){
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cliente getById(@PathVariable Long id){
        return clienteRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Cliente no encontrado"));
    }
}
