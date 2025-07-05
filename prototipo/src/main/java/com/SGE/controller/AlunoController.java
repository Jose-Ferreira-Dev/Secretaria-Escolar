package com.sge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
    
    @GetMapping("/dashboard")
    public String alunoDashboard(Model model) {
        return "aluno/dashboard";
    }
    
    @GetMapping("/notas")
    public String verNotas(Model model) {
        // model.addAttribute("notas", prontuarioService.obterNotas(alunoId));
        return "aluno/notas";
    }
    
    @GetMapping("/frequencia")
    public String verFrequencia(Model model) {
        // model.addAttribute("frequencia", prontuarioService.obterFrequencia(alunoId));
        return "aluno/frequencia";
    }
    
    @GetMapping("/horarios")
    public String verHorarios(Model model) {
        // model.addAttribute("horarios", turmaService.obterHorarios(alunoId));
        return "aluno/horarios";
    }
}