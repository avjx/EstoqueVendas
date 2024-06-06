package teste.service;

import java.util.ArrayList;
import java.util.List;
import teste.model.Estoque;
import teste.model.Produto;

/* 
public class EstoqueService {
    private List<Estoque> estoques = new ArrayList<>();

    public boolean adicionarEstoque(Estoque estoque){
        for(Estoque e : estoques){
            if(e.getProduto().getCodigoProduto().equals(estoque.getProduto().getCodigoProduto())){
                return false; //produto ja no estoque
            }
        }
        estoques.add(estoque);
        return true;
    }

    public List<Estoque> listarEstoques(){
        return estoques;
    }

    public boolean atualizarQuantidadeVendida(String codigoProduto, int quantidadeVendida){
        for(Estoque e : estoques){
            if(e.getProduto().getCodigoProduto().equals(codigoProduto)){
                e.setQuantidadeVendida(e.getQuantidadeVendida() + quantidadeVendida);
                e.setQuantidadeEmEstoque(e.getQuantidadeEmEstoque() - quantidadeVendida);
                return true; // operação de atualização funconou
            }
        }
        return false; //produto nao encontrado 
    }
}
*/

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
                e.setQuantidadeVendida(e.getQuantidadeVendida() + quantidadeVendida);
                e.setQuantidadeEmEstoque(e.getQuantidadeEmEstoque() - quantidadeVendida);
                return true;
            }
        }
        return false;
    }
}
