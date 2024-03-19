package com.company.domain.veiculo.objetos;

import com.company.domain.Identificador;

public class CarroTamanhoPequeno {

    private final String valor;

    private CarroTamanhoPequeno(String valor) {
        this.valor = valor;
        this.validar();
    }

    public static CarroTamanhoPequeno criar(String id) {
        return new CarroTamanhoPequeno(id);
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
