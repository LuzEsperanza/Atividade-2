/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.web;

import br.edu.ifpb.dac.venda.entidades.Cliente;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named
public class ClienteControle {
    private Cliente cliente;
    private Clientes clientes;

    public ClienteControle() {
        this.cliente = new Cliente();
        clientes= new Clientes();
    }
    public String salvar(){
        clientes.add(cliente);
        return null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

 
    
}
