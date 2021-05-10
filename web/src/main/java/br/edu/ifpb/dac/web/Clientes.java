/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.web;

import br.edu.ifpb.dac.venda.entidades.Cliente;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author jose
 */
public class Clientes {

    private WebTarget baseTarget;

    public Clientes() {
        Client client = ClientBuilder.newClient();
        baseTarget = client.target("http://localhost:8080/Vendas-cliente/api/cliente");
    }

    public List<Cliente> findAll() {
        Invocation.Builder invocationBuilder = baseTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();

        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new RuntimeException("Erro listando contatos");
        }

        return response.readEntity(new GenericType<List<Cliente>>() {
        });
    }

   

    public Cliente findById(int id) {
        WebTarget searchTarget = baseTarget.path("/" + id);
        Invocation.Builder invocationBuilder = searchTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();

        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new RuntimeException("Erro recuperando contato");
        }

        return response.readEntity(Cliente.class);
    }

    public Cliente add(Cliente c) {
        Invocation.Builder invocationBuilder = baseTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(c, MediaType.APPLICATION_JSON));

        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new RuntimeException("Erro criando contato");
        }
        return response.readEntity(Cliente.class);
    }

   

}
