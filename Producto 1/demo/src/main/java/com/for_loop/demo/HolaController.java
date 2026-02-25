package com.for_loop.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {

    @GetMapping("/")
    public String hola(){
        return "Hola mundo Producto 1 funcionando!";
    }
}
