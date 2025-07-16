package com.SGE.controller;


import com.SGE.dto.AlunoDTO;
import com.SGE.dto.TurmaHorarioDTO;
import com.SGE.model.Curso;
import com.SGE.model.Disciplina;
import com.SGE.repository.CursoRepository;
import com.SGE.repository.DisciplinaRepository;
import com.SGE.repository.SalaTurmaRepository;
import com.SGE.repository.TurmaRepository;
import com.SGE.service.AlunoService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/aluno")  // Rotas começam com /aluno
public class AlunoController {
    
     @Autowired
    private AlunoService alunoService;
     
     private DisciplinaRepository disciplinaRepository;
     
    private TurmaRepository turmaRepository;
    
    private CursoRepository cursoRepository;
    
   private final SalaTurmaRepository salaTurmaRepository;

    // Injeção via construtor (forma recomendada)
    @Autowired
    public AlunoController(DisciplinaRepository disciplinaRepository,
                              TurmaRepository turmaRepository,
                              CursoRepository cursoRepository,
                              SalaTurmaRepository salaTurmaRepository) {
        this.disciplinaRepository = disciplinaRepository;
        this.turmaRepository = turmaRepository;
        this.cursoRepository = cursoRepository;
        this.salaTurmaRepository = salaTurmaRepository;
    }

    @GetMapping("/dashboard")  // /aluno/dashboard
    public String alunoDashboard() {
        return "aluno/dashboard";  // templates/aluno/dashboard.html
    }
    
    @GetMapping("/listar-alunos")
public String listarAlunos(Model model) {
    List<AlunoDTO> alunos = alunoService.listarTodosAlunosDTO();
    model.addAttribute("alunos", alunos);
    return "aluno/listar-alunos";
}

    @GetMapping("/prontuario")
public String listarProntuarios(Model model) {
    // Busca todos os alunos com seus prontuários e informações relacionadas
    List<Map<String, Object>> prontuarios = alunoService.listarProntuariosCompletos();
    model.addAttribute("prontuarios", prontuarios);
    return "aluno/prontuario";
}

@GetMapping("/listagem-geral")
public String listarTudo(Model model) {
    // 1. Listar todos os cursos
    List<Curso> cursos = cursoRepository.findAll();
    model.addAttribute("cursos", cursos);
    
    // 2. Listar todas as disciplinas
    List<Disciplina> disciplinas = disciplinaRepository.findAll();
    model.addAttribute("disciplinas", disciplinas);
    
    // 3. Listar todas as turmas com horários
    List<TurmaHorarioDTO> turmas = turmaRepository.findAll()
        .stream()
        .map(turma -> {
            TurmaHorarioDTO dto = new TurmaHorarioDTO();
            dto.setId(turma.getId());
            dto.setCodigo(turma.getCodigoTurma());
            dto.setDisciplina(turma.getDisciplina().getNomeDisciplina());
            
            // Criando lista de horários formatados
            List<String> horarios = new ArrayList<>();
            
            // Verifica se existe horário principal na turma
            if (turma.getDiaSemana() != null && !turma.getDiaSemana().isEmpty() &&
                turma.getHoraInicio() != null && !turma.getHoraInicio().isEmpty() &&
                turma.getHoraFim() != null && !turma.getHoraFim().isEmpty()) {
                
                String horarioFormatado = turma.getDiaSemana() + " " + 
                                      turma.getHoraInicio() + " às " + 
                                      turma.getHoraFim();
                
                // Adiciona informação da sala se existir
                if (turma.getSala() != null) {
                    horarioFormatado += " (Sala " + turma.getSala().getNumeroSala() + ")";
                }
                
                horarios.add(horarioFormatado);
            } else {
                horarios.add("Horário não definido");
            }
            
            dto.setHorarios(horarios);
            return dto;
        })
        .collect(Collectors.toList());
    
    model.addAttribute("turmas", turmas);
    
    // Log para depuração (remova depois)
    System.out.println("Total de turmas: " + turmas.size());
    turmas.forEach(t -> System.out.println(
        "Turma: " + t.getDisciplina() + 
        " - Horários: " + String.join(", ", t.getHorarios())
    ));
    
    return "aluno/listagem-geral";
}

}