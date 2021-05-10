/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.vendas.restfull;


import br.edu.ifpb.dac.venda.entidades.Cliente;
import br.edu.ifpb.dac.vendas.service.ClienteService;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


@RequestScoped
@Named
public class Clientes {
    @Inject
    private ClienteService cs; 
    private Cliente cliente;

    public Clientes() {
        this.cliente = new Cliente();
    }
    
    public String salve(){
        cs.save(cliente);
        return null;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}

