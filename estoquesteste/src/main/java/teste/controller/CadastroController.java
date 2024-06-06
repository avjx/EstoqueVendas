package teste.controller;

import teste.model.Empresa;
import teste.service.EmpresaService;
import java.util.List;

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
}