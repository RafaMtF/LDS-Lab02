package com.lab.aluguel_veiculos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.aluguel_veiculos.model.ContratoCredito;
import com.lab.aluguel_veiculos.repository.ContratoCreditoRepository;

@Service
public class ContratoCreditoService {

    @Autowired
    private ContratoCreditoRepository contratoCreditoRepository;

    public List<ContratoCredito> listarContratosCredito() {
        return contratoCreditoRepository.findAll();
    }

    public ContratoCredito obterContratoCreditoPorId(Long id) {
        return contratoCreditoRepository.findById(id).orElse(null);
    }

    public ContratoCredito salvarContratoCredito(ContratoCredito contratoCredito) {
        return contratoCreditoRepository.save(contratoCredito);
    }

    public void deletarContratoCredito(Long id) {
        contratoCreditoRepository.deleteById(id);
    }
}
