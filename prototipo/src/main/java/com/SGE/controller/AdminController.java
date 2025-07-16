package com.SGE.controller;

import com.SGE.dto.AlunoDTO;
import com.SGE.model.Aluno;
import com.SGE.model.Professor;
import com.SGE.service.ADMProntuarioService;
import com.SGE.service.AlunoService;
import com.SGE.service.ProfessorService;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AdminController {

    public AdminController(com.SGE.service.ADMProntuarioService prontuarioService) {
        this.prontuarioService = prontuarioService;
    }

    @Autowired
    private AlunoService alunoService;
    
    @Autowired
    private ProfessorService professorService;
    
    @Autowired
    private final ADMProntuarioService prontuarioService;

    // Dashboard principal
    @GetMapping("/dashboard")
    public String dashboard(Model model, Authentication auth) {
        model.addAttribute("username", auth.getName());
        return "admin/dashboard";
    }

    // Página inicial de listagem
    @GetMapping("/listar")
    public String listagem(Model model) {
        return "admin/listar"; 
    }

    // Lista apenas alunos
    @GetMapping("/listar-alunos")
public String listarAlunos(Model model) {
    List<AlunoDTO> alunos = alunoService.listarTodosAlunosDTO();
    model.addAttribute("alunos", alunos);
    return "admin/listar-alunos";
}

    // Lista apenas professores
    @GetMapping("/listar-professores")
    public String listarProfessores(Model model) {
        model.addAttribute("professores", professorService.listarTodos());
        return "admin/listar-professores";
    }

    // Adicionar novo cadastro
    @GetMapping("/adicionar")
    public String mostrarFormAdicionar(Model model) {
        model.addAttribute("aluno", new Aluno());
        model.addAttribute("professor", new Professor());
        return "admin/adicionar";
    }

   
    // Edição de Aluno
    @GetMapping("/editar/aluno/{id}")
public String editarAluno(@PathVariable Long id, Model model) {
    Aluno aluno = alunoService.buscarPorId(id);
    model.addAttribute("aluno", aluno);
    model.addAttribute("alunoDTO", new AlunoDTO(aluno)); // Para exibição formatada
    return "admin/editar-aluno";
}
    
    @PostMapping("/salvar-aluno")
public String salvarAluno(@ModelAttribute Aluno aluno,
                         @RequestParam("dataNascimento") String dataNascimentoStr) {
    
    aluno.setDataNascimento(LocalDate.parse(dataNascimentoStr));
    alunoService.salvar(aluno);
    return "redirect:/admin/listar-alunos";
}
    
    
    // Edição de Professor
    @GetMapping("/editar/professor/{id}")
    public String editarProfessor(@PathVariable Long id, Model model) {
        Professor professor = professorService.buscarPorId(id);
        model.addAttribute("professor", professor);
        return "admin/editar-professor";
    }

    @PostMapping("/salvar-professor")
    public String salvarProfessor(@ModelAttribute Professor professor) {
        professorService.salvar(professor);
        return "redirect:/admin/listar-professores";
    }
    
    // Adicionar Aluno
    @GetMapping("/adicionar-aluno")
    public String mostrarFormularioAluno(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "admin/adicionar-aluno";
    }
    
    // Adicionar Professor
    @GetMapping("/adicionar-professor")
    public String mostrarFormularioProfessor(Model model) {
        model.addAttribute("professor", new Professor());
        return "admin/adicionar-professor";
    }
    
    @GetMapping("/prontuario-alunos")
public String listarProntuarios(Model model) {
    // Busca todos os alunos com seus prontuários e informações relacionadas
    List<Map<String, Object>> prontuarios = alunoService.listarProntuariosCompletos();
    model.addAttribute("prontuarios", prontuarios);
    return "admin/prontuario-alunos";
}

@GetMapping("/adicionar-prontuario")
    public String mostrarFormularioAdicionar() {
        return "admin/adicionar-prontuario";
    }

    @PostMapping("/adicionar-prontuario")
    public String adicionarProntuario(
            @RequestParam("alunoId") int alunoId,
            @RequestParam("cursoId") int cursoId,
            @RequestParam("situacaoCurso") String situacaoCurso,
            @RequestParam("notasAluno") String notasAluno,
            @RequestParam("frequenciaAluno") String frequenciaAluno,
            @RequestParam("observacoes") String observacoes,            
            RedirectAttributes redirectAttributes) {

        return prontuarioService.adicionarProntuario(
                alunoId,
                cursoId,
                situacaoCurso,
                notasAluno,
                frequenciaAluno,
                observacoes,
                redirectAttributes
        );
    }
    

    // Exclusão
    @GetMapping("/excluir/{tipo}/{id}")
    public String excluirCadastro(@PathVariable String tipo,
                                @PathVariable Long id) {
        if (tipo.equals("aluno")) {
            alunoService.excluir(id);
        } else {
            professorService.excluir(id);
        }
        return "redirect:/admin/listar";
    }
}