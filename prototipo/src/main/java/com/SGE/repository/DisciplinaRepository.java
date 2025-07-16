package com.SGE.repository;

import com.SGE.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    
    // Busca por sigla (unique)
    Optional<Disciplina> findBySigla(String sigla);
    
    // Verifica se sigla já existe
    boolean existsBySigla(String sigla);
    
    // Busca disciplinas por área
    @Query("SELECT d FROM Disciplina d WHERE d.area.id = :areaId")
    List<Disciplina> findByAreaId(@Param("areaId") Long areaId);
    
    // Busca disciplinas por nome (like)
    List<Disciplina> findByNomeDisciplinaContainingIgnoreCase(String nome);

}