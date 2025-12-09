package br.ifpe.funcionarios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.funcionarios.model.Desenvolvedor;
import br.ifpe.funcionarios.model.DesenvolvedorDAO;

@Controller
public class DesenvolvedorController {

    private final DesenvolvedorDAO dao;

    public DesenvolvedorController(DesenvolvedorDAO dao) {
        this.dao = dao;
    }

    @GetMapping("/desenvolvedores")
    public String listar(Model model) {
        model.addAttribute("lista", dao.findAll());
        return "lista-devs";
    }

    @GetMapping("/desenvolvedores/novo")
    public String novo(Model model) {

        model.addAttribute("desenvolvedor", new Desenvolvedor("", 0, "", 0, 0.0, "", "", ""));
        return "cadastro-dev";
    }

    @PostMapping("/desenvolvedores/salvar")
    public String salvar(Desenvolvedor desenvolvedor) {
        dao.create(desenvolvedor);
        return "redirect:/desenvolvedores";
    }

    @GetMapping("/desenvolvedores/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Desenvolvedor d = dao.findById(id);
        model.addAttribute("desenvolvedor", d);
        return "cadastro-dev";
    }

    @PostMapping("/desenvolvedores/atualizar")
    public String atualizar(Desenvolvedor desenvolvedor) {
        dao.update(desenvolvedor);
        return "redirect:/desenvolvedores";
    }

    @GetMapping("/desenvolvedores/remover/{id}")
    public String remover(@PathVariable int id) {
        dao.delete(id);
        return "redirect:/desenvolvedores";
    }
}