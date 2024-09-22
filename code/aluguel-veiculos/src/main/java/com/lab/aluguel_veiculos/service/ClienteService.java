package com.lab.aluguel_veiculos.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lab.aluguel_veiculos.Repository.ClienteRepository;
import com.lab.aluguel_veiculos.model.Cliente;
import jakarta.transaction.Transactional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente saveCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAllClientes(){
        return clienteRepository.findAll();
    }

    public Optional <Cliente> findClienteById(Long id){
        return clienteRepository.findById(id);
    }

    @Transactional
    public Cliente updateCliente(Long id, Cliente updatedCliente){
        Optional<Cliente> existingCliente = clienteRepository.findById(id);
        if(existingCliente.isPresent()){
            Cliente cliente = existingCliente.get();
            cliente.setNome(updatedCliente.getNome());
            cliente.setRg(updatedCliente.getRg());
            cliente.setCpf(updatedCliente.getCpf());
            cliente.setEndereco(updatedCliente.getEndereco());
            cliente.setProfissao(updatedCliente.getProfissao());
            cliente.setEmpregador(updatedCliente.getEmpregador());
            cliente.setRendimentoUm(updatedCliente.getRendimentoUm());
            cliente.setRendimentoDois(updatedCliente.getRendimentoDois());
            cliente.setRendimentoTres(updatedCliente.getRendimentoTres());
            return clienteRepository.save(cliente);
        }else{
            throw new RuntimeException("Cliente com ID " + id + " não encontrado.");
        }
    }

    @Transactional
    public void deleteClienteById(Long id){
        if(clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cliente com ID " + id + " não encontrado.");
        }
    }
}
