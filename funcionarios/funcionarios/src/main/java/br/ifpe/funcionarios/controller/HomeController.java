package br.ifpe.funcionarios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Aceita tanto a raiz "/" quanto "/home"
    @GetMapping({ "/", "/home" })
    public String index() {
        return "home";
    }
}