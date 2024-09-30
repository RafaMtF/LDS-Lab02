package com.lab.aluguel_veiculos.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lab.aluguel_veiculos.model.Cliente;
import com.lab.aluguel_veiculos.service.ClienteService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Operation(summary = "Lista todos os clientes", description = "Lista todos os clientes do sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Clientes encontrados",
                    content = @Content(schema = @Schema(implementation = Cliente.class))),
            @ApiResponse(responseCode = "204", description = "Nenhum cliente encontrado", content = @Content)
    })
    @GetMapping
    public List<Cliente> getAllClientes(){
        return clienteService.findAllClientes();
    }

    @Operation(summary = "Obtém um cliente por ID", description = "Obtém um cliente do sistema por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado",
                    content = @Content(schema = @Schema(implementation = Cliente.class))),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado", content = @Content)
    })
    @GetMapping("/{id}")
    public Optional<Cliente> findClienteById(@PathVariable Long id){
        return clienteService.findClienteById(id);
    }

    @Operation(summary = "Cria um novo cliente", description = "Cria um novo cliente no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso",
                    content = @Content(schema = @Schema(implementation = Cliente.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro ao salvar o cliente", content = @Content)
    })
    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente){
        return clienteService.saveCliente(cliente);
    }

    @Operation(summary = "Altera um cliente", description = "Altera um cliente no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente alterado com sucesso",
                    content = @Content(schema = @Schema(implementation = Cliente.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos", content = @Content),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro ao salvar o cliente", content = @Content)
    })
    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente updatedCliente){
        return clienteService.updateCliente(id, updatedCliente);
    }

    @Operation(summary = "Deleta um cliente", description = "Deleta um cliente do sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Cliente deletado com sucesso", content = @Content),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado", content = @Content)
    })
    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id){
        clienteService.deleteClienteById(id);
    }
}