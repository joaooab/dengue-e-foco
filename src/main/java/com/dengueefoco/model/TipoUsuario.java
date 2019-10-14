package com.dengueefoco.model;

public enum TipoUsuario {
    ADMIM("Admin"), SUPERVISOR("Supervisor"),  AGENTE("Agente");

    public String valor;
    TipoUsuario(String valor) {
        this.valor = valor;
    }

}