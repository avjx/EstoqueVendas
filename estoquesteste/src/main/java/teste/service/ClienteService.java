package teste.service;

import java.util.ArrayList;
import java.util.List;
import teste.model.Cliente;

public class ClienteService {
    private static ClienteService instance;
    private List<Cliente> clientes;

    private ClienteService() {
        clientes = new ArrayList<>();
    }

    public static ClienteService getInstance() {
        if (instance == null) {
            instance = new ClienteService();
        }
        return instance;
    }

    public boolean adicionarCliente(Cliente cliente) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cliente.getCpf())) {
                return false; // Cliente já cadastrado
            }
        }
        clientes.add(cliente);
        return true;
    }

    public boolean cadastrarCliente(Cliente cliente) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cliente.getCpf())) {
                return false; // Cliente já cadastrado
            }
        }
        clientes.add(cliente);
        return true;
    }

    public List<Cliente> getClientes() {
        return new ArrayList<>(clientes);
    }
}

/*
public class ClienteService {
    private List<Cliente> clientes = new ArrayList<>();

    public boolean adicionarCliente(Cliente cliente){
        for(Cliente c : clientes){
            if(c.getCpf().equals(cliente.getCpf())){
                return false; //cliente existente
            }
        }
        clientes.add(cliente);
        return true;
    }

    public List<Cliente> listarClientes(){
        return clientes;
    }
}
*/