package com.lab.aluguel_veiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lab.aluguel_veiculos.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
