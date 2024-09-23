package com.lab.aluguel_veiculos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contrato_credito")
public class ContratoCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContratoCredito;

    private Long idLocacao;  // Representando a relação com Locacao por ID
    private Long idBanco;    // Representando a relação com Banco por ID
    private Double valorCredito;
    private String dataAprovacao;

    // Getters e Setters
    public Long getIdContratoCredito() {
        return idContratoCredito;
    }

    public void setIdContratoCredito(Long idContratoCredito) {
        this.idContratoCredito = idContratoCredito;
    }

    public Long getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(Long idLocacao) {
        this.idLocacao = idLocacao;
    }

    public Long getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Long idBanco) {
        this.idBanco = idBanco;
    }

    public Double getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(Double valorCredito) {
        this.valorCredito = valorCredito;
    }

    public String getDataAprovacao() {
        return dataAprovacao;
    }

    public void setDataAprovacao(String dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }
}
