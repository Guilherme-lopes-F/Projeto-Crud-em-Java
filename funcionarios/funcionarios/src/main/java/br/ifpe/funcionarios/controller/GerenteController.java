package br.ifpe.funcionarios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.ifpe.funcionarios.model.GerenteDAO;
import br.ifpe.funcionarios.model.Gerente;

@Controller
public class GerenteController {

    private final GerenteDAO gerenteDAO;

    public GerenteController(GerenteDAO gerenteDAO) {
        this.gerenteDAO = gerenteDAO;
    }

    @GetMapping("/gerentes")
    public String listarGerentes(@RequestParam(required = false) String nome, Model model) {
        if (nome != null && !nome.isEmpty()) {
            model.addAttribute("lista", gerenteDAO.filtrarPorNome(nome));
            model.addAttribute("busca", nome);
        } else {
            model.addAttribute("lista", gerenteDAO.findAll());
            model.addAttribute("busca", "");
        }
        return "listagerente";
    }

    @GetMapping("/gerentes/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Gerente g = gerenteDAO.findById(id);
        model.addAttribute("gerente", g);
        return "editargerente";
    }

    @GetMapping("/gerentes/remover/{id}")
    public String remover(@PathVariable int id) {
        gerenteDAO.delete(id);
        return "redirect:/gerentes";
    }

    @PostMapping("/gerentes/salvar")
    public String salvarGerente(Gerente gerente) {
        if (gerente.getId() == 0) {
            gerenteDAO.create(gerente);
        } else {
            gerenteDAO.update(gerente);
        }
        return "redirect:/gerentes";
    }
}