/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SGE.service;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class ProntuarioService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProntuarioService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String adicionarProntuario(
        int alunoId,
        int cursoId,
        String situacaoCurso,
        String notasAluno,
        String frequenciaAluno,
        String observacoes,
        RedirectAttributes redirectAttributes) {

    // Capturar data/hora atual da matrícula
    LocalDateTime dataMatricula = LocalDateTime.now();

    // 1. Inserir em prontuario_alunos e capturar o ID gerado
    String sqlProntuarioAlunos = """
        INSERT INTO prontuario_alunos (notas_aluno, frequencia_aluno, observacoes) 
        VALUES (?, ?, ?)
        """;

    KeyHolder keyHolder = new GeneratedKeyHolder();

    jdbcTemplate.update(connection -> {
        PreparedStatement ps = connection.prepareStatement(sqlProntuarioAlunos, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, notasAluno);
        ps.setString(2, frequenciaAluno);
        ps.setString(3, observacoes);
        return ps;
    }, keyHolder);

    int prontuarioId = keyHolder.getKey().intValue(); // ID recém-gerado

    // 2. Inserir em aluno_prontuario usando o ID capturado
    String sqlAlunoProntuario = """
        INSERT INTO aluno_prontuario (aluno_id, curso_id, prontuario_id, situacao_curso) 
        VALUES (?, ?, ?, ?)
        """;
    jdbcTemplate.update(sqlAlunoProntuario, alunoId, cursoId, prontuarioId, situacaoCurso);

    // 3. Atualizar ou inserir aluno_curso com situacaoCurso e data_matricula
    String sqlAlunoCurso = """
        INSERT INTO aluno_curso (aluno_id, curso_id, situacao_curso, data_matricula) 
        VALUES (?, ?, ?, ?)
        ON DUPLICATE KEY UPDATE 
            situacao_curso = VALUES(situacao_curso),
            data_matricula = VALUES(data_matricula)
        """;
    jdbcTemplate.update(sqlAlunoCurso, alunoId, cursoId, situacaoCurso, dataMatricula);

    redirectAttributes.addFlashAttribute("mensagem", "Prontuário adicionado com sucesso!");
    return "redirect:/professor/prontuario-alunos";
}


}