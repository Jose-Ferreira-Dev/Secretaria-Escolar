package com.SGE.repository;

import com.SGE.model.AlunoTurma;
import com.SGE.model.Turma;
import com.SGE.model.Aluno;
import com.SGE.model.AlunoProntuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface AlunoTurmaRepository extends JpaRepository<AlunoTurma, Long> {

    // Busca todas as matrículas de um aluno
    List<AlunoTurma> findByAluno(Aluno aluno);
    
    // Busca todas as matrículas de uma turma
    List<AlunoTurma> findByTurma(Turma turma);
    
    // Busca matrícula específica de um aluno em uma turma
    AlunoTurma findByAlunoAndTurma(Aluno aluno, Turma turma);
    
    // Conta quantos alunos estão em uma turma
    @Query("SELECT COUNT(at) FROM AlunoTurma at WHERE at.turma.id = :turmaId")
    long countByTurmaId(@Param("turmaId") Long turmaId);
    
    // Verifica se um aluno está matriculado em uma turma
    boolean existsByAlunoAndTurma(Aluno aluno, Turma turma);
    
    // Busca todas as turmas de um aluno
    @Query("SELECT at.turma FROM AlunoTurma at WHERE at.aluno.id = :alunoId")
    List<Turma> findTurmasByAlunoId(@Param("alunoId") Long alunoId);
    
    // Busca todos os alunos de uma turma
    @Query("SELECT at.aluno FROM AlunoTurma at WHERE at.turma.id = :turmaId")
    List<Aluno> findAlunosByTurmaId(@Param("turmaId") Long turmaId);
    
    // Busca matrículas por ID da turma
    List<AlunoTurma> findByTurmaId(Long turmaId);
    
    // Busca matrículas por ID do aluno
    List<AlunoTurma> findByAlunoId(Long alunoId);

    public void save(AlunoProntuario prontuario);
}