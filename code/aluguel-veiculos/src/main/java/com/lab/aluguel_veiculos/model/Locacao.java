package com.lab.aluguel_veiculos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "locacao")
public class Locacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLocacao;

    private Long idCliente;  // Representando a relação com Cliente por ID
    private Long idAutomovel; // Representando a relação com Automovel por ID
    private String duracao;  // Duracao como String (pode ser enum mapeado)
    private String statusLocacao;  // Status como String (pode ser enum mapeado)
    private String dataAprovacao;

    // Getters e Setters
    public Long getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(Long idLocacao) {
        this.idLocacao = idLocacao;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdAutomovel() {
        return idAutomovel;
    }

    public void setIdAutomovel(Long idAutomovel) {
        this.idAutomovel = idAutomovel;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getStatusLocacao() {
        return statusLocacao;
    }

    public void setStatusLocacao(String statusLocacao) {
        this.statusLocacao = statusLocacao;
    }

    public String getDataAprovacao() {
        return dataAprovacao;
    }

    public void setDataAprovacao(String dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }
}
