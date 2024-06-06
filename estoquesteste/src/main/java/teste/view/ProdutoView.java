package teste.view;

import javax.swing.*;
import java.awt.*;
import teste.controller.ProdutoController;
import teste.model.Produto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProdutoView {
    private JPanel panel;
    private JTextField descricaoField, codigoProdutoField, valorField, valorPromocionalField, dataInicialPromocaoField, dataFinalPromocaoField;
    private JSpinner quantidadeInicialSpinner;
    private ProdutoController produtoController;
    private SimpleDateFormat dateFormat;

    public ProdutoView() {
        produtoController = new ProdutoController();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        panel = new JPanel(new GridLayout(0, 2));
        
        panel.add(new JLabel("Descrição:"));
        descricaoField = new JTextField();
        panel.add(descricaoField);

        panel.add(new JLabel("Código Produto:"));
        codigoProdutoField = new JTextField();
        panel.add(codigoProdutoField);

        panel.add(new JLabel("Valor:"));
        valorField = new JTextField();
        panel.add(valorField);

        panel.add(new JLabel("Valor Promocional:"));
        valorPromocionalField = new JTextField();
        panel.add(valorPromocionalField);

        panel.add(new JLabel("Data Inicial da Promoção (dd/MM/yyyy):"));
        dataInicialPromocaoField = new JTextField();
        panel.add(dataInicialPromocaoField);

        panel.add(new JLabel("Data Final da Promoção (dd/MM/yyyy):"));
        dataFinalPromocaoField = new JTextField();
        panel.add(dataFinalPromocaoField);

        panel.add(new JLabel("Quantidade Inicial:"));
        quantidadeInicialSpinner = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
        panel.add(quantidadeInicialSpinner);

        JButton adicionarButton = new JButton("Adicionar Produto");
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarProduto();
            }
        });
        panel.add(adicionarButton);
    }

    public JPanel getPanel() {
        return panel;
    }

    private void adicionarProduto() {
        String descricao = descricaoField.getText();
        String codigoProduto = codigoProdutoField.getText();
        double valor = Double.parseDouble(valorField.getText());
        double valorPromocional = Double.parseDouble(valorPromocionalField.getText());
        int quantidadeInicial = (Integer) quantidadeInicialSpinner.getValue();

        Date dataInicialPromocao = null;
        Date dataFinalPromocao = null;

        try {
            dataInicialPromocao = dateFormat.parse(dataInicialPromocaoField.getText());
            dataFinalPromocao = dateFormat.parse(dataFinalPromocaoField.getText());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(panel, "Formato de data inválido. Use dd/MM/yyyy.");
            return;
        }

        Produto produto = new Produto();
        produto.setDescricao(descricao);
        produto.setCodigoProduto(codigoProduto);
        produto.setValor(valor);
        produto.setValorPromocional(valorPromocional);
        produto.setDataCadastro(new java.util.Date());
        produto.setDataInicialPromocao(dataInicialPromocao);
        produto.setDataFinalPromocao(dataFinalPromocao);
        produto.setStatus(true);
        
        boolean adicionado = produtoController.adicionarProduto(produto, quantidadeInicial);
        System.out.println("Produto adicionado: " + adicionado);
        
        if(adicionado == true){
            JOptionPane.showMessageDialog(panel, "Cadastro realizado com sucesso!");
            
            System.out.println("Dados do produto:");
            System.out.println("Descrição: " + descricao);
            System.out.println("Código Produto: " + codigoProduto);
            System.out.println("Valor: " + valor);
            System.out.println("Valor Promocional: " + valorPromocional);
            System.out.println("Quantidade Inicial: " + quantidadeInicial);

        }else{
            JOptionPane.showMessageDialog(panel, "Já existe um produto com este codigo!");
        }
    }
}

/*
public class ProdutoView {
    private JPanel panel;
    private JTextField descricaoField;
    private JTextField codigoProdutoField;
    private JTextField valorField;
    private JTextField valorPromocionalField;
    private JTextField dataInicialPromocaoField;
    private JTextField dataFinalPromocaoField;
    private JTextField quantidadeInicialField;
    private JComboBox<String> statusField;
    private JButton cadastrarButton;
    private ProdutoController produtoController;

    public ProdutoView() {
        produtoController = new ProdutoController();
        panel = new JPanel(new GridLayout(10, 2));
        
        descricaoField = new JTextField();
        codigoProdutoField = new JTextField();
        valorField = new JTextField();
        valorPromocionalField = new JTextField();
        dataInicialPromocaoField = new JTextField();
        dataFinalPromocaoField = new JTextField();
        quantidadeInicialField = new JTextField();
        statusField = new JComboBox<>(new String[] {"Ativo", "Inativo"});
        cadastrarButton = new JButton("Cadastrar Produto");

        panel.add(new JLabel("Descrição:"));
        panel.add(descricaoField);
        panel.add(new JLabel("Código do Produto:"));
        panel.add(codigoProdutoField);
        panel.add(new JLabel("Valor:"));
        panel.add(valorField);
        panel.add(new JLabel("Valor Promocional:"));
        panel.add(valorPromocionalField);
        panel.add(new JLabel("Data Inicial Promoção (dd/mm/yyyy):"));
        panel.add(dataInicialPromocaoField);
        panel.add(new JLabel("Data Final Promoção (dd/mm/yyyy):"));
        panel.add(dataFinalPromocaoField);
        panel.add(new JLabel("Quantidade Inicial:"));
        panel.add(quantidadeInicialField);
        panel.add(new JLabel("Status:"));
        panel.add(statusField);
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
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            produto.setDataInicialPromocao(sdf.parse(dataInicialPromocaoField.getText()));
            produto.setDataFinalPromocao(sdf.parse(dataFinalPromocaoField.getText()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        produto.setDataCadastro(new Date());
        produto.setStatus(statusField.getSelectedItem().equals("Ativo"));

        int quantidadeInicial = Integer.parseInt(quantidadeInicialField.getText());

        boolean sucesso = produtoController.adicionarProduto(produto, quantidadeInicial);
        if (sucesso) {
            JOptionPane.showMessageDialog(panel, "Cadastro realizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(panel, "Produto com este código já está cadastrado.");
        }
    }
}
*/

