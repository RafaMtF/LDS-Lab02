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

import com.lab.aluguel_veiculos.model.ContratoCredito;
import com.lab.aluguel_veiculos.service.ContratoCreditoService;

@RestController
@RequestMapping("/api/contratos_credito")
public class ContratoCreditoController {

    @Autowired
    private ContratoCreditoService contratoCreditoService;

    @GetMapping
    public List<ContratoCredito> listarContratosCredito() {
        return contratoCreditoService.listarContratosCredito();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratoCredito> obterContratoCreditoPorId(@PathVariable Long id) {
        ContratoCredito contratoCredito = contratoCreditoService.obterContratoCreditoPorId(id);
        if (contratoCredito != null) {
            return ResponseEntity.ok(contratoCredito);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ContratoCredito criarContratoCredito(@RequestBody ContratoCredito contratoCredito) {
        return contratoCreditoService.salvarContratoCredito(contratoCredito);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarContratoCredito(@PathVariable Long id) {
        ContratoCredito contratoCredito = contratoCreditoService.obterContratoCreditoPorId(id);
        if (contratoCredito != null) {
            contratoCreditoService.deletarContratoCredito(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
