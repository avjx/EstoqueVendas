package teste.service;

import java.util.ArrayList;
import java.util.List;
import teste.model.Produto;

public class ProdutoService {
    private List<Produto> produtos = new ArrayList<>();

    public boolean adicionarProduto(Produto produto){
        for(Produto p : produtos){
            if(p.getCodigoProduto().equals(produto.getCodigoProduto())){
                return false; //ja cadastrado
            }
        }
        produtos.add(produto);
        return true;
    }

    public List<Produto> listarProdutos(){
        return produtos;
    }
}
