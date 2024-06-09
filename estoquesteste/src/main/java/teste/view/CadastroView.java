package teste.view;

import javax.swing.*;
import java.awt.*;
import teste.controller.CadastroController;
import teste.service.EmpresaService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import teste.model.Empresa;
import java.util.Date;

public class CadastroView {
    private JPanel panel;
    private JTextField razaoSocialField;
    private JTextField nomeFantasiaField;
    private JTextField cnpjField;
    private JTextField emailField;
    private JTextField telefoneField;
    private JTextField celularField;
    private JTextField contatoField;
    private JTextField enderecoField;
    private JButton cadastrarButton;
    private CadastroController cadastroController;

    public CadastroView(){
        cadastroController = new CadastroController();
        panel = new JPanel(new GridLayout(10, 2));
        
        razaoSocialField = new JTextField();
        nomeFantasiaField = new JTextField();
        cnpjField = new JTextField();
        emailField = new JTextField();
        telefoneField = new JTextField();
        celularField = new JTextField();
        contatoField = new JTextField();
        enderecoField = new JTextField();
        cadastrarButton = new JButton("Cadastrar Empresa");

        panel.add(new JLabel("Razão Social:"));
        panel.add(razaoSocialField);
        panel.add(new JLabel("Nome Fantasia:"));
        panel.add(nomeFantasiaField);
        panel.add(new JLabel("CNPJ:"));
        panel.add(cnpjField);
        panel.add(new JLabel("E-mail:"));
        panel.add(emailField);
        panel.add(new JLabel("Telefone:"));
        panel.add(telefoneField);
        panel.add(new JLabel("Celular:"));
        panel.add(celularField);
        panel.add(new JLabel("Contato:"));
        panel.add(contatoField);
        panel.add(new JLabel("Endereço Completo:"));
        panel.add(enderecoField);
        panel.add(cadastrarButton);

        cadastrarButton.addActionListener(e -> cadastrarEmpresa());
    }

    public JPanel getPanel(){
        return panel;
    }

    private void cadastrarEmpresa(){
        Empresa empresa = new Empresa();
        empresa.setRazaoSocial(razaoSocialField.getText());
        empresa.setNomeFantasia(nomeFantasiaField.getText());
        empresa.setCnpj(cnpjField.getText());
        empresa.setEmail(emailField.getText());
        empresa.setTelefone(telefoneField.getText());
        empresa.setCelular(celularField.getText());
        empresa.setContato(contatoField.getText());
        empresa.setEnderecoCompleto(enderecoField.getText());
        empresa.setDataCadastro(new Date());

        boolean sucesso = cadastroController.adicionarEmpresa(empresa);
        if (sucesso) {
            JOptionPane.showMessageDialog(panel, "Empresa cadastrada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(panel, "Empresa com este CNPJ já está cadastrada.");
        }

    }
}