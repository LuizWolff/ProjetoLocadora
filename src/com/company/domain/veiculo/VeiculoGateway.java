package com.company.domain.veiculo;

import java.util.List;

public interface VeiculoGateway {

    void registrar(Veiculo veiculo);

    void atualizar(Veiculo veiculo);

    Veiculo buscarPorId(String id);

    List<Veiculo> buscarTodos();

}
