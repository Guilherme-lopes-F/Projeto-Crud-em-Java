package br.ifpe.funcionarios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.funcionarios.model.FuncionarioForm;
import br.ifpe.funcionarios.model.Gerente;
import br.ifpe.funcionarios.model.Desenvolvedor;
import br.ifpe.funcionarios.model.Estagiario;
import br.ifpe.funcionarios.model.GerenteDAO;
import br.ifpe.funcionarios.model.DesenvolvedorDAO;
import br.ifpe.funcionarios.model.EstagiarioDAO;

@Controller
public class FuncionarioController {

    private final GerenteDAO gerenteDAO;
    private final DesenvolvedorDAO desenvolvedorDAO;
    private final EstagiarioDAO estagiarioDAO;

    public FuncionarioController(GerenteDAO gerenteDAO, DesenvolvedorDAO desenvolvedorDAO,
            EstagiarioDAO estagiarioDAO) {
        this.gerenteDAO = gerenteDAO;
        this.desenvolvedorDAO = desenvolvedorDAO;
        this.estagiarioDAO = estagiarioDAO;
    }

    @GetMapping("/cadastro")
    public String abrirFormulario(Model model) {
        model.addAttribute("form", new FuncionarioForm());
        return "cadastro";
    }

    @PostMapping("/salvar")
    public String salvarFuncionario(FuncionarioForm form, Model model) {
        String cargo = form.getCargo();

        // Tratamento simples para valores nulos (Evita NullPointerException)
        int idade = form.getIdade() == null ? 0 : form.getIdade();
        int codigo = form.getCodigo() == null ? 0 : form.getCodigo();
        double salario = form.getSalario() == null ? 0.0 : form.getSalario();

        if ("Gerente".equals(cargo)) {
            Gerente g = new Gerente(
                    form.getNome(),
                    idade,
                    form.getEmail(),
                    codigo,
                    salario,
                    form.getRua(),
                    form.getCidade(),
                    form.getBonus() == null ? 0.0 : form.getBonus());
            gerenteDAO.create(g);
            model.addAttribute("funcionario", g);

        } else if ("Desenvolvedor".equals(cargo)) {
            Desenvolvedor d = new Desenvolvedor(
                    form.getNome(),
                    idade,
                    form.getEmail(),
                    codigo,
                    salario,
                    form.getRua(),
                    form.getCidade(),
                    form.getLinguagemPrincipal());
            desenvolvedorDAO.create(d);
            model.addAttribute("funcionario", d);

        } else if ("Estagiario".equals(cargo)) {
            Estagiario s = new Estagiario(
                    form.getNome(),
                    idade,
                    form.getEmail(),
                    codigo,
                    salario,
                    form.getRua(),
                    form.getCidade(),
                    form.getInstituicaoEnsino());
            estagiarioDAO.create(s);
            model.addAttribute("funcionario", s);

        } else {
            model.addAttribute("form", form);
            return "cadastro";
        }

        return "sucesso";
    }
}