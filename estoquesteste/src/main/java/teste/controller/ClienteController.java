package teste.controller;

import teste.model.Cliente;
import teste.service.ClienteService;
import java.util.List;

public class ClienteController {
    private ClienteService clienteService;

    public ClienteController() {
        clienteService = ClienteService.getInstance();
    }

    public List<Cliente> getClientes() {
        return clienteService.getClientes();
    }

    public boolean adicionarCliente(Cliente cliente) {
        return clienteService.adicionarCliente(cliente);
    }

    public Cliente buscarClientePorCpfCnpj(String cpfCnpj) {
        return clienteService.buscarClientePorCpfCnpj(cpfCnpj);
    }
}
