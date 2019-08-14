package com.dengueefoco.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@JsonRootName("antivetorial2")
@Entity(name = "antivetorial2")
public class Antivetorial2 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name =  "id_usuario")
	private Long idUsuario;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	@Column(name = "data_visitada")
	private Date dataVisita;
	@Column(name = "larvicida")
	private String larvicida;
	@Column(name = "qtd_larvicida")
	private String qtdLarvicida;
	@Column(name = "tipo_imovel")
	private String tipoImovel;
	@Column(name = "longitude")
	private Double longitude;
	@Column(name = "latitude")
	private Double latitude;
	private String status;
	private Boolean notificado;
	private Boolean imovelFoco;
	private String quadra;
	@Column(name = "num_lote")
	private String numLote;
	private String logradouro;
	private String observacao;
    @Column(name = "quarteirao")
	private String quarteirao;
	private String lado;
	private String cilo;
	private String distrito;
	private String pendencia;
    @Column(name = "qtd_foco")
	private String qtdFoco;
	private String sequencia;
    @Column(name = "qtd_dep_tratado")
	private String qtdDepTratado;
    @Column(name = "tipo_foco")
    private String tipoFoco;
    @Column(name = "num_dep_eliminado")
    private String numDepEliminado;
    private String bairro;

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

	public String getQtdLarvicida() {
		return qtdLarvicida;
	}

	public void setQtdLarvicida(String qtdLarvicida) {
		this.qtdLarvicida = qtdLarvicida;
	}

	public String getTipoImovel() {
		return tipoImovel;
	}

	public void setTipoImovel(String tipoImovel) {
		this.tipoImovel = tipoImovel;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getNotificado() {
		return notificado;
	}

	public void setNotificado(Boolean notificado) {
		this.notificado = notificado;
	}

	public String getQuadra() {
		return quadra;
	}

	public void setQuadra(String quadra) {
		this.quadra = quadra;
	}

	public String getNumLote() {
		return numLote;
	}

	public void setNumLote(String numLote) {
		this.numLote = numLote;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getQuarteirao() {
		return quarteirao;
	}

	public void setQuarteirao(String quarteirao) {
		this.quarteirao = quarteirao;
	}

	public String getLado() {
		return lado;
	}

	public void setLado(String lado) {
		this.lado = lado;
	}

	public String getCilo() {
		return cilo;
	}

	public void setCilo(String cilo) {
		this.cilo = cilo;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getPendencia() {
		return pendencia;
	}

	public void setPendencia(String pendencia) {
		this.pendencia = pendencia;
	}

	public Boolean getImovelFoco() {
		return imovelFoco;
	}

	public void setImovelFoco(Boolean imovelFoco) {
		this.imovelFoco = imovelFoco;
	}

	public String getQtdFoco() {
		return qtdFoco;
	}

	public void setQtdFoco(String qtdFoco) {
		this.qtdFoco = qtdFoco;
	}

    public String getSequencia() {
        return sequencia;
    }

    public void setSequencia(String sequencia) {
        this.sequencia = sequencia;
    }

    public String getQtdDepTratado() {
        return qtdDepTratado;
    }

    public void setQtdDepTratado(String qtdDepTratado) {
        this.qtdDepTratado = qtdDepTratado;
    }

    public String getTipoFoco() {
        return tipoFoco;
    }

    public void setTipoFoco(String tipoFoco) {
        this.tipoFoco = tipoFoco;
    }

    public String getNumDepEliminado() {
        return numDepEliminado;
    }

    public void setNumDepEliminado(String numDepEliminado) {
        this.numDepEliminado = numDepEliminado;
    }

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

}

