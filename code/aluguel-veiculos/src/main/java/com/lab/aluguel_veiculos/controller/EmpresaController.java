package com.lab.aluguel_veiculos.controller;

import com.lab.aluguel_veiculos.model.Empresa;
import com.lab.aluguel_veiculos.service.EmpresaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @Operation(summary = "Lista todas as empresas", description = "Lista todas as empresas do sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Empresas encontradas"),
            @ApiResponse(responseCode = "204", description = "Nenhuma empresa encontrada")
    })
    @GetMapping
    public List<Empresa> listarEmpresas() {
        return empresaService.listarEmpresas();
    }

    @Operation(summary = "Obtém uma empresa por ID", description = "Obtém uma empresa do sistema por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Empresa encontrada",
                    content = @Content(schema = @Schema(implementation = Empresa.class))),
            @ApiResponse(responseCode = "404", description = "Empresa não encontrada", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Empresa> obterEmpresaPorId(@PathVariable Long id) {
        Empresa empresa = empresaService.obterEmpresaPorId(id);
        if (empresa != null) {
            return ResponseEntity.ok(empresa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Altera uma empresa", description = "Altera uma empresa no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Empresa alterada com sucesso",
                    content = @Content(schema = @Schema(implementation = Empresa.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos", content = @Content),
            @ApiResponse(responseCode = "404", description = "Empresa não encontrada", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro ao salvar a empresa", content = @Content)
    })
    @PostMapping
    public Empresa criarEmpresa(@RequestBody Empresa empresa) {
        return empresaService.salvarEmpresa(empresa);
    }

    @Operation(summary = "Deleta uma empresa", description = "Deleta uma empresa no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Empresa deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Empresa não encontrada")
    })
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