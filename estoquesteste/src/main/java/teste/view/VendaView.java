package teste.view;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import teste.controller.VendaController;
import teste.controller.ClienteController;
import teste.controller.ProdutoController;
import teste.controller.CadastroController;
import teste.model.Venda;
import teste.model.Produto;
import teste.model.ItemVenda;
import teste.model.Cliente;
import teste.model.Empresa;

public class VendaView {
    private JPanel panel;
    
    private JTextField txtCodigoProduto;
    private JTextField txtQuantidade;
    private JTextField txtValorPago;
    private JTextField txtDesconto;
    private JTextField txtCpfCnpj;
    private JTextArea areaProdutos;
    private JButton btnAdicionarProduto;
    private JButton btnCalcularTroco;
    private JButton btnPagamentoEfetuado;
    private JButton btnPagamentoCancelado;
    private JLabel lblTotal;
    private JLabel lblTroco;
    private VendaController vendaController;
    private ProdutoController produtoController;
    private ClienteController clienteController;
    private CadastroController cadastroController;
    private Venda venda;

    public VendaView() {
        clienteController = new ClienteController();
        vendaController = new VendaController();
        produtoController = new ProdutoController();
        cadastroController = new CadastroController();
        venda = new Venda();

        panel = new JPanel(new GridLayout(11, 2));

        txtCodigoProduto = new JTextField();
        txtQuantidade = new JTextField();
        txtValorPago = new JTextField();
        txtDesconto = new JTextField();
        txtCpfCnpj = new JTextField();
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
        panel.add(new JLabel("CPF/CNPJ: "));
        panel.add(txtCpfCnpj);
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
        String cpfCnpj = txtCpfCnpj.getText();
        Cliente cliente = clienteController.buscarClientePorCpfCnpj(cpfCnpj);

        if (cliente == null) {
            Empresa empresa = cadastroController.buscarEmpresaPorCnpj(cpfCnpj);
            if(empresa == null){
                JOptionPane.showMessageDialog(null, "Cliente/Empresa não encontrado nos registros.");
                return;
            }
            cliente = new Cliente(); // Transforme a empresa em cliente para associar na venda
            cliente.setNome(empresa.getRazaoSocial());
            cliente.setCpf(empresa.getCnpj());
        }
        
        venda.setCliente(cliente);

        if (vendaController.registrarVenda(venda)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String vendaJson = gson.toJson(venda);

            JTextArea textArea = new JTextArea(vendaJson);
            textArea.setEditable(false);
            textArea.setRows(20);
            textArea.setColumns(50);
            JScrollPane scrollPane = new JScrollPane(textArea);

            JOptionPane.showMessageDialog(null, scrollPane, "Venda registrada com sucesso!", JOptionPane.INFORMATION_MESSAGE);
            //JOptionPane.showMessageDialog(null, "Venda registrada com sucesso!\n" + vendaJson);

            List<Venda> vendas = lerVendasDoArquivo();
            vendas.add(venda);
            salvarVendasNoArquivo(vendas);

            limparTela();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao registrar a venda. Verifique o estoque.");
        }
        /*if (vendaController.registrarVenda(venda)) {
            Gson gson = new Gson();
            String vendaJson = gson.toJson(venda);
            JOptionPane.showMessageDialog(null, "Venda registrada com sucesso!"+ vendaJson);

            try(FileWriter writer = new FileWriter("venda.json")){
                writer.write(vendaJson);
            }catch(IOException e){
                e.printStackTrace();
            }

            limparTela();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao registrar a venda. Verifique o estoque.");
        }*/
    }

    private List<Venda> lerVendasDoArquivo() {
        try (Reader reader = new FileReader("venda.json")) {
            Type vendaListType = new TypeToken<ArrayList<Venda>>() {}.getType();
            return new Gson().fromJson(reader, vendaListType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private void salvarVendasNoArquivo(List<Venda> vendas) {
        try (Writer writer = new FileWriter("venda.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(vendas, writer);
        } catch (IOException e) {
            e.printStackTrace();
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
        txtCpfCnpj.setText("");
        areaProdutos.setText("");
        lblTotal.setText("Total: ");
        lblTroco.setText("Troco: ");
        venda = new Venda();
    }

    public JPanel getPanel() {
        return panel;
    }
}
