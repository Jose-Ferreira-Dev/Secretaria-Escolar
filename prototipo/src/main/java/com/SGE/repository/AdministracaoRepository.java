package com.SGE.repository;

import com.SGE.model.Administracao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministracaoRepository extends JpaRepository<Administracao, Long> {
  
    public Administracao findByUsername(String username);
    public boolean existsByUsername(String username);
}