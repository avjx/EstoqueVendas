package teste.service;

import java.util.ArrayList;
import java.util.List;
import teste.model.Cliente;

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
}
