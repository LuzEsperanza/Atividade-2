/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.vendas.service;
import br.edu.ifpb.dac.venda.entidades.Cliente;
import br.edu.ifpb.dac.venda.entidades.Produto;
import br.edu.ifpb.dac.vendas.repository.CliemteRepositoryImpl;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ProdutoService {
    @EJB
    private ProdutoService repository;

    public void save(Produto produto) {
        repository.save(produto);
    }

    public Produto find(int id) {
        return repository.find(id);
    }
       

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public void remove(int id) {
        repository.remove(id);
    }
    
}
