package teste.controller;

import teste.model.Cliente;
import teste.model.Empresa;
import teste.service.EmpresaService;
import java.util.List;

public class CadastroController {
    private EmpresaService empresaService;

    public CadastroController() {
        empresaService = EmpresaService.getInstance();
    }

    public boolean adicionarEmpresa(Empresa empresa) {
        return empresaService.adicionarEmpresa(empresa);
    }

    public List<Empresa> getEmpresas() {
        return empresaService.getEmpresas();
    }

    public Empresa buscarEmpresaPorCnpj(String cpfCnpj) {
        return empresaService.buscarClientePorCpfCnpj(cpfCnpj);
    }
}

/*
public class CadastroController {
    private EmpresaService empresaService;

    public CadastroController() {
        this.empresaService = new EmpresaService();
    }

    public boolean adicionarEmpresa(Empresa empresa) {
        return empresaService.adicionarEmpresa(empresa);
    }

    public List<Empresa> listarEmpresas() {
        return empresaService.listarEmpresas();
    }

    public List<Empresa> getEmpresas() {
        return empresaService.getEmpresas();
    }
}*/