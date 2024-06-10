package teste.controller;

import teste.model.Venda;
import teste.model.Cliente;
import teste.model.ItemVenda;
import teste.service.VendaService;
import teste.service.EstoqueService;
import teste.service.ClienteService;

public class VendaController {
    private VendaService vendaService;
    private EstoqueService estoqueService;
    private ClienteService clienteService;

    public VendaController() {
        vendaService = new VendaService();
        estoqueService = EstoqueService.getInstance();
    }

    public boolean registrarVenda(Venda venda) {
        boolean vendaRegistrada = vendaService.registrarVenda(venda);
        if (vendaRegistrada) {
            // for (ItemVenda item : venda.getItens()) {
            //     estoqueService.atualizarQuantidadeVendida(item.getProduto().getCodigoProduto(), item.getQuantidade());
            // }
        }
        return vendaRegistrada;
    }

    public void calcularTotais(Venda venda) {
        double total = 0.0;
        for (ItemVenda item : venda.getItens()) {
            total += item.getProduto().getValor() * item.getQuantidade();
        }
        double desconto = total * (venda.getDesconto() / 100);
        venda.setTotal(total);
        venda.setTotalComDesconto(total - desconto);
    }

    public void calcularTroco(Venda venda) {
        double troco = venda.getValorPago() - venda.getTotalComDesconto();
        venda.setTroco(troco);
    }
}
