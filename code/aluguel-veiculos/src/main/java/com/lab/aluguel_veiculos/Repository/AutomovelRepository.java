package com.lab.aluguel_veiculos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lab.aluguel_veiculos.model.Automovel;

public interface AutomovelRepository extends JpaRepository<Automovel, Long> {
    
}