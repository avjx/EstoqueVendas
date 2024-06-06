package teste.controller;

import teste.model.Produto;
import teste.service.ProdutoService;
import java.util.List;

public class ProdutoController {
    private ProdutoService produtoService;

    public ProdutoController() {
        produtoService = ProdutoService.getInstance();
    }

    public boolean adicionarProduto(Produto produto, int quantidadeInicial) {
        return produtoService.adicionarProduto(produto, quantidadeInicial);
    }

    public java.util.List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }
}

/*
public class ProdutoController {
    private ProdutoService produtoService;

    public ProdutoController() {
        this.produtoService = new ProdutoService();
    }

    public boolean adicionarProduto(Produto produto, int quantidadeInicial) {
        return produtoService.adicionarProduto(produto, quantidadeInicial);
    }

    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }
}
*/