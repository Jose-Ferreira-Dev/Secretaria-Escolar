package com.SGE.service;

import com.SGE.dto.AlunoDTO;
import com.SGE.dto.ProntuarioDTO;
import com.SGE.model.Aluno;
import com.SGE.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Service
public class AlunoService {
    
    private final AlunoRepository alunoRepository;
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public AlunoService(AlunoRepository alunoRepository, JdbcTemplate jdbcTemplate) {
        this.alunoRepository = alunoRepository;
        this.jdbcTemplate = jdbcTemplate;
    }
    
    
    // Novo método usando DTO
    public List<AlunoDTO> listarTodosAlunosDTO() {
        return alunoRepository.findAll().stream()
            .map(AlunoDTO::new)
            .collect(Collectors.toList());
    }
    
    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }
    
    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }
    
    public Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id).orElse(null);
    }
    
    public void excluir(Long id) {
        alunoRepository.deleteById(id);
    }
    
    public Aluno buscarPorCpf(String cpf) {
    return alunoRepository.findByCpfAluno(cpf).orElse(null); // Trata o Optional
}

public Aluno buscarPorRg(String rg) {
    return alunoRepository.findByRgAluno(rg).orElse(null); // Trata o Optional
}


public List<Map<String, Object>> listarProntuariosCompletos() {
    String sql = """
        SELECT 
            apr.aluno_prontuario_id as prontuario_id,
            a.id as aluno_id,
            a.nomeAluno,
            c.nomeCurso,
            SUBSTRING_INDEX(ac.situacao_curso, ' ', 1) as situacao_curso,
            pa.notas_aluno,
            pa.frequencia_aluno,
            pa.observacoes,
            (
                SELECT GROUP_CONCAT(DISTINCT d.nomeDisciplina SEPARATOR ', ')
                FROM aluno_disciplinas ad
                JOIN disciplinas d ON ad.disciplina_id = d.id
                WHERE ad.aluno_id = a.id
            ) as disciplinas,
            (
                SELECT GROUP_CONCAT(DISTINCT t.horaInicio SEPARATOR ', ')
                FROM alunos_turmas at
                JOIN turmas t ON at.turma_id = t.id
                WHERE at.aluno_id = a.id
            ) as horarios_aula
        FROM aluno_prontuario apr
        JOIN prontuario_alunos pa ON apr.prontuario_id = pa.id
        JOIN alunos a ON apr.aluno_id = a.id
        JOIN aluno_curso ac ON a.id = ac.aluno_id AND ac.curso_id = apr.curso_id
        JOIN cursos c ON ac.curso_id = c.id
        GROUP BY apr.aluno_prontuario_id, a.id, a.nomeAluno, c.nomeCurso, 
                 ac.situacao_curso, pa.notas_aluno, pa.frequencia_aluno, pa.observacoes
        ORDER BY apr.aluno_prontuario_id ASC
        """;
    
    return jdbcTemplate.queryForList(sql);
}


}