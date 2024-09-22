package main.java.com.lab.aluguel_veiculos.controller;

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

import com.lab.aluguel_veiculos.model.Contrato;
import com.lab.aluguel_veiculos.service.ContratoService;

@RestController
@RequestMapping("/api/contratos")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @GetMapping
    public List<Contrato> listarContratos() {
        return contratoService.listarContratos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrato> obterContratoPorId(@PathVariable Long id) {
        Contrato contrato = contratoService.obterContratoPorId(id);
        if (contrato != null) {
            return ResponseEntity.ok(contrato);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Contrato criarContrato(@RequestBody Contrato contrato) {
        return contratoService.salvarContrato(contrato);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarContrato(@PathVariable Long id) {
        Contrato contrato = contratoService.obterContratoPorId(id);
        if (contrato != null) {
            contratoService.deletarContrato(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
