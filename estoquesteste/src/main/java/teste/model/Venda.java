package teste.model;

import java.util.ArrayList;
import java.util.List;

public class Venda {
    private List<ItemVenda> itens;
    private double valorPago;
    private double desconto;
    private double total;
    private double totalComDesconto;
    private double troco;
    private String cpfCnpjCliente;
    private Cliente cliente;

    public Venda() {
        itens = new ArrayList<>();
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalComDesconto() {
        return totalComDesconto;
    }

    public void setTotalComDesconto(double totalComDesconto) {
        this.totalComDesconto = totalComDesconto;
    }

    public double getTroco() {
        return troco;
    }

    public void setTroco(double troco) {
        this.troco = troco;
    }

    public String getCpfCnpjCliente() {
        return cpfCnpjCliente;
    }

    public void setCpfCnpjCliente(String cpfCnpjCliente) {
        this.cpfCnpjCliente = cpfCnpjCliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
