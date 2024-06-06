package teste.view;

import java.awt.CardLayout;
import javax.swing.*;

import teste.controller.ProdutoController;
import teste.model.Estoque;
import teste.model.Produto;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema de Estoque e Vendas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JMenuBar menuBar = new JMenuBar();
        JMenu cadastroMenu = new JMenu("Cadastros");
        JMenuItem empresaMenuItem = new JMenuItem("Cadastro de Empresa");
        JMenuItem clienteMenuItem = new JMenuItem("Cadastro de Cliente");
        JMenuItem produtoMenuItem = new JMenuItem("Cadastro de Produto");
        JMenuItem estoqueMenuItem = new JMenuItem("Controle de Estoque");

        cadastroMenu.add(empresaMenuItem);
        cadastroMenu.add(clienteMenuItem);
        cadastroMenu.add(produtoMenuItem);
        cadastroMenu.add(estoqueMenuItem);
        menuBar.add(cadastroMenu);
        frame.setJMenuBar(menuBar);

        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        CadastroView cadastroView = new CadastroView();
        ClienteView clienteView = new ClienteView();
        ProdutoView produtoView = new ProdutoView();
        EstoqueView estoqueView = new EstoqueView();

        mainPanel.add(cadastroView.getPanel(), "CadastroEmpresa");
        mainPanel.add(clienteView.getPanel(), "CadastroCliente");
        mainPanel.add(produtoView.getPanel(), "CadastroProduto");
        mainPanel.add(estoqueView.getPanel(), "ControleEstoque");

        empresaMenuItem.addActionListener(e -> cardLayout.show(mainPanel, "CadastroEmpresa"));
        clienteMenuItem.addActionListener(e -> cardLayout.show(mainPanel, "CadastroCliente"));
        produtoMenuItem.addActionListener(e -> cardLayout.show(mainPanel, "CadastroProduto"));
        estoqueMenuItem.addActionListener(e -> cardLayout.show(mainPanel, "ControleEstoque"));

        frame.add(mainPanel);
        frame.setVisible(true);

        // Inicialização de dados para teste
        ProdutoController produtoController = new ProdutoController();
        Produto produto = new Produto();
        produto.setDescricao("Produto de Teste");
        produto.setCodigoProduto("001");
        produto.setValor(100.0);
        produto.setValorPromocional(90.0);
        produto.setDataCadastro(new java.util.Date());
        produto.setDataInicialPromocao(new java.util.Date());
        produto.setDataFinalPromocao(new java.util.Date());
        produto.setStatus(true);
        
        boolean adicionado = produtoController.adicionarProduto(produto, 50); // Adicionando 50 unidades no estoque
        System.out.println("Produto adicionado: " + adicionado);
    }
}

/*
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Estoque e Vendas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        
        JMenuBar menuBar = new JMenuBar();
        JMenu cadastroMenu = new JMenu("Cadastros");
        JMenuItem empresaMenuItem = new JMenuItem("Cadastro Empresa");
        JMenuItem clienteMenuItem = new JMenuItem("Cadastro Cliente");

        cadastroMenu.add(empresaMenuItem);
        cadastroMenu.add(clienteMenuItem);
        menuBar.add(cadastroMenu);
        frame.setJMenuBar(menuBar);

        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        CadastroView cadastroView = new CadastroView();
        ClienteView clienteView = new ClienteView();

        mainPanel.add(cadastroView.getPanel(), "CadastroEmpresa");
        mainPanel.add(clienteView.getPanel(), "CadastroCliente");

        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
*/