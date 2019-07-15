package com.dengueefoco.model;

public enum Distrito {
    CENTRAL("CENTRAL"), LESTE("LESTE"), SUL("SUL"), SUDOESTE("SUDOESTE"), OESTE("OESTE"), NOROESTE("NOROESTE"), NORTE("NORTE");

    public String valor;

    Distrito(String valor) {
        this.valor = valor;
    }
}
