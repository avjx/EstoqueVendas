package teste.controller;

import teste.model.Cliente;
import teste.service.ClienteService;
import java.util.List;

public class ClienteController {
    private ClienteService clienteService;

    public ClienteController() {
        this.clienteService = new ClienteService();
    }

    public boolean adicionarCliente(Cliente cliente) {
        return clienteService.adicionarCliente(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }
}
