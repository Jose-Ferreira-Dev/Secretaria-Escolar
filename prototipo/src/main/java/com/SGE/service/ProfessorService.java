package com.sge.service;

import com.sge.model.Professor;
import com.sge.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    
    private final ProfessorRepository professorRepository;
    
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }
    
    public List<Professor> listarTodos() {
        return professorRepository.findAll();
    }
    
    public Professor salvar(Professor professor) {
        return professorRepository.save(professor);
    }
    
    public Professor obterPorId(Long id) {
        return professorRepository.findById(id).orElse(null);
    }
    
    public void excluir(Long id) {
        professorRepository.deleteById(id);
    }
}