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
