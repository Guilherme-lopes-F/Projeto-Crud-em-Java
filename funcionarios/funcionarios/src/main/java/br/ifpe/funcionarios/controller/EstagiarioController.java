package br.ifpe.funcionarios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.ifpe.funcionarios.model.Estagiario;
import br.ifpe.funcionarios.model.EstagiarioDAO;

@Controller
public class EstagiarioController {

    private final EstagiarioDAO dao;

    public EstagiarioController(EstagiarioDAO dao) {
        this.dao = dao;
    }

    @GetMapping("/estagiarios")
    public String listar(@RequestParam(required = false) String nome, Model model) {
        if (nome != null && !nome.isEmpty()) {
            model.addAttribute("lista", dao.filtrarPorNome(nome));
            model.addAttribute("busca", nome);
        } else {
            model.addAttribute("lista", dao.findAll());
            model.addAttribute("busca", "");
        }
        return "listaestagio";
    }

    @PostMapping("/estagiarios/salvar-edicao")
    public String salvarEdicao(Estagiario estagiario) {
        dao.update(estagiario);
        return "redirect:/estagiarios";
    }

    @GetMapping("/estagiarios/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Estagiario e = dao.findById(id);
        model.addAttribute("estagiario", e);
        return "editarestagio";
    }

    @GetMapping("/estagiarios/remover/{id}")
    public String remover(@PathVariable int id) {
        dao.delete(id);
        return "redirect:/estagiarios";
    }
}