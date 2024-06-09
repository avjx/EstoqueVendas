package teste.view;

import javax.swing.*;
import java.awt.*;
import teste.controller.EstoqueController;
import teste.model.Estoque;
import java.util.List;


public class EstoqueView {
    private JPanel panel;
    private JTextArea estoqueArea;
    private EstoqueController estoqueController;

    public EstoqueView() {
        estoqueController = new EstoqueController();
        panel = new JPanel(new BorderLayout());

        estoqueArea = new JTextArea();
        estoqueArea.setEditable(false);
        panel.add(new JScrollPane(estoqueArea), BorderLayout.CENTER);

        JButton listarEstoqueButton = new JButton("Listar Estoque");
        listarEstoqueButton.addActionListener(e -> listarEstoque());
        panel.add(listarEstoqueButton, BorderLayout.SOUTH);
    }

    public JPanel getPanel() {
        return panel;
    }

    private void listarEstoque() {
        System.out.println("Listar Estoque Button Clicked");
        List<Estoque> estoques = estoqueController.listarEstoques();
        StringBuilder sb = new StringBuilder();
        for (Estoque e : estoques) {
            sb.append("Produto: ").append(e.getProduto().getDescricao()).append("\n")
              .append("Valor: ").append(e.getValorProduto()).append("\n")
              .append("Data Cadastro: ").append(e.getDataCadastro()).append("\n")
              .append("Quantidade Vendida: ").append(e.getQuantidadeVendida()).append("\n")
              .append("Quantidade em Estoque: ").append(e.getQuantidadeEmEstoque()).append("\n")
              .append("Status: ").append(e.isStatus() ? "Ativo" : "Inativo").append("\n\n");
        }
        System.out.println("Estoque: " + sb.toString());
        estoqueArea.setText(sb.toString());
    }
}