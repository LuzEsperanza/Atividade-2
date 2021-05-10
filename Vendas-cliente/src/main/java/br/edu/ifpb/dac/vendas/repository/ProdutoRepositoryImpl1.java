/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.vendas.repository;


import br.edu.ifpb.dac.venda.entidades.Cliente;
import br.edu.ifpb.dac.venda.entidades.Produto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class ProdutoRepositoryImpl1  {

    @PersistenceContext(unitName = "br.edu.ifpb.dac_Vendas-cliente_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public void save(Produto produto) {
        em.merge(produto);
    }

    public Produto find(int id) {
        return em.find(Produto.class, id);
    }

    public List<Produto> findAll() {
        return em.createQuery("select p from Produto p ", Produto.class).getResultList();

    }

    public void remove(int id) {
        em.remove(find(id));
    }

}
