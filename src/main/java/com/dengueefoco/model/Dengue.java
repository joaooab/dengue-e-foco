package com.dengueefoco.model;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;
import java.util.Date;

@JsonRootName("dengue")
@Entity(name = "dengue")
public class Dengue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "data_sin_pri")
    private Date dataSinPri;
    @Column(name = "sem_pri")
    private String semPri;
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    @Column(name = "nu_idade")
    private String nuIdade;
    private String sexo;
    @Column(name = "id_min_resi")
    private String idMinResi;
    @Column(name = "id_destrituo")
    private String idDestrito;
    @Column(name = "id_bairro")
    private String idBairro;
    @Column(name = "nm_bairro")
    private String nmBairro;
    @Column(name = "id_logradouro")
    private String idLogradouro;
    @Column(name = "nm_logradouro")
    private String nmLogradouro;
    @Column(name = "nu_numero")
    private String nuNumero;
    @Column(name = "nm_complem")
    private String nmComplem;
    @Column(name = "classi_fin")
    private String classiFin;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataSinPri() {
        return dataSinPri;
    }

    public void setDataSinPri(Date dataSinPri) {
        this.dataSinPri = dataSinPri;
    }

    public String getSemPri() {
        return semPri;
    }

    public void setSemPri(String semPri) {
        this.semPri = semPri;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNuIdade() {
        return nuIdade;
    }

    public void setNuIdade(String nuIdade) {
        this.nuIdade = nuIdade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getIdMinResi() {
        return idMinResi;
    }

    public void setIdMinResi(String idMinResi) {
        this.idMinResi = idMinResi;
    }

    public String getIdDestrito() {
        return idDestrito;
    }

    public void setIdDestrito(String idDestrito) {
        this.idDestrito = idDestrito;
    }

    public String getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(String idBairro) {
        this.idBairro = idBairro;
    }

    public String getNmBairro() {
        return nmBairro;
    }

    public void setNmBairro(String nmBairro) {
        this.nmBairro = nmBairro;
    }

    public String getIdLogradouro() {
        return idLogradouro;
    }

    public void setIdLogradouro(String idLogradouro) {
        this.idLogradouro = idLogradouro;
    }

    public String getNmLogradouro() {
        return nmLogradouro;
    }

    public void setNmLogradouro(String nmLogradouro) {
        this.nmLogradouro = nmLogradouro;
    }

    public String getNuNumero() {
        return nuNumero;
    }

    public void setNuNumero(String nuNumero) {
        this.nuNumero = nuNumero;
    }

    public String getNmComplem() {
        return nmComplem;
    }

    public void setNmComplem(String nmComplem) {
        this.nmComplem = nmComplem;
    }

    public String getClassiFin() {
        return classiFin;
    }

    public void setClassiFin(String classiFin) {
        switch (classiFin) {
            case "10":
                this.classiFin = "DENGUE";
                break;
            case "8":
                this.classiFin = "INCONCLUSIVO";
                break;
            case "5":
                this.classiFin = "DESCARTADO";
                break;
            case "11":
                this.classiFin = "DENGUE COM SINAL_DE ALERTA";
                break;
            default:
                this.classiFin = "CASOS EM INVESTIGAÇÃO";
                break;
        }

    }
}
