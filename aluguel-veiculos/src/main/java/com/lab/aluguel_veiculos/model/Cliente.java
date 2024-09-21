package com.lab.aluguel_veiculos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    
    private String nome;
    private Long rg;
    private Long cpf;
    private String endereco;
    private String profissao;
    private String empregador;
    private Double rendimentoUm;
    private Double rendimentoDois;
    private Double rendimentoTres;
    
    public Long getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Long getRg() {
        return rg;
    }
    public void setRg(Long rg) {
        this.rg = rg;
    }
    public Long getCpf() {
        return cpf;
    }
    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getProfissao() {
        return profissao;
    }
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
    public String getEmpregador() {
        return empregador;
    }
    public void setEmpregador(String empregador) {
        this.empregador = empregador;
    }
    public Double getRendimentoUm() {
        return rendimentoUm;
    }
    public void setRendimentoUm(Double rendimentoUm) {
        this.rendimentoUm = rendimentoUm;
    }
    public Double getRendimentoDois() {
        return rendimentoDois;
    }
    public void setRendimentoDois(Double rendimentoDois) {
        this.rendimentoDois = rendimentoDois;
    }
    public Double getRendimentoTres() {
        return rendimentoTres;
    }
    public void setRendimentoTres(Double rendimentoTres) {
        this.rendimentoTres = rendimentoTres;
    }
}
