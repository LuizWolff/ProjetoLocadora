package com.company.aplicacao.cliente;

import com.company.domain.Identificador;
import com.company.domain.cliente.Cidade;
import com.company.domain.cliente.Cliente;
import com.company.domain.cliente.ClienteGateway;
import com.company.domain.cliente.Endereco;
import com.company.domain.cliente.objetos.CEP;
import com.company.domain.cliente.objetos.CNPJ;
import com.company.domain.cliente.objetos.CPF;
import com.company.domain.cliente.objetos.Tipo;

public class ClienteAplicacao {

    private final ClienteGateway gateway;

    public ClienteAplicacao(ClienteGateway gateway) {
        this.gateway = gateway;
    }

    public void adicionarCliente(ClienteModel model) {

        final Identificador idValido = model.tipo() == Tipo.FISICA ? CPF.criar(model.id()) : CNPJ.criar(model.id());
        final CEP cep = CEP.criar(model.cep());
        final Cidade cidade = Cidade.criar(model.cidade(), model.estado());
        final Endereco endereco = Endereco.criar(cep, model.logradouro(), model.bairro(), cidade);

        final Cliente cliente = Cliente.criar(idValido, model.tipo(), model.nome(), model.nome(), endereco);

        gateway.registrar(cliente);
    }

    public void atualizarCliente(String clienteId, String nome, String email) {
        Cliente cliente = gateway.buscarPorId(clienteId);
        if (cliente == null) {
            throw new RuntimeException("Cliente não existe!");
        }

        cliente.alterarNome(nome);
        cliente.alterarEmail(email);

        gateway.atualizar(cliente);
    }

    public void atualizarEndereco(ClienteModel model){
        final CEP cep = CEP.criar(model.cep());
        final Cidade cidade = Cidade.criar(model.cidade(), model.estado());
        final Endereco endereco = Endereco.criar(cep, model.logradouro(), model.bairro(), cidade);

        final Cliente cliente = gateway.buscarPorId(model.id());
        if (cliente == null){
            throw new RuntimeException("Cliente não existe!");
        }

        cliente.atualizarEndereco(endereco);

        gateway.atualizar(cliente);
    }

    public void imprimirClientes() {
        gateway.buscarTodos().stream().forEach(System.out::println);
    }

}

