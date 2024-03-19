package com.company.infraestrutura.cliente;

import com.company.domain.cliente.Cliente;
import com.company.domain.cliente.ClienteGateway;

import java.util.ArrayList;
import java.util.List;

public class ClienteListaGateway implements ClienteGateway {

    List<Cliente> clientes = new ArrayList<>();

    @Override
    public void registrar(Cliente cliente){
        clientes.add(cliente);
    }

    @Override
    public void atualizar(Cliente cliente){
        clientes.remove(cliente);
        clientes.add(cliente);
    }


    @Override
    public Cliente buscarPorId(String id){
        for (Cliente c: clientes) {
            if (c.id().toString().equals(id)){
                return c;
            }
        }
        throw new RuntimeException("Cliente não encontrado!");
    }

    @Override
    public List<Cliente> buscarTodos(){
        return clientes;
    }
}
