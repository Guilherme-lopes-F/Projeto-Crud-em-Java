package br.ifpe.funcionarios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.ifpe.funcionarios.model.Desenvolvedor;
import br.ifpe.funcionarios.model.DesenvolvedorDAO;

@Controller
public class DesenvolvedorController {

    private final DesenvolvedorDAO dao;

    public DesenvolvedorController(DesenvolvedorDAO dao) {
        this.dao = dao;
    }

    @GetMapping("/desenvolvedores")
    public String listar(@RequestParam(required = false) String nome, Model model) {
        if (nome != null && !nome.isEmpty()) {
            model.addAttribute("lista", dao.filtrarPorNome(nome));
            model.addAttribute("busca", nome);
        } else {
            model.addAttribute("lista", dao.findAll());
            model.addAttribute("busca", "");
        }
        return "listadev";
    }

    @PostMapping("/desenvolvedores/salvar-edicao")
    public String salvarEdicao(Desenvolvedor desenvolvedor) {
        dao.update(desenvolvedor);
        return "redirect:/desenvolvedores";
    }

    @GetMapping("/desenvolvedores/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Desenvolvedor d = dao.findById(id);
        model.addAttribute("desenvolvedor", d);
        return "editardev";
    }

    @GetMapping("/desenvolvedores/remover/{id}")
    public String remover(@PathVariable int id) {
        dao.delete(id);
        return "redirect:/desenvolvedores";
    }
}