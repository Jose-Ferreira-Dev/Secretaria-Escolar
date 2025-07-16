package com.SGE.repository;

import com.SGE.model.Aluno;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findByCpfAluno(String cpf);  // Usando Optional para evitar NullPointerException
    Optional<Aluno> findByRgAluno(String rg);    // Usando Optional

}