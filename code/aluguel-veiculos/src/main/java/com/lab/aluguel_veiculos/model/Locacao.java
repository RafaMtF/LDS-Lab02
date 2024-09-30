package com.lab.aluguel_veiculos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "locacao")
public class Locacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLocacao;

    @ManyToOne
    @JoinColumn(name = "id_automovel", referencedColumnName = "idAutomovel")
    private Automovel automovel;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "idCliente")
    private Cliente cliente;

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

    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
