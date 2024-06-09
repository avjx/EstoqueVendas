package teste.service;

import java.util.ArrayList;
import java.util.List;
import teste.model.Produto;
import teste.model.Venda;
import teste.model.Estoque;
import teste.model.ItemVenda;

public class VendaService {
    private List<Venda> vendas = new ArrayList<>();
    private EstoqueService estoqueService = EstoqueService.getInstance();

    public boolean registrarVenda(Venda venda) {
        // Verificar se há estoque suficiente para cada item
        for (ItemVenda item : venda.getItens()) {
            Produto produto = item.getProduto();
            int quantidadeVendida = item.getQuantidade();
            Estoque estoque = encontrarEstoquePorProduto(produto);

            if (estoque == null || estoque.getQuantidadeEmEstoque() < quantidadeVendida) {
                return false; // Estoque insuficiente para algum produto
            }
        }

        // Atualizar o estoque
        for (ItemVenda item : venda.getItens()) {
            Produto produto = item.getProduto();
            int quantidadeVendida = item.getQuantidade();
            estoqueService.atualizarQuantidadeVendida(produto.getCodigoProduto(), quantidadeVendida);
        }

        vendas.add(venda);
        return true;
    }

    public List<Venda> listarVendas() {
        return vendas;
    }

    private Estoque encontrarEstoquePorProduto(Produto produto) {
        for (Estoque estoque : estoqueService.listarEstoques()) {
            if (estoque.getProduto().equals(produto)) {
                return estoque;
            }
        }
        return null;
    }
}
