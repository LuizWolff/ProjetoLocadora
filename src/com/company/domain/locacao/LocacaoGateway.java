package com.company.domain.locacao;

import com.company.domain.cliente.Cliente;

import java.util.List;

public interface LocacaoGateway {


        void adicionarNovaLocacao(Locacao locacao);

        void atualizar(Locacao locacao);

        Locacao buscarPorId(String id);

        List<Locacao> buscarTodos();
//        List<Locacao> buscarData();

    }
