
package teste.controller;

import teste.model.Estoque;
import teste.service.EstoqueService;
import java.util.List;

public class EstoqueController {
    private EstoqueService estoqueService;

    public EstoqueController() {
        estoqueService = EstoqueService.getInstance();
    }

    public List<Estoque> listarEstoques() {
        return estoqueService.listarEstoques();
    }
}
