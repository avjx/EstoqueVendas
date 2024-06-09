package teste.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import teste.controller.VendaController;
import teste.controller.ProdutoController;
import teste.model.Venda;
import teste.model.Produto;
import teste.model.ItemVenda;

public class VendaView {
    private JPanel panel;
    private JTextField txtCodigoProduto;
    private JTextField txtQuantidade;
    private JTextField txtValorPago;
    private JTextField txtDesconto;
    private JTextArea areaProdutos;
    private JButton btnAdicionarProduto;
    private JButton btnCalcularTroco;
    private JButton btnPagamentoEfetuado;
    private JButton btnPagamentoCancelado;
    private JLabel lblTotal;
    private JLabel lblTroco;
    private VendaController vendaController;
    private ProdutoController produtoController;
    private Venda venda;

    public VendaView() {
        vendaController = new VendaController();
        produtoController = new ProdutoController();
        venda = new Venda();

        panel = new JPanel(new GridLayout(11, 2));

        txtCodigoProduto = new JTextField();
        txtQuantidade = new JTextField();
        txtValorPago = new JTextField();
        txtDesconto = new JTextField();
        areaProdutos = new JTextArea(5, 20);
        btnAdicionarProduto = new JButton("Adicionar Produto");
        btnCalcularTroco = new JButton("Calcular Troco");
        btnPagamentoEfetuado = new JButton("Pagamento Efetuado");
        btnPagamentoCancelado = new JButton("Pagamento Cancelado");
        lblTotal = new JLabel("Total: ");
        lblTroco = new JLabel("Troco: ");

        panel.add(new JLabel("Código do Produto:"));
        panel.add(txtCodigoProduto);
        panel.add(new JLabel("Quantidade:"));
        panel.add(txtQuantidade);
        panel.add(new JLabel("Valor Pago:"));
        panel.add(txtValorPago);
        panel.add(new JLabel("Desconto (%):"));
        panel.add(txtDesconto);
        panel.add(btnAdicionarProduto);
        panel.add(new JLabel("Produtos:"));
        panel.add(new JScrollPane(areaProdutos));
        panel.add(lblTotal);
        panel.add(lblTroco);
        panel.add(btnCalcularTroco);
        panel.add(btnPagamentoEfetuado);
        panel.add(btnPagamentoCancelado);

        btnAdicionarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarProduto();
            }
        });

        btnCalcularTroco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularTroco();
            }
        });

        btnPagamentoEfetuado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarVenda();
            }
        });

        btnPagamentoCancelado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelarVenda();
            }
        });
    }

    private void adicionarProduto() {
        String codigoProduto = txtCodigoProduto.getText();
        int quantidade = Integer.parseInt(txtQuantidade.getText());

        Produto produto = produtoController.buscarProdutoPorCodigo(codigoProduto);
        if (produto != null) {
            ItemVenda itemVenda = new ItemVenda(produto, quantidade);
            venda.getItens().add(itemVenda);
            areaProdutos.append(produto.getDescricao() + " - Quantidade: " + quantidade + "\n");
        } else {
            JOptionPane.showMessageDialog(null, "Produto não encontrado.");
        }
    }

    private void calcularTroco() {
        double valorPago = Double.parseDouble(txtValorPago.getText());
        double desconto = Double.parseDouble(txtDesconto.getText());

        venda.setValorPago(valorPago);
        venda.setDesconto(desconto);

        vendaController.calcularTotais(venda);
        vendaController.calcularTroco(venda);

        lblTotal.setText("Total: " + venda.getTotalComDesconto());
        lblTroco.setText("Troco: " + venda.getTroco());
    }

    private void registrarVenda() {
        if (vendaController.registrarVenda(venda)) {
            JOptionPane.showMessageDialog(null, "Venda registrada com sucesso!");
            limparTela();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao registrar a venda. Verifique o estoque.");
        }
    }

    private void cancelarVenda() {
        JOptionPane.showMessageDialog(null, "Venda cancelada.");
        limparTela();
    }

    private void limparTela() {
        txtCodigoProduto.setText("");
        txtQuantidade.setText("");
        txtValorPago.setText("");
        txtDesconto.setText("");
        areaProdutos.setText("");
        lblTotal.setText("Total: ");
        lblTroco.setText("Troco: ");
        venda = new Venda();
    }

    public JPanel getPanel() {
        return panel;
    }
}
