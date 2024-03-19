package com.company.domain.veiculo.objetos;

import com.company.domain.Identificador;

public class CarroTamanhoMedio {

    private final String valor;

    private CarroTamanhoMedio(String valor) {
        this.valor = valor;
        this.validar();
    }

    public static CarroTamanhoMedio criar(String id) {
        return new CarroTamanhoMedio(id);
    }

    public String valor() {
        return this.valor;
    }

    private void validar() {
        if (this.valor == null || this.valor.length() != 11) {
            throw new IllegalArgumentException("CPF são 11 caracteres!");
        }
    }
}
