package com.company.domain.locacao.objetos;

import com.company.domain.Identificador;

public class LocacaoId extends Identificador<String> {

    private final String valor;

    private LocacaoId(String valor) {
        this.valor = valor;
        this.validar();
    }

    public static LocacaoId criar(String id) {
        return new LocacaoId(id);
    }

    public String valor() {
        return this.valor;
    }

    private void validar() {
        if (this.valor == null) {
            throw new IllegalArgumentException("LocacaoId não pode ser nulo!");
        }
    }
}
