package com.lab.aluguel_veiculos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "automovel")
public class Automovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutomovel;
    
    private String matricula;
    private Integer ano;
    private String marca;
    private String modelo;
    private String placa;
    private Long idEmpresa;

    public Long getIdAutomovel() {
        return idAutomovel;
    }
    public void setIdAutomovel(Long idAutomovel) {
        this.idAutomovel = idAutomovel;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public Integer getAno() {
        return ano;
    }
    public void setAno(Integer ano) {
        this.ano = ano;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public Long getIdEmpresa() {
        return idEmpresa;
    }
    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    
}
