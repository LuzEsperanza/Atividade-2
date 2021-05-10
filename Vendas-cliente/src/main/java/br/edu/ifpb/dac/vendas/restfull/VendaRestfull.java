/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.vendas.restfull;

import br.edu.ifpb.dac.venda.entidades.Cliente;
import br.edu.ifpb.dac.venda.entidades.Produto;
import br.edu.ifpb.dac.venda.entidades.Venda;
import br.edu.ifpb.dac.vendas.service.VendaService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;

@Path("venda")
@Produces({MediaType.APPLICATION_JSON})
@Stateful
public class VendaRestfull implements Serializable {

    @Inject
    private VendaService service;
    private List<Produto> carrinho = new ArrayList<>();

    @Path("/finalizar")
    @GET
    public Response finalizar() {

        Venda v = new Venda();
        v.setProdutos(carrinho);
        v.setTotal(soma());
        service.save(v);
        return Response.ok()
                //              
                .entity(v)
                .build();

    }

    @PUT
    @Path("{id}")
    public Response adicionarAoCarrinho(
            @PathParam("id") int id,
            Produto p) {

        this.carrinho.add(p);
        return Response.ok()
                .entity(p)
                .build();
    }

    @DELETE
    @Path("{id}")
    public Response removerDoCarrinho(@PathParam("id") int id) {
        for (Produto produto : carrinho) {
            if (produto.getId() == id) {
                return Response.ok() // 200

                        .entity(carrinho.remove(produto))
                        .build();
            }

        }
        return Response.ok() // 200

                .entity(new Produto())
                .build();

    }

    private double soma() {
        double total = 0;
        for (Produto produto : carrinho) {
            total += produto.getValor().doubleValue();
        }
        return total;
    }
}
