package com.SGE.repository;

import com.SGE.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TurmaRepository extends JpaRepository<Turma, Long> {

    Optional<Turma> findByCodigoTurma(String codigoTurma);

    @Query("SELECT t FROM Turma t WHERE t.disciplina.id = :disciplinaId")
    List<Turma> findByDisciplinaId(@Param("disciplinaId") Long disciplinaId);

    // Método para buscar turmas com vagas disponíveis
    @Query("SELECT t FROM Turma t WHERE SIZE(t.alunosTurmas) < 40") // assumindo 40 como limite
    List<Turma> findTurmasComVagas();

    @Query("SELECT t FROM Turma t WHERE t.professor.id = :professorId")
    List<Turma> findByProfessorId(@Param("professorId") Long professorId);

    public List<Turma> findByAlunoId(Long alunoId);
    
    // Buscar turmas por dia da semana
    List<Turma> findByDiaSemana(String diaSemana);
    
    // Buscar turmas por horário
    List<Turma> findByHoraInicioAndHoraFim(String horaInicio, String horaFim);
    
    // Buscar turmas por sala
    List<Turma> findBySalaId(Long salaId);
}

