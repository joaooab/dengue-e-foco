package com.dengueefoco.model;


import javax.persistence.*;
import java.util.Date;

@Entity(name = "ovitrampa")
public class Ovitrampa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name="paleta_id", nullable=false)
    private Paleta paleta;
    @Column(name = "data_leitura")
    private Date dataLeitura;
    @Column(name = "qtd_ovos")
    private Long qtdOvos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paleta getPaleta() {
        return paleta;
    }

    public void setPaleta(Paleta paleta) {
        this.paleta = paleta;
    }

    public Date getDataLeitura() {
        return dataLeitura;
    }

    public void setDataLeitura(Date dataLeitura) {
        this.dataLeitura = dataLeitura;
    }

    public Long getQtdOvos() {
        return qtdOvos;
    }

    public void setQtdOvos(Long qtdOvos) {
        this.qtdOvos = qtdOvos;
    }

}
