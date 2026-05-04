package com.for_loop.alquilatusvehiculos.service;

import com.for_loop.alquilatusvehiculos.model.Cliente;
import com.for_loop.alquilatusvehiculos.repository.ClienteRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final ClienteRepository clienteRepository;

    public UserDetailsServiceImpl(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        Cliente cliente = clienteRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("Usuario no encontrado:"+ email));

        return new User(
                cliente.getEmail(),
                cliente.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_" + cliente.getRol().name()))

        );

    }


}
