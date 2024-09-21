package com.lab.aluguel_veiculos.controller;

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

    @GetMapping
    public List<Cliente> getAllClientes(){
        return clienteService.findAllClientes();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> findClienteById(@PathVariable Long id){
        return clienteService.findClienteById(id);
    }

    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente){
        return clienteService.saveCliente(cliente);
    }

    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente updatedCliente){
        return clienteService.updateCliente(id, updatedCliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id){
        clienteService.deleteClienteById(id);
    }
}
