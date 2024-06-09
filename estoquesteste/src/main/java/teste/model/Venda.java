package teste.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda {
    private Date dataVenda;
    private List<ItemVenda> itens;
    private double valorPago;
    private double troco;
    private double totalSemDesconto;
    private double totalComDesconto;
    private double desconto;

    public Venda() {
        this.itens = new ArrayList<>();
    }
    

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public double getTroco() {
        return troco;
    }

    public void setTroco(double troco) {
        this.troco = troco;
    }

    public double getTotalSemDesconto() {
        return totalSemDesconto;
    }

    public void setTotalSemDesconto(double totalSemDesconto) {
        this.totalSemDesconto = totalSemDesconto;
    }

    public double getTotalComDesconto() {
        return totalComDesconto;
    }

    public void setTotalComDesconto(double totalComDesconto) {
        this.totalComDesconto = totalComDesconto;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
}
