package com.SGE.repository;

import com.SGE.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.query.Param;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    
    // Busca por sigla (unique)
    Optional<Curso> findBySiglaCurso(String siglaCurso);
    
    // Verifica se sigla já existe
    boolean existsBySiglaCurso(String siglaCurso);
    
    // Busca cursos por nome (like)
    List<Curso> findByNomeCursoContainingIgnoreCase(String nome);
    
    // Busca cursos ativos
    @Query("SELECT c FROM Curso c WHERE c.dataInicio <= CURRENT_DATE")
    List<Curso> findCursosAtivos();
    
    // Busca cursos disponíveis para matrícula
    @Query("SELECT c FROM Curso c WHERE c.dataInicio <= CURRENT_DATE AND " +
           "NOT EXISTS (SELECT ac FROM AlunoCurso ac WHERE ac.curso = c AND ac.aluno.id = :alunoId)")
    List<Curso> findCursosDisponiveisParaAluno(@Param("alunoId") Long alunoId);
    
    // Busca cursos por área
    @Query("SELECT c FROM Curso c JOIN c.disciplinas cd JOIN cd.disciplina d WHERE d.area.id = :areaId")
    List<Curso> findByAreaId(@Param("areaId") Long areaId);
    
    // Busca cursos que começam em um determinado período
    @Query("SELECT c FROM Curso c WHERE YEAR(c.dataInicio) = :ano AND MONTH(c.dataInicio) = :mes")
    List<Curso> findByPeriodoInicio(@Param("ano") int ano, @Param("mes") int mes);
}