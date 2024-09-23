package com.lab.aluguel_veiculos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.aluguel_veiculos.model.Banco;
import com.lab.aluguel_veiculos.service.BancoService;

@RestController
@RequestMapping("/api/bancos")
public class BancoController {

    @Autowired
    private BancoService bancoService;

    @GetMapping
    public List<Banco> listarBancos() {
        return bancoService.listarBancos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Banco> obterBancoPorId(@PathVariable Long id) {
        Banco banco = bancoService.obterBancoPorId(id);
        if (banco != null) {
            return ResponseEntity.ok(banco);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Banco criarBanco(@RequestBody Banco banco) {
        return bancoService.salvarBanco(banco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarBanco(@PathVariable Long id) {
        Banco banco = bancoService.obterBancoPorId(id);
        if (banco != null) {
            bancoService.deletarBanco(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
