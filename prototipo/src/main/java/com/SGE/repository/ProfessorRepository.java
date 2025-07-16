package com.SGE.repository;

import com.SGE.model.Professor;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Professor findByCpfProfessor(String cpf);
    Professor findByRgProfessor(String rg);
}
