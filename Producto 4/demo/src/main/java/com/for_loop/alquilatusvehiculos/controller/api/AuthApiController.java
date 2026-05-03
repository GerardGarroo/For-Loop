package com.for_loop.alquilatusvehiculos.controller.api;


import com.for_loop.alquilatusvehiculos.model.Cliente;
import com.for_loop.alquilatusvehiculos.repository.ClienteRepository;
import com.for_loop.alquilatusvehiculos.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthApiController {
    private final ClienteRepository clienteRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthApiController(ClienteRepository clienteRepository,
                             PasswordEncoder passwordEncoder,
                             JwtService jwtService){
        this.clienteRepository = clienteRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String,String> credentials){
        String email = credentials.get("email");
        String password = credentials.get("password");

        Cliente cliente = clienteRepository.findByEmail(email).orElse(null);

        if(cliente ==null || !passwordEncoder.matches(password, cliente.getPassword())){
            return ResponseEntity.status(401).body(Map.of("error", "Credenciales incorrectas"));
        }
        String token = jwtService.generateToken(email);
        return ResponseEntity.ok(Map.of(
                "token", token,
                "email", email,
                "rol", cliente.getRol().name()
        ));
    }
}
