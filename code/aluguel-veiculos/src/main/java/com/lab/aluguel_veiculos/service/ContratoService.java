package com.lab.aluguel_veiculos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.aluguel_veiculos.model.Contrato;
import com.lab.aluguel_veiculos.repository.ContratoRepository;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    public List<Contrato> listarContratos() {
        return contratoRepository.findAll();
    }

    public Contrato obterContratoPorId(Long id) {
        return contratoRepository.findById(id).orElse(null);
    }

    public Contrato salvarContrato(Contrato contrato) {
        return contratoRepository.save(contrato);
    }

    public void deletarContrato(Long id) {
        contratoRepository.deleteById(id);
    }
}
