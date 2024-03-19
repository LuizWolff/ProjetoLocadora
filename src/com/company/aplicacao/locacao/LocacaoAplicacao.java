package com.company.aplicacao.locacao;


import com.company.domain.Identificador;
import com.company.domain.cliente.Cliente;
import com.company.domain.cliente.ClienteGateway;
import com.company.domain.locacao.Locacao;
import com.company.domain.locacao.LocacaoGateway;
import com.company.domain.locacao.objetos.StatusPagamento;
import com.company.domain.locacao.objetos.StatusLocacao;
import com.company.domain.locacao.objetos.LocacaoId;
import com.company.domain.veiculo.objetos.StatusVeiculo;
import com.company.domain.veiculo.Veiculo;
import com.company.domain.veiculo.VeiculoGateway;

import java.time.LocalDate;
import java.util.UUID;

import static com.company.domain.locacao.objetos.StatusPagamento.CONFIRMADO;


public class LocacaoAplicacao {

    private final LocacaoGateway locacaoGateway;
    private final ClienteGateway clienteGateway;
    private final VeiculoGateway veiculoGateway;

    public LocacaoAplicacao(LocacaoGateway locacaoGateway, ClienteGateway clienteGateway,
                            VeiculoGateway veiculoGateway) {
        this.locacaoGateway = locacaoGateway;
        this.clienteGateway = clienteGateway;
        this.veiculoGateway = veiculoGateway;
    }

    public String alugarVeiculo(String clienteId, String veiculoId) {

        final Cliente cliente = clienteGateway.buscarPorId(clienteId);
        final Veiculo veiculo = veiculoGateway.buscarPorId(veiculoId);
        //adicionar validar se o veiculo está disponivel ou não

       if(!veiculo.isDisponivel()){
           throw new RuntimeException("Veículo está disponivel!");
       }

        //UUID = Identificador único, RandomUUID = gera um valor aleatorio
        final Identificador id = LocacaoId.criar(clienteId);

       final Locacao locacao = Locacao.criar(id, StatusLocacao.EM_ANDAMENTO, CONFIRMADO,
               StatusVeiculo.ALUGADO,
                LocalDate.now(),null, cliente, veiculo);

        if (locacao.statusLocacao == StatusLocacao.AGUARDANDO_RETIRADA) {
            throw new RuntimeException("Veículo já está disponivel para retirada!");
        }

        locacaoGateway.adicionarNovaLocacao(locacao);
        veiculo.setDisponivel(false);

        return (String) locacao.id().valor();

    }

    public void devolverVeiculo(String locacaoId) {
        Locacao locacao = locacaoGateway.buscarPorId(locacaoId);
        if (locacao == null) {
            throw new RuntimeException("Locação não existe!");
        }

        if (locacao.statusLocacao == StatusLocacao.CONCLUÍDA) {
            throw new RuntimeException("Veículo já foi devolvido!");
        }
        locacao.setStatusLocacao(StatusLocacao.CONCLUÍDA);
        locacao.alterarDataDevolucao(LocalDate.now());

        System.out.println(locacao.toString());
        locacaoGateway.atualizar(locacao);
        Veiculo veiculo = locacao.getVeiculo();
        veiculo.setDisponivel(true);
        veiculoGateway.atualizar(veiculo);
    }




    public void atualizarPagamento(String locacaoId,StatusPagamento statusPagamento){
    Locacao locacao = locacaoGateway.buscarPorId(locacaoId);
        if (locacao == null) {
        throw new RuntimeException("Locação não existe!");
    }
        locacao.alterarStatusPagamento(statusPagamento);

        locacaoGateway.atualizar(locacao);
    }

    public void imprimirLocacao() {
        locacaoGateway.buscarTodos().stream().forEach(System.out::println);
    }

}