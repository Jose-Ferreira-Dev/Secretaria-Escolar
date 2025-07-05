package com.sge.controller;

import com.sge.model.Aluno;
import com.sge.model.Professor;
import com.sge.service.AlunoService;
import com.sge.service.ProfessorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    private final ProfessorService professorService;
    private final AlunoService alunoService;
    
    public AdminController(ProfessorService professorService, AlunoService alunoService) {
        this.professorService = professorService;
        this.alunoService = alunoService;
    }
    
    @GetMapping("/dashboard")
    public String adminDashboard(Model model) {
        return "admin/dashboard";
    }
    
    // CRUD Professores
    @GetMapping("/professores")
    public String listarProfessores(Model model) {
        model.addAttribute("professores", professorService.listarTodos());
        return "admin/professores/listar";
    }
    
    @GetMapping("/professores/novo")
    public String mostrarFormProfessor(Model model) {
        model.addAttribute("professor", new Professor());
        return "admin/professores/form";
    }
    
    @PostMapping("/professores/salvar")
    public String salvarProfessor(@ModelAttribute Professor professor) {
        professorService.salvar(professor);
        return "redirect:/admin/professores";
    }
    
    // CRUD Alunos
    @GetMapping("/alunos")
    public String listarAlunos(Model model) {
        model.addAttribute("alunos", alunoService.listarTodos());
        return "admin/alunos/listar";
    }
    
    @GetMapping("/alunos/novo")
    public String mostrarFormAluno(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "admin/alunos/form";
    }
    
    @PostMapping("/alunos/salvar")
    public String salvarAluno(@ModelAttribute Aluno aluno) {
        alunoService.salvar(aluno);
        return "redirect:/admin/alunos";
    }
}