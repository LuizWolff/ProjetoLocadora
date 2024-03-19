package com.company.domain.veiculo.objetos;

import com.company.domain.Identificador;

public class Placa extends Identificador<String> {

    private final String valor;

    private Placa(String valor) {
        this.valor = valor;
        this.validar();
    }

    public static Placa criar(String id) {
        return new Placa(id);
    }

    public String valor() {
        return this.valor;
    }

    private void validar() {
        if (this.valor == null || this.valor.length() != 7) {
            throw new IllegalArgumentException("Placa são 7 caracteres!");
        }
    }
}
