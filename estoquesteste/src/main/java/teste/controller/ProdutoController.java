package teste.controller;

import teste.model.Produto;
import teste.service.ProdutoService;
import java.util.List;

public class ProdutoController {
    private ProdutoService produtoService;

    public ProdutoController() {
        this.produtoService = new ProdutoService();
    }

    public boolean adicionarProduto(Produto produto) {
        return produtoService.adicionarProduto(produto);
    }

    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }
}
