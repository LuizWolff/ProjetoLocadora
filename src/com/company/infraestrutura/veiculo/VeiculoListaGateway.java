package com.company.infraestrutura.veiculo;

import com.company.domain.veiculo.Veiculo;
import com.company.domain.veiculo.VeiculoGateway;

import java.util.ArrayList;
import java.util.List;

public class VeiculoListaGateway implements VeiculoGateway {

    List<Veiculo> veiculos = new ArrayList<>();

    @Override
    public void registrar(Veiculo veiculo){
        veiculos.add(veiculo);
    }

    @Override
    public void atualizar(Veiculo veiculo){
        veiculos.remove(veiculo);
        veiculos.add(veiculo);
    }


    @Override
    public Veiculo buscarPorId(String id){
        for (Veiculo c: veiculos) {
            if (c.id().toString().equals(id)){
                return c;
            }
        }
        throw new RuntimeException("Veiculo não encontrado!");
    }

    @Override
    public List<Veiculo> buscarTodos(){
        return veiculos;
    }
}
