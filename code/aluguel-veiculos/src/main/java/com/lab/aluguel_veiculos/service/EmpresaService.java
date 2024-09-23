package com.lab.aluguel_veiculos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.aluguel_veiculos.model.Empresa;
import com.lab.aluguel_veiculos.repository.EmpresaRepository;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empresa> listarEmpresas() {
        return empresaRepository.findAll();
    }

    public Empresa obterEmpresaPorId(Long id) {
        return empresaRepository.findById(id).orElse(null);
    }

    public Empresa salvarEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public void deletarEmpresa(Long id) {
        empresaRepository.deleteById(id);
    }
}
