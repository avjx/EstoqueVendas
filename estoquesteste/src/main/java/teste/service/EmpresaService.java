package teste.service;

import java.util.ArrayList;
import java.util.List;

import teste.model.Cliente;
import teste.model.Empresa;


public class EmpresaService {
    private static EmpresaService instance;
    private List<Empresa> empresas;

    private EmpresaService() {
        empresas = new ArrayList<>();
    }

    public static EmpresaService getInstance() {
        if (instance == null) {
            instance = new EmpresaService();
        }
        return instance;
    }

    public boolean adicionarEmpresa(Empresa empresa) {
        for (Empresa e : empresas) {
            if (e.getCnpj().equals(empresa.getCnpj())) {
                return false; // Empresa já cadastrada
            }
        }
        empresas.add(empresa);
        return true;
    }

    public boolean cadastrarEmpresa(Empresa empresa) {
        for (Empresa e : empresas) {
            if (e.getCnpj().equals(empresa.getCnpj())) {
                return false; // Empresa já cadastrada
            }
        }
        empresas.add(empresa);
        return true;
    }

    public Empresa buscarClientePorCpfCnpj(String cpfCnpj) {
        for (Empresa empresa : empresas) {
            if (empresa.getCnpj().equals(cpfCnpj)) {
                return empresa;
            }
        }
        return null;
    }

    public List<Empresa> getEmpresas() {
        return new ArrayList<>(empresas);
    }
}
