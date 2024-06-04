package teste.view;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import teste.service.ClienteService;
import teste.model.Cliente;
import java.util.Date;

public class ClienteView {
    private JPanel panel;
    private JTextField nomeField;
    private JTextField cpfField;
    private JTextField dataNascimentoField;
    private JTextField emailField;
    private JTextField telefoneField;
    private JTextField celularField;
    private JTextField enderecoField;
    private JButton cadastrarButton;
    private ClienteService clienteService;

    public ClienteView(){
        clienteService = new ClienteService();
        panel = new JPanel(new GridLayout(9, 2));
        
        nomeField = new JTextField();
        cpfField = new JTextField();
        dataNascimentoField = new JTextField();
        emailField = new JTextField();
        telefoneField = new JTextField();
        celularField = new JTextField();
        enderecoField = new JTextField();
        cadastrarButton = new JButton("Cadastrar Cliente");

        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("CPF:"));
        panel.add(cpfField);
        panel.add(new JLabel("Data de Nascimento (dd/mm/yyyy):"));
        panel.add(dataNascimentoField);
        panel.add(new JLabel("E-mail:"));
        panel.add(emailField);
        panel.add(new JLabel("Telefone:"));
        panel.add(telefoneField);
        panel.add(new JLabel("Celular:"));
        panel.add(celularField);
        panel.add(new JLabel("Endereço Completo:"));
        panel.add(enderecoField);
        panel.add(cadastrarButton);

        cadastrarButton.addActionListener(e -> cadastrarCliente());
    }

    public JPanel getPanel(){
        return panel;
    }

    private void cadastrarCliente(){
        Cliente cliente = new Cliente();
        cliente.setNome(nomeField.getText());
        cliente.setCpf(cpfField.getText());
        
        try{
            cliente.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimentoField.getText()));
        }catch(ParseException e){
            JOptionPane.showMessageDialog(panel, "Formato inválido.");
            return;
        }

        cliente.setEmail(emailField.getText());
        cliente.setTelefone(telefoneField.getText());
        cliente.setCelular(celularField.getText());
        cliente.setEnderecoCompleto(enderecoField.getText());
        cliente.setDataCadastro(new Date());

        boolean sucesso = clienteService.adicionarCliente(cliente);
        if(sucesso){
            JOptionPane.showMessageDialog(panel, "Cliente Cadastrado!");
        }else{
            JOptionPane.showMessageDialog(panel, "Já existe um cadastro com este CPF!");
        }
    }
}
