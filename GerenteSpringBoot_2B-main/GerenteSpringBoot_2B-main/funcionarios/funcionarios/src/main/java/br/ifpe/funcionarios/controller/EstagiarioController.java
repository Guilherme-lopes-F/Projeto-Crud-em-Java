package br.ifpe.funcionarios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.funcionarios.model.Estagiario;
import br.ifpe.funcionarios.model.EstagiarioDAO;

@Controller
public class EstagiarioController {

    private final EstagiarioDAO dao;

    public EstagiarioController(EstagiarioDAO dao) {
        this.dao = dao;
    }

    @GetMapping("/estagiarios")
    public String listar(Model model) {
        model.addAttribute("lista", dao.findAll());
        return "lista-estagiarios";
    }

    @GetMapping("/estagiarios/novo")
    public String novo(Model model) {
        model.addAttribute("estagiario", new Estagiario("", 0, "", 0, 0.0, "", "", ""));
        return "cadastro-estagiario";
    }

    @PostMapping("/estagiarios/salvar")
    public String salvar(Estagiario estagiario) {
        dao.create(estagiario);
        return "redirect:/estagiarios";
    }

    @GetMapping("/estagiarios/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Estagiario e = dao.findById(id);
        model.addAttribute("estagiario", e);
        return "cadastro-estagiario";
    }

    @PostMapping("/estagiarios/atualizar")
    public String atualizar(Estagiario estagiario) {
        dao.update(estagiario);
        return "redirect:/estagiarios";
    }

    @GetMapping("/estagiarios/remover/{id}")
    public String remover(@PathVariable int id) {
        dao.delete(id);
        return "redirect:/estagiarios";
    }
}