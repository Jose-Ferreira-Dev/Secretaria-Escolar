package com.sge.repository;

import com.sge.model.Administracao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministracaoRepository extends JpaRepository<Administracao, Long> {
    Administracao findByUsername(String username);
}