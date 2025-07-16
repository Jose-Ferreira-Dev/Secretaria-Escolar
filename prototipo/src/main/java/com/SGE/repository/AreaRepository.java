package com.SGE.repository;

import com.SGE.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AreaRepository extends JpaRepository<Area, Long> {
    
    
    // Busca por termo no nome
    List<Area> findByNomeAreaContainingIgnoreCase(String termo);
}