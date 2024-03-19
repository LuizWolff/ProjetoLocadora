package com.company.domain.veiculo;

import com.company.domain.Identificador;
import com.company.domain.veiculo.objetos.Tamanho;

public class Veiculo {

    private final Identificador id;
    private final Tamanho tamanho;
    private final String modelo;
    private String cor;
    private final Integer ano;
    private boolean disponivel = true;

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    private Veiculo(Identificador id, Tamanho tamanho, String modelo, String cor, int ano) {
        this.id = id;
        this.tamanho = tamanho;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        validar();
    }

    public static Veiculo criar(
            Identificador id,
            Tamanho tamanho,
            String modelo,
            String cor,
            Integer ano
    ){
        return new Veiculo(id, tamanho, modelo, cor, ano);
    }

    public void alterarCor (String novaCor){
        this.cor = novaCor;
    }

    public Identificador id() {
        return id;
    }

    public Tamanho tamanho() {
        return tamanho;
    }

    public String modelo() {
        return modelo;
    }

    public String cor() {
        return cor;
    }
    public Integer ano(){
        return Integer.valueOf(cor);
    }

    private void validar() {
        if (id == null) {
            throw new RuntimeException("ID na?o pode ser nulo");
        }

        if (modelo == null || modelo.trim().isEmpty()) {
            throw new RuntimeException("Modelo na?o pode ser nulo");
        }

        if (cor == null || cor.trim().isEmpty()) {
            throw new RuntimeException("Cor na?o pode ser nulo");
        }
        if (ano == null) {
            throw new RuntimeException("Ano na?o pode ser nulo");
        }
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", modelo=" + modelo +
                ", cor='" + cor + '\'' +
                ", tamanho='" + tamanho + '\'' +
                ", ano=" + ano +
                '}';
    }
}
