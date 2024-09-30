package com.lab.aluguel_veiculos.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lab.aluguel_veiculos.model.Automovel;
import com.lab.aluguel_veiculos.service.AutomovelService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/automoveis")
public class AutomovelController {

    @Autowired
    private AutomovelService automovelService;

    @Operation(summary = "Lista todos os automóveis", description = "Lista todos os automóveis do sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Automóveis encontrados",
                    content = @Content(schema = @Schema(implementation = Automovel.class))),
            @ApiResponse(responseCode = "204", description = "Nenhum automóvel encontrado", content = @Content)
    })
    @GetMapping
    public List<Automovel> getAllAutomoveis(){
        return automovelService.findAllAutomoveis();
    }
    
    @Operation(summary = "Obtém um automóvel por ID", description = "Obtém um automóvel do sistema por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Automóvel encontrado",
                    content = @Content(schema = @Schema(implementation = Automovel.class))),
            @ApiResponse(responseCode = "404", description = "Automóvel não encontrado", content = @Content)
    })
    @GetMapping("/{id}")
    public Optional<Automovel> findAutomovelById(@PathVariable Long id){
        return automovelService.findAutomovelById(id);
    }

    @Operation(summary = "Cria um novo automóvel", description = "Cria um novo automóvel no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Automóvel criado com sucesso",
                    content = @Content(schema = @Schema(implementation = Automovel.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro ao salvar o automóvel", content = @Content)
    })
    @PostMapping
    public Automovel createAutomovel(@RequestBody Automovel automovel){
        return automovelService.saveAutomovel(automovel);
    }

    @Operation(summary = "Altera um automóvel", description = "Altera um automóvel no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Automóvel alterado com sucesso",
                    content = @Content(schema = @Schema(implementation = Automovel.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos", content = @Content),
            @ApiResponse(responseCode = "404", description = "Automóvel não encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro ao salvar o automóvel", content = @Content)
    })
    @PutMapping("/{id}")
    public Automovel updateAutomovel(@PathVariable Long id, @RequestBody Automovel updatedAutomovel){
        return automovelService.updateAutomovel(id, updatedAutomovel);
    }

    @Operation(summary = "Deleta um automóvel", description = "Deleta um automóvel do sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Automóvel deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Automóvel não encontrado")
    })
    @DeleteMapping("/{id}")
    public void deleteAutomovel(@PathVariable Long id){
        automovelService.deleteAutomovelById(id);
    }
}