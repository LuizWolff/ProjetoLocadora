package com.company.aplicacao.cliente;

import com.company.domain.cliente.objetos.Tipo;

import java.util.Objects;

public final class ClienteModel {
    private final String id;
    private final String nome;
    private final String email;
    private final String logradouro;
    private final String bairro;
    private final String cep;
    private final String cidade;
    private final String estado;
    private final Tipo tipo;

    public ClienteModel(
            String id,
            String nome,
            String email,
            String logradouro,
            String bairro,
            String cep,
            String cidade,
            String estado,
            Tipo tipo
    ) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.tipo = tipo;
    }

    public String id() {
        return id;
    }

    public String nome() {
        return nome;
    }

    public String email() {
        return email;
    }

    public String logradouro() {
        return logradouro;
    }

    public String bairro() {
        return bairro;
    }

    public String cep() {
        return cep;
    }

    public String cidade() {
        return cidade;
    }

    public String estado() {
        return estado;
    }

    public Tipo tipo() {
        return tipo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ClienteModel) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.nome, that.nome) &&
                Objects.equals(this.email, that.email) &&
                Objects.equals(this.logradouro, that.logradouro) &&
                Objects.equals(this.bairro, that.bairro) &&
                Objects.equals(this.cep, that.cep) &&
                Objects.equals(this.cidade, that.cidade) &&
                Objects.equals(this.estado, that.estado) &&
                Objects.equals(this.tipo, that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, logradouro, bairro, cep, cidade, estado, tipo);
    }

    @Override
    public String toString() {
        return "ClienteModel[" +
                "id=" + id + ", " +
                "nome=" + nome + ", " +
                "email=" + email + ", " +
                "logradouro=" + logradouro + ", " +
                "bairro=" + bairro + ", " +
                "cep=" + cep + ", " +
                "cidade=" + cidade + ", " +
                "estado=" + estado + ", " +
                "tipo=" + tipo + ']';
    }

}