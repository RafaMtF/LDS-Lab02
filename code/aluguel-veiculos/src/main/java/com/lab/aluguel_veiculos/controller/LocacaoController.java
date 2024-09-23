package com.lab.aluguel_veiculos.controller;

import com.lab.aluguel_veiculos.model.Locacao;
import com.lab.aluguel_veiculos.service.LocacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locacoes")
public class LocacaoController {

    @Autowired
    private LocacaoService locacaoService;

    @GetMapping
    public List<Locacao> listarLocacoes() {
        return locacaoService.listarLocacoes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Locacao> obterLocacaoPorId(@PathVariable Long id) {
        Locacao locacao = locacaoService.obterLocacaoPorId(id);
        if (locacao != null) {
            return ResponseEntity.ok(locacao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Locacao criarLocacao(@RequestBody Locacao locacao) {
        return locacaoService.salvarLocacao(locacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLocacao(@PathVariable Long id) {
        Locacao locacao = locacaoService.obterLocacaoPorId(id);
        if (locacao != null) {
            locacaoService.deletarLocacao(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
