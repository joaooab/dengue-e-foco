package com.dengueefoco.model;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;
import java.util.Date;

@JsonRootName("antivetorial")
@Entity(name = "antivetorial")
public class Antivetorial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "id_usuario")
    private Long idUsuario;
    @Column(name = "data_visita")
    private Date dataVisita;
    private String larvicida;
    @Column(name = "qtd_larvicida")
    private Double qtdLarvicida;
    @Column(name = "status_imovel")
    private String statusImovel;
    @Column(name = "tipo_imovel")
    private String tipoImovel;
    private String regiao;
    private Double longitude;
    private Double latitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getDataVisita() {
        return dataVisita;
    }

    public void setDataVisita(Date dataVisita) {
        this.dataVisita = dataVisita;
    }

    public String getLarvicida() {
        return larvicida;
    }

    public void setLarvicida(String larvicida) {
        this.larvicida = larvicida;
    }

    public Double getQtdLarvicida() {
        return qtdLarvicida;
    }

    public void setQtdLarvicida(Double qtdLarvicida) {
        this.qtdLarvicida = qtdLarvicida;
    }

    public String getStatusImovel() {
        return statusImovel;
    }

    public void setStatusImovel(String statusImovel) {
        this.statusImovel = statusImovel;
    }

    public String getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(String tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

}