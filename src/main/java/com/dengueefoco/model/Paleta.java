package com.dengueefoco.model;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;
import java.util.Set;

@JsonRootName("paleta")
@Entity(name = "paleta")
public class Paleta {

    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    private Distrito distrito;
    private Double Longitude;
    private Double Latitude;
    @OneToMany(mappedBy = "paleta", targetEntity = Ovitrampa.class, cascade = CascadeType.ALL)
    private Set<Ovitrampa> ovitrampaSet;

    private static boolean contais(String distrito, String distritoEnum) {
        return distrito.toUpperCase().contains(distritoEnum);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public void setDistrito(String distrito) {
        if (contais(distrito, Distrito.CENTRAL.valor)) {
            this.distrito = Distrito.CENTRAL;
        } else if (contais(distrito, Distrito.LESTE.valor)) {
            this.distrito = Distrito.LESTE;
        } else if (contais(distrito, Distrito.SUL.valor)) {
            this.distrito = Distrito.SUL;
        } else if (contais(distrito, Distrito.SUDOESTE.valor)) {
            this.distrito = Distrito.SUDOESTE;
        } else if (contais(distrito, Distrito.OESTE.valor)) {
            this.distrito = Distrito.OESTE;
        } else if (contais(distrito, Distrito.NOROESTE.valor)) {
            this.distrito = Distrito.NOROESTE;
        } else if (contais(distrito, Distrito.NORTE.valor)) {
            this.distrito = Distrito.NORTE;
        }
    }

    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(Double longitude) {
        Longitude = longitude;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public void setLatitude(Double latitude) {
        Latitude = latitude;
    }

    public Set<Ovitrampa> getOvitrampaSet() {
        return ovitrampaSet;
    }

    public void setOvitrampaSet(Set<Ovitrampa> ovitrampaSet) {
        this.ovitrampaSet = ovitrampaSet;
    }

}
