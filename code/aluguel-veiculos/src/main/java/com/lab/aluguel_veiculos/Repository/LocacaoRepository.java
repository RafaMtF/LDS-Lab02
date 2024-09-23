package com.lab.aluguel_veiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab.aluguel_veiculos.model.Locacao;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {
}
