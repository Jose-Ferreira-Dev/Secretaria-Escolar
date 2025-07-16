package com.SGE.controller;

import com.SGE.dto.AlunoDTO;
import com.SGE.model.Aluno;
import com.SGE.service.AlunoService;
import java.time.LocalDate;
import com.SGE.service.ProntuarioService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/professor")
public class ProfessorController {

    public ProfessorController(com.SGE.service.ProntuarioService prontuarioService) {
        this.prontuarioService = prontuarioService;
    }

    @Autowired
    private AlunoService alunoService;
    private final ProntuarioService prontuarioService;


    // Dashboard principal
    @GetMapping("/dashboard")
    public String dashboard(Model model, Authentication auth) {
        model.addAttribute("username", auth.getName());
        return "professor/dashboard";
    }
    
    @GetMapping("/listar-alunos")
public String listarAlunos(Model model) {
    List<AlunoDTO> alunos = alunoService.listarTodosAlunosDTO();
    model.addAttribute("alunos", alunos);
    return "professor/listar-alunos";
}

// Adicionar Aluno
    @GetMapping("/adicionar-aluno")
    public String mostrarFormularioAluno(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "professor/adicionar-aluno";
    }
   
    // Edição de Aluno
    @GetMapping("/editar/aluno/{id}")
public String editarAluno(@PathVariable Long id, Model model) {
    Aluno aluno = alunoService.buscarPorId(id);
    model.addAttribute("aluno", aluno);
    model.addAttribute("alunoDTO", new AlunoDTO(aluno)); // Para exibição formatada
    return "professor/editar-alunos";
}
    
    @PostMapping("/salvar-aluno")
public String salvarAluno(@ModelAttribute Aluno aluno,
                         @RequestParam("dataNascimento") String dataNascimentoStr) {
    
    aluno.setDataNascimento(LocalDate.parse(dataNascimentoStr));
    alunoService.salvar(aluno);
    return "redirect:/professor/listar-alunos";
}

@GetMapping("/prontuario-alunos")
public String listarProntuarios(Model model) {
    // Busca todos os alunos com seus prontuários e informações relacionadas
    List<Map<String, Object>> prontuarios = alunoService.listarProntuariosCompletos();
    model.addAttribute("prontuarios", prontuarios);
    return "professor/prontuario-alunos";
}
    

@GetMapping("/adicionar-prontuario")
    public String mostrarFormularioAdicionar() {
        return "professor/adicionar-prontuario";
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
        }
        return "redirect:/professor/listar-alunos";
    }
}
