package com.lab.aluguel_veiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab.aluguel_veiculos.model.Banco;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Long> {
}
