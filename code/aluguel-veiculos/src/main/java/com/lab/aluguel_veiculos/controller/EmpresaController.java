package com.lab.aluguel_veiculos.controller;

import com.lab.aluguel_veiculos.model.Empresa;
import com.lab.aluguel_veiculos.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public List<Empresa> listarEmpresas() {
        return empresaService.listarEmpresas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> obterEmpresaPorId(@PathVariable Long id) {
        Empresa empresa = empresaService.obterEmpresaPorId(id);
        if (empresa != null) {
            return ResponseEntity.ok(empresa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Empresa criarEmpresa(@RequestBody Empresa empresa) {
        return empresaService.salvarEmpresa(empresa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEmpresa(@PathVariable Long id) {
        Empresa empresa = empresaService.obterEmpresaPorId(id);
        if (empresa != null) {
            empresaService.deletarEmpresa(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
