package com.example.powerguard.dto;

import jakarta.validation.constraints.NotBlank;

public class EventRequestDTO {

    @NotBlank
    private String tipo;

    @NotBlank
    private String descricao;

    private String localizacao;

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }
}