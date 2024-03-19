package com.company.infraestrutura.locacao;

import com.company.domain.locacao.Locacao;
import com.company.domain.locacao.LocacaoGateway;

import java.util.ArrayList;
import java.util.List;

public class LocacaoListaGateway implements LocacaoGateway {

    List<Locacao> locacao = new ArrayList<>();

    @Override
    public void adicionarNovaLocacao(Locacao locacao) {
            this.locacao.add(locacao);
    }

    @Override
    public void atualizar(Locacao locacao) {

    }

    @Override
    public Locacao buscarPorId(String id) {
        for (Locacao c: locacao) {
            if (c.id().toString().equals(id)){
                return c;
            }
        }
        throw new RuntimeException("Cliente não encontrado!");
    }


    @Override
    public List<Locacao> buscarTodos() {
        return locacao;
    }
}
