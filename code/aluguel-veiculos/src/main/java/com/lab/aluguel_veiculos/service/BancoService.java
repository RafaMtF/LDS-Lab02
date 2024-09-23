package com.lab.aluguel_veiculos.service;

import com.lab.aluguel_veiculos.model.Banco;
import com.lab.aluguel_veiculos.repository.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BancoService {

    @Autowired
    private BancoRepository bancoRepository;

    public List<Banco> listarBancos() {
        return bancoRepository.findAll();
    }

    public Banco obterBancoPorId(Long id) {
        return bancoRepository.findById(id).orElse(null);
    }

    public Banco salvarBanco(Banco banco) {
        return bancoRepository.save(banco);
    }

    public void deletarBanco(Long id) {
        bancoRepository.deleteById(id);
    }
}
