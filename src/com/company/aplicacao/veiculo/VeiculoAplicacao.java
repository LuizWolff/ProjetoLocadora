package com.company.aplicacao.veiculo;

import com.company.domain.Identificador;
import com.company.domain.veiculo.Veiculo;
import com.company.domain.veiculo.VeiculoGateway;
import com.company.domain.veiculo.objetos.*;

public class VeiculoAplicacao {
    private final VeiculoGateway gateway;

    public VeiculoAplicacao(VeiculoGateway gateway) {
        this.gateway = gateway;
    }

    public void adicionarVeiculo(VeiculoModel model) {
      final  Identificador id = Placa.criar(model.id());
      final  Veiculo veiculo = Veiculo.criar(id, model.tamanho(), model.modelo(),
                model.cor(), model.ano());

        gateway.registrar(veiculo);
    }


    public void atualizarVeiculo(String veiculoId, String cor) {
        Veiculo veiculo = gateway.buscarPorId(veiculoId);
        if (veiculo == null) {
            throw new RuntimeException("Cliente não existe!");
        }

        veiculo.alterarCor(cor);

        gateway.atualizar(veiculo);
    }

    public void imprimirVeiculo() {
        gateway.buscarTodos().stream().forEach(System.out::println);
    }

}
