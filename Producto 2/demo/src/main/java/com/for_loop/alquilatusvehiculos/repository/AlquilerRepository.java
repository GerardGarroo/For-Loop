package com.for_loop.alquilatusvehiculos.repository;

import com.for_loop.alquilatusvehiculos.model.Alquiler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, Long>{
}
