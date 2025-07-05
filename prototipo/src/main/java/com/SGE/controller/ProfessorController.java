package com.sge.controller;

import com.sge.model.Turma;
import com.sge.service.TurmaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/professor")
public class ProfessorController {
    
    private final TurmaService turmaService;
    
    public ProfessorController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }
    
    @GetMapping("/dashboard")
    public String professorDashboard(Model model) {
        // Aqui você deve obter o professor logado e suas turmas
        // model.addAttribute("turmas", turmaService.listarPorProfessor(professorId));
        return "professor/dashboard";
    }
    
    @GetMapping("/turmas")
    public String listarTurmas(Model model) {
        // model.addAttribute("turmas", turmaService.listarPorProfessor(professorId));
        return "professor/turmas/listar";
    }
    
    @GetMapping("/alunos")
    public String listarAlunos(Model model) {
        // model.addAttribute("alunos", alunoService.listarPorTurma(turmaId));
        return "professor/alunos/listar";
    }
}