package teste.service;

import java.util.ArrayList;
import java.util.List;
import teste.model.Produto;
import teste.model.Estoque;

public class ProdutoService {
    private List<Produto> produtos = new ArrayList<>();
    private EstoqueService estoqueService = EstoqueService.getInstance();

    private static ProdutoService instance;

    private ProdutoService() {}

    public static ProdutoService getInstance() {
        if (instance == null) {
            instance = new ProdutoService();
        }
        return instance;
    }

    public boolean adicionarProduto(Produto produto, int quantidadeInicial) {
        for (Produto p : produtos) {
            if (p.getCodigoProduto().equals(produto.getCodigoProduto())) {
                return false; // Produto já cadastrado
            }
        }
        produtos.add(produto);

        // Adicionando ao estoque
        Estoque estoque = new Estoque();
        estoque.setProduto(produto);
        estoque.setValorProduto(produto.getValor());
        estoque.setDataCadastro(produto.getDataCadastro());
        estoque.setQuantidadeEmEstoque(quantidadeInicial);
        estoque.setQuantidadeVendida(0);
        estoque.setStatus(produto.getStatus());

        boolean adicionado = estoqueService.adicionarEstoque(estoque);
        System.out.println("Estoque adicionado: " + adicionado);
        return true;
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }
}