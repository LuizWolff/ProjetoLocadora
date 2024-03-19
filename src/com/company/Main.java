package com.company;

import com.company.aplicacao.cliente.ClienteAplicacao;
import com.company.aplicacao.cliente.ClienteModel;
import com.company.aplicacao.locacao.LocacaoAplicacao;
import com.company.aplicacao.veiculo.VeiculoAplicacao;
import com.company.aplicacao.veiculo.VeiculoModel;
import com.company.domain.cliente.Cidade;
import com.company.domain.cliente.ClienteGateway;
import com.company.domain.cliente.Endereco;
import com.company.domain.cliente.objetos.CEP;
import com.company.domain.cliente.objetos.Tipo;
import com.company.domain.locacao.LocacaoGateway;
import com.company.domain.veiculo.Veiculo;
import com.company.domain.veiculo.VeiculoGateway;
import com.company.domain.veiculo.objetos.Tamanho;
import com.company.infraestrutura.cliente.ClienteListaGateway;
import com.company.infraestrutura.locacao.LocacaoListaGateway;
import com.company.infraestrutura.veiculo.VeiculoListaGateway;

public class Main {

    public static void main(String[] args) {
        ClienteGateway cG = new ClienteListaGateway();
        ClienteAplicacao cA = new ClienteAplicacao(cG);

        VeiculoGateway vG = new VeiculoListaGateway();
        VeiculoAplicacao vA = new VeiculoAplicacao(vG);

        LocacaoGateway lG = new LocacaoListaGateway();
        LocacaoAplicacao lA = new LocacaoAplicacao(lG,cG,vG);


        ClienteModel cliente = new ClienteModel("12345678911", "Luiz", "luiz@email",
                "Estrada de Itapecerica","Jardim Gêrmania", "05835004", "São Paulo",
                "SP",Tipo.FISICA);

        VeiculoModel veiculo = new VeiculoModel("1234567", Tamanho.SUV,"FordKa","Branco",
                2000);

        vA.adicionarVeiculo(veiculo);
        cA.adicionarCliente(cliente);

        cA.imprimirClientes();

       vA.imprimirVeiculo();

        String locaoId = lA.alugarVeiculo("12345678911","1234567");

        lA.imprimirLocacao();

//
        lA.devolverVeiculo(locaoId);


    }
}
