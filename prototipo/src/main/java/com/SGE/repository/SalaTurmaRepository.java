package com.SGE.repository;

import com.SGE.model.SalaTurma;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaTurmaRepository extends JpaRepository<SalaTurma, Long> {
    
   List<SalaTurma> findBySalaId(Long salaId);
     List<SalaTurma> findByTurmaId(Long turmaId);
     List<SalaTurma> findByDiaSemana(String diaSemana);
}