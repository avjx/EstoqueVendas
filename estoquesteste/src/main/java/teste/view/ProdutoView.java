package teste.view;

import javax.swing.*;
import java.awt.*;
import teste.controller.ProdutoController;
import teste.model.Produto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoView {
    private JPanel panel;
    private JTextField descricaoField;
    private JTextField codigoProdutoField;
    private JTextField valorField;
    private JTextField valorPromocionalField;
    private JTextField dataInicioPromocaoField;
    private JTextField dataFimPromocaoField;
    private JCheckBox statusCheckBox;
    private JButton cadastrarButton;
    private ProdutoController produtoController;

    public ProdutoView() {
        produtoController = new ProdutoController();
        panel = new JPanel(new GridLayout(8, 2));
        
        descricaoField = new JTextField();
        codigoProdutoField = new JTextField();
        valorField = new JTextField();
        valorPromocionalField = new JTextField();
        dataInicioPromocaoField = new JTextField();
        dataFimPromocaoField = new JTextField();
        statusCheckBox = new JCheckBox("Ativo");
        cadastrarButton = new JButton("Cadastrar Produto");

        panel.add(new JLabel("Descrição:"));
        panel.add(descricaoField);
        panel.add(new JLabel("Código do Produto:"));
        panel.add(codigoProdutoField);
        panel.add(new JLabel("Valor:"));
        panel.add(valorField);
        panel.add(new JLabel("Valor Promocional:"));
        panel.add(valorPromocionalField);
        panel.add(new JLabel("Data Início Promoção (dd/MM/yyyy):"));
        panel.add(dataInicioPromocaoField);
        panel.add(new JLabel("Data Fim Promoção (dd/MM/yyyy):"));
        panel.add(dataFimPromocaoField);
        panel.add(new JLabel("Status:"));
        panel.add(statusCheckBox);
        panel.add(cadastrarButton);

        cadastrarButton.addActionListener(e -> cadastrarProduto());
    }

    public JPanel getPanel(){
        return panel;
    }

    private void cadastrarProduto(){
        Produto produto = new Produto();
        produto.setDescricao(descricaoField.getText());
        produto.setCodigoProduto(codigoProdutoField.getText());
        produto.setValor(Double.parseDouble(valorField.getText()));
        produto.setValorPromocional(Double.parseDouble(valorPromocionalField.getText()));
        try {
            produto.setDataInicioPromocao(new SimpleDateFormat("dd/MM/yyyy").parse(dataInicioPromocaoField.getText()));
            produto.setDataFimPromocao(new SimpleDateFormat("dd/MM/yyyy").parse(dataFimPromocaoField.getText()));
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(panel, "Data de promoção inválida.");
            return;
        }
        produto.setDataCadastro(new Date());
        produto.setStatus(statusCheckBox.isSelected());

        boolean sucesso = produtoController.adicionarProduto(produto);
        if (sucesso) {
            JOptionPane.showMessageDialog(panel, "Cadastro realizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(panel, "Produto com este código já está cadastrado.");
        }
    }
}
