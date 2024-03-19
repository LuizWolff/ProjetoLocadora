package com.company.domain.locacao;

import com.company.domain.Identificador;
import com.company.domain.cliente.Cliente;
import com.company.domain.locacao.objetos.StatusLocacao;
import com.company.domain.locacao.objetos.StatusPagamento;
import com.company.domain.veiculo.Veiculo;
import com.company.domain.veiculo.objetos.StatusVeiculo;

import java.time.LocalDate;

public class Locacao {

    private final Identificador id;
    public StatusLocacao statusLocacao;
    public StatusVeiculo statusVeiculo;
    private StatusPagamento statusPagamento;
    private LocalDate dataRetirada;
    private LocalDate dataDevolucao;
    private Cliente cliente;
    private Veiculo veiculo;

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Locacao(Identificador id, StatusLocacao statusLocacao,StatusVeiculo
            statusVeiculo, StatusPagamento statusPagamento,
                   LocalDate dataRetirada, LocalDate dataDevolucao, Cliente cliente,
                   Veiculo veiculo) {
        this.id = id;
        this.statusLocacao = statusLocacao;
        this.statusVeiculo = statusVeiculo;
        this.statusPagamento = statusPagamento;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
        this.cliente = cliente;
        this.veiculo = veiculo;
    }

    public static Locacao criar(
            Identificador id,
            StatusLocacao statusLocacao,
            StatusPagamento statusPagamento,
            StatusVeiculo statusVeiculo,
            LocalDate dataRetirada,
            LocalDate dataDevolucao,
            Cliente cliente,
            Veiculo veiculo
    ){
        return new Locacao(id, statusLocacao,
                statusVeiculo, statusPagamento, dataRetirada,dataDevolucao, cliente, veiculo);
    }


    public void alterarStatusLocacao (StatusLocacao alterarStatusLocacao){
        this.statusLocacao = statusLocacao;
    }

    public void alterarStatusPagamento (StatusPagamento alterarStatusPagamento){
        this.statusPagamento = statusPagamento;
    }

    public void alterarDataRetirada(LocalDate alterarDataRetirada){
        this.dataRetirada = dataRetirada;
    }

    public void alterarDataDevolucao(LocalDate alterarDataDevolucao){
        this.dataDevolucao = LocalDate.now();
    }

    public Locacao(Identificador id, StatusLocacao statusLocacao, LocalDate dataRetirada, LocalDate dataDevolucao) {
        this.id = id;
        this.statusLocacao = statusLocacao;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
    }

    public Identificador id() {
        return id;
    }

    public StatusLocacao statusLocacao() {
        return statusLocacao;
    }

    public void setStatusLocacao(StatusLocacao statusLocacao){
        this.statusLocacao = statusLocacao;
    }

    public StatusPagamento statusPagamento() {
        return statusPagamento;
    }

    private void validar() {
        if (id == null) {
            throw new RuntimeException("ID não pode ser nulo");
        }

        if (statusPagamento == null) {
            throw new RuntimeException("Status Pagamento não pode ser nulo");
        }

        if (statusLocacao == null){
            throw new RuntimeException("Status Locação não pode ser nulo");
        }
        if (dataRetirada == null) {
            throw new RuntimeException("Data Devolução não pode ser nulo");
        }
        if (dataDevolucao == null) {
            throw new RuntimeException("Data Devolução não pode ser nulo");
        }
    }

    @Override
    public String toString() {
        return "Locação{" +
                "id=" + id +
                ", Status pagamento=" + statusPagamento+
                ", Status locação='" + statusLocacao + '\'' +
                ", Data retirada='" + dataRetirada + '\'' +
                ", Data devolução=" + dataDevolucao +
                '}';
    }

}
