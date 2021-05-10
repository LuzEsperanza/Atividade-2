/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.web;

import br.edu.ifpb.dac.venda.entidades.Cliente;
import br.edu.ifpb.dac.venda.entidades.Produto;
import java.math.BigDecimal;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named
public class ProdutoControle {
    private Produto produto;
    private Produtos produtos;
    private double valor;

    public ProdutoControle() {
      this.produto = new Produto();
      this.produtos = new Produtos();
    }
    public String salvar(){
        produto.setValor(BigDecimal.valueOf(valor));
        produtos.add(produto);
        return null;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }

 
    
}
