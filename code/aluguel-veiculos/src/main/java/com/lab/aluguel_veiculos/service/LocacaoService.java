package com.lab.aluguel_veiculos.service;

import com.lab.aluguel_veiculos.model.Locacao;
import com.lab.aluguel_veiculos.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocacaoService {

    @Autowired
    private LocacaoRepository locacaoRepository;

    public List<Locacao> listarLocacoes() {
        return locacaoRepository.findAll();
    }

    public Locacao obterLocacaoPorId(Long id) {
        return locacaoRepository.findById(id).orElse(null);
    }

    public Locacao salvarLocacao(Locacao locacao) {
        return locacaoRepository.save(locacao);
    }

    public void deletarLocacao(Long id) {
        locacaoRepository.deleteById(id);
    }
}
