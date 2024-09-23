package main.java.com.lab.aluguel_veiculos.controller;

import com.lab.aluguel_veiculos.model.Contrato;
import com.lab.aluguel_veiculos.service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
