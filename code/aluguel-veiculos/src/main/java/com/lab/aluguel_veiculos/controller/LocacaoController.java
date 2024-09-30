package com.lab.aluguel_veiculos.controller;

import com.lab.aluguel_veiculos.model.Locacao;
import com.lab.aluguel_veiculos.service.LocacaoService;

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
@RequestMapping("/api/locacoes")
public class LocacaoController {

    @Autowired
    private LocacaoService locacaoService;

    @Operation(summary = "Lista todas as locações", description = "Lista todas as locações do sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Locações encontradas",
                    content = @Content(schema = @Schema(implementation = Locacao.class))),
            @ApiResponse(responseCode = "204", description = "Nenhuma locação encontrada", content = @Content)
    })
    @GetMapping
    public List<Locacao> listarLocacoes() {
        return locacaoService.listarLocacoes();
    }

    @Operation(summary = "Obtém uma locação por ID", description = "Obtém uma locação do sistema por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Locação encontrada",
                    content = @Content(schema = @Schema(implementation = Locacao.class))),
            @ApiResponse(responseCode = "404", description = "Locação não encontrada", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Locacao> obterLocacaoPorId(@PathVariable Long id) {
        Locacao locacao = locacaoService.obterLocacaoPorId(id);
        if (locacao != null) {
            return ResponseEntity.ok(locacao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Cria uma nova locação", description = "Cria uma nova locação no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Locação criada com sucesso",
                    content = @Content(schema = @Schema(implementation = Locacao.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro ao salvar a locação", content = @Content)
    })
    @PostMapping
    public Locacao criarLocacao(@RequestBody Locacao locacao) {
        return locacaoService.salvarLocacao(locacao);
    }

    @Operation(summary = "Deleta uma locação", description = "Deleta uma locação no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Locação deletada com sucesso", content = @Content),
            @ApiResponse(responseCode = "404", description = "Locação não encontrada", content = @Content)
    })
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