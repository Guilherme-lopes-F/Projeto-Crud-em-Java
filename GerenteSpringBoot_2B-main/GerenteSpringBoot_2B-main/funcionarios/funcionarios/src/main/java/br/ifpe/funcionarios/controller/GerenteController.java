package br.ifpe.funcionarios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.funcionarios.model.FuncionarioDAO;
import br.ifpe.funcionarios.model.Gerente;

@Controller
public class GerenteController {

    private final FuncionarioDAO funcionarioDAO;

    public GerenteController(FuncionarioDAO funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }

    @GetMapping("/cadastro")
    public String abrirFormulario(Model model) {
        model.addAttribute("gerente", new Gerente("", 0, "", 0, 0.0, "", "", 0.0));
        return "cadastro";
    }

    @PostMapping("/salvar")
    public String salvarGerente(Gerente gerente) {
        funcionarioDAO.create(gerente);
        return "sucesso";
    }
}