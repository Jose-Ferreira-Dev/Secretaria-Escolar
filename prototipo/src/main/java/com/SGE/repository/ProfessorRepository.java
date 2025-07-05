package com.sge.repository;

import com.sge.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Professor findByCpfProfessor(String cpf);
    Professor findByRgProfessor(String rg);
}