package com.SGE.repository;

import com.SGE.model.ProntuarioAluno;
import com.SGE.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface ProntuarioAlunoRepository extends JpaRepository<ProntuarioAluno, Long> {

    // Busca prontuário por aluno
    Optional<ProntuarioAluno> findByAluno(Aluno aluno);
    
    // Busca prontuário com aluno e cursos (carregamento eager)
    @Query("SELECT pa FROM ProntuarioAluno pa JOIN FETCH pa.aluno a LEFT JOIN FETCH a.cursos WHERE pa.id = :id")
    Optional<ProntuarioAluno> findByIdWithAlunoAndCursos(@Param("id") Long id);
    
    // Lista todos os prontuários com alunos e cursos
    @Query("SELECT pa FROM ProntuarioAluno pa JOIN FETCH pa.aluno a LEFT JOIN FETCH a.cursos")
    List<ProntuarioAluno> findAllWithAlunoAndCursos();
    
    // Busca prontuários por parte do nome do aluno
    @Query("SELECT pa FROM ProntuarioAluno pa JOIN pa.aluno a WHERE LOWER(a.nomeAluno) LIKE LOWER(concat('%', :nome, '%'))")
    List<ProntuarioAluno> findByAlunoNomeContaining(@Param("nome") String nome);
    
    // Busca prontuários por situação de curso
    @Query("SELECT DISTINCT pa FROM ProntuarioAluno pa JOIN pa.aluno a JOIN a.cursos ac WHERE ac.situacaoCurso = :situacao")
    List<ProntuarioAluno> findBySituacaoCurso(@Param("situacao") String situacao);
        
}
