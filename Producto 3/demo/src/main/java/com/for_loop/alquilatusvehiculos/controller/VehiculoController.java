package com.for_loop.alquilatusvehiculos.controller;

import com.for_loop.alquilatusvehiculos.model.Vehiculo;
import com.for_loop.alquilatusvehiculos.repository.VehiculoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vehiculos")
public class VehiculoController {

    private final VehiculoRepository vehiculoRepository;

    public VehiculoController(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    // LISTAR
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("vehiculos", vehiculoRepository.findAll());
        return "vehiculos/lista";
    }

    // MOSTRAR FORMULARIO NUEVO
    @GetMapping("/new")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("vehiculo", new Vehiculo());
        model.addAttribute("tipos", Vehiculo.TipoVehiculo.values());
        model.addAttribute("estados", Vehiculo.EstadoVehiculo.values());
        return "vehiculos/formulario";
    }

    // MOSTRAR FORMULARIO EDITAR
    @GetMapping("/{id}/edit")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Vehiculo vehiculo = vehiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehiculo no encontrado"));
        model.addAttribute("vehiculo", vehiculo);
        model.addAttribute("tipos", Vehiculo.TipoVehiculo.values());
        model.addAttribute("estados", Vehiculo.EstadoVehiculo.values());
        return "vehiculos/formulario";
    }

    // GUARDAR
    @PostMapping("/save")
    public String guardar(@ModelAttribute Vehiculo vehiculo) {
        vehiculoRepository.save(vehiculo);
        return "redirect:/vehiculos";
    }

    // BORRAR
    @GetMapping("/{id}/delete")
    public String borrar(@PathVariable Long id) {
        vehiculoRepository.deleteById(id);
        return "redirect:/vehiculos";
    }
}