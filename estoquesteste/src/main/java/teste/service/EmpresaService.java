package teste.service;

import java.util.ArrayList;
import java.util.List;
import teste.model.Empresa;

public class EmpresaService {
    private List<Empresa> empresas = new ArrayList<>();

    public boolean adicionarEmpresa(Empresa empresa) {
        for (Empresa e : empresas) {
            if (e.getCnpj().equals(empresa.getCnpj())) {
                return false; // Empresa existente
            }
        }
        empresas.add(empresa);
        return true;
    }

    // Outros métodos de serviço
}