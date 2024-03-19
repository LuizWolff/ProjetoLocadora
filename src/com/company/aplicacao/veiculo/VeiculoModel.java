package com.company.aplicacao.veiculo;

import com.company.domain.veiculo.objetos.Tamanho;

import java.util.Objects;

public final class VeiculoModel {
    private final String id;
    private final Tamanho tamanho;
    private final String modelo;
    private final String cor;
    private final Integer ano;

   public VeiculoModel(
           String id,
           Tamanho tamanho,
           String modelo,
           String cor,
           int ano
    ) {
        this.id = id;
        this.tamanho = tamanho;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
    }


    public String id() {
        return id;
    }

    public Tamanho tamanho() {
        return tamanho;
    }

    public String modelo() {
        return modelo;
    }

    public String cor() {
        return cor;
    }

    public Integer ano() {
        return ano;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (VeiculoModel) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.tamanho, that.tamanho) &&
                Objects.equals(this.modelo, that.modelo) &&
                Objects.equals(this.cor, that.cor) &&
                Objects.equals(this.ano, that.ano);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tamanho, modelo, cor, ano);
    }

    @Override
    public String toString() {
        return "VeiculoModel[" +
                "id=" + id + ", " +
                "tamanho=" + tamanho + ", " +
                "modelo=" + modelo + ", " +
                "cor=" + cor + ", " +
                "ano=" + ano + ']';
    }


}