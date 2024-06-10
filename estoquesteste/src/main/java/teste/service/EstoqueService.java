package teste.service;

import java.util.ArrayList;
import java.util.List;
import teste.model.Estoque;

public class EstoqueService {
    private List<Estoque> estoques = new ArrayList<>();

    private static EstoqueService instance;

    private EstoqueService() {}

    public static EstoqueService getInstance() {
        if (instance == null) {
            instance = new EstoqueService();
        }
        return instance;
    }

    public boolean adicionarEstoque(Estoque estoque) {
        System.out.println("Adicionando ao estoque: " + estoque.getProduto().getDescricao());
        return estoques.add(estoque);
    }

    public List<Estoque> listarEstoques() {
        System.out.println("Listando estoques. Total de estoques: " + estoques.size());
        for (Estoque e : estoques) {
            System.out.println("Produto no estoque: " + e.getProduto().getDescricao());
        }
        return estoques;
    }

    public boolean atualizarQuantidadeVendida(String codigoProduto, int quantidadeVendida) {
        for (Estoque e : estoques) {
            if (e.getProduto().getCodigoProduto().equals(codigoProduto)) {
                System.out.println("Atualizando produto: "+e.getProduto().getDescricao()+
                                   " | Qtd atual: "+ e.getQuantidadeEmEstoque()+
                                   " | Qtd vendida: "+ e.getQuantidadeVendida());
                System.out.println("Qtd a atualizar: "+quantidadeVendida);

                e.setQuantidadeVendida(e.getQuantidadeVendida() + quantidadeVendida);
                e.setQuantidadeEmEstoque(e.getQuantidadeEmEstoque() - quantidadeVendida);
                System.out.println("Qtd atualizada: "+e.getQuantidadeEmEstoque()+
                                   " | Qtd vendida: "+e.getQuantidadeVendida());
                return true;
            }
        }
        return false;
    }
}