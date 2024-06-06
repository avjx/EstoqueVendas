package teste.view;

import java.awt.CardLayout;
import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema de Estoque e Vendas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Cria a barra de menu
        JMenuBar menuBar = new JMenuBar();
        JMenu cadastroMenu = new JMenu("Cadastros");
        JMenuItem empresaMenuItem = new JMenuItem("Cadastro de Empresa");
        JMenuItem clienteMenuItem = new JMenuItem("Cadastro de Cliente");
        JMenuItem produtoMenuItem = new JMenuItem("Cadastro de Produtos");

        //Adiciona itens de menu
        cadastroMenu.add(empresaMenuItem);
        cadastroMenu.add(clienteMenuItem);
        cadastroMenu.add(produtoMenuItem);
        menuBar.add(cadastroMenu);
        frame.setJMenuBar(menuBar);

        //CardLayout para gerenciar múltiplos painéis
        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        // Cria os painéis de cadastro
        CadastroView cadastroView = new CadastroView();
        ClienteView clienteView = new ClienteView();
        ProdutoView produtoView = new ProdutoView();

        // Adiciona os painéis ao mainPanel
        mainPanel.add(cadastroView.getPanel(), "CadastroEmpresa");
        mainPanel.add(clienteView.getPanel(), "CadastroCliente");
        mainPanel.add(produtoView.getPanel(), "CadastroProdutos");

        // Adiciona ações para os itens de menu
        empresaMenuItem.addActionListener(e -> cardLayout.show(mainPanel, "CadastroEmpresa"));
        clienteMenuItem.addActionListener(e -> cardLayout.show(mainPanel, "CadastroCliente"));
        produtoMenuItem.addActionListener(e -> cardLayout.show(mainPanel, "CadastroProdutos"));

        // Adiciona o mainPanel ao frame
        frame.add(mainPanel);
        frame.setVisible(true);
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