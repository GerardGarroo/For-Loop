package com.for_loop.alquilatusvehiculos.repository;

import com.for_loop.alquilatusvehiculos.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
}
