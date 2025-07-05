package com.sge.repository;

import com.sge.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Aluno findByCpfAluno(String cpf);
    Aluno findByRgAluno(String rg);
}