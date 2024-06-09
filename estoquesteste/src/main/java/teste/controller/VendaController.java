package teste.controller;

import java.util.List;
import teste.model.Venda;
import teste.service.VendaService;
import teste.model.Produto;
import teste.model.ItemVenda;
import java.util.ArrayList;

public class VendaController {
    private VendaService vendaService;

    public VendaController() {
        this.vendaService = new VendaService();
    }

    public boolean registrarVenda(Venda venda) {
        calcularTotais(venda);
        calcularTroco(venda);
        return vendaService.registrarVenda(venda);
    }

    public List<Venda> listarVendas() {
        return vendaService.listarVendas();
    }

    public void calcularTotais(Venda venda) {
        double totalSemDesconto = 0.0;
        double totalComDesconto = 0.0;

        for (ItemVenda item : venda.getItens()) {
            Produto produto = item.getProduto();
            int quantidade = item.getQuantidade();
            totalSemDesconto += produto.getValor() * quantidade;
            totalComDesconto += produto.getValorPromocional() * quantidade;
        }

        venda.setTotalSemDesconto(totalSemDesconto);
        venda.setTotalComDesconto(totalComDesconto - (totalComDesconto * venda.getDesconto() / 100));
    }

    public void calcularTroco(Venda venda) {
        double troco = venda.getValorPago() - venda.getTotalComDesconto();
        venda.setTroco(troco);
    }
}
