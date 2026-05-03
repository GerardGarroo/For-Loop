package com.for_loop.alquilatusvehiculos.controller.api;

import com.for_loop.alquilatusvehiculos.model.Alquiler;
import com.for_loop.alquilatusvehiculos.repository.AlquilerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/alquileres")
public class AlquilerApiController {

    private final AlquilerRepository alquilerRepository;
    public AlquilerApiController(AlquilerRepository alquilerRepository){
        this.alquilerRepository = alquilerRepository;
    }
    @GetMapping
    public List<Alquiler> getAll(){
        return alquilerRepository.findAll();
    }
}

