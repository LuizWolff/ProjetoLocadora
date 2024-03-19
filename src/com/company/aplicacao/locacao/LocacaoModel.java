//package com.company.aplicacao.locacao;
//
//import com.company.domain.locacao.Locacao;
//import com.company.domain.locacao.objetos.*;
//
//import java.time.LocalDate;
//import java.util.Objects;
//
//
//public final class LocacaoModel {
//    private final String id;
//    private final StatusPagamento statusPagamento;
//    private final LocalDate dataRetirada;
//    private final LocalDate dataDevolucao;
//
//    LocacaoModel(
//            String id,
//            StatusLocacao statusLocacao,
//            StatusPagamento statusPagamento,
//            LocalDate dataRetirada,
//            LocalDate dataDevolucao
//
//    ) {
//        this.id = id;
//        this.statusLocacao = statusLocacao;
//        this.statusPagamento = statusPagamento;
//        this.dataRetirada = dataRetirada;
//        this.dataDevolucao = dataDevolucao;
//    }
//
//    public String id() {
//        return id;
//    }
//
//    public StatusLocacao statusLocacao() {
//        return statusLocacao;
//    }
//
//    public StatusPagamento statusPagamento() {
//        return statusPagamento;
//    }
//
//    public LocalDate getDataRetirada() {
//        return this.dataRetirada;
//    }
//
//    public LocalDate getDataDevolucao() {
//        return this.dataDevolucao;
//    }
//
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == this) return true;
//        if (obj == null || obj.getClass() != this.getClass()) return false;
//        var that = (LocacaoModel) obj;
//        return Objects.equals(this.id, that.id) &&
//                Objects.equals(this.statusLocacao, that.statusLocacao) &&
//                Objects.equals(this.statusPagamento, that.statusPagamento) &&
//                Objects.equals(this.dataRetirada, that.dataRetirada) &&
//                Objects.equals(this.dataDevolucao, that.dataDevolucao);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, statusLocacao, statusPagamento, dataRetirada, dataDevolucao);
//    }
//
//    @Override
//    public String toString() {
//        return "LocacaoModel[" +
//                "id=" + id + ", " +
//                "statusLocacao=" + statusLocacao + ", " +
//                "statusPagamento=" + statusPagamento + ", " +
//                "dataRetirada=" + dataRetirada + ", " +
//                "dataDevolucao=" + dataDevolucao + ']';
//    }
//
//}