package com.SGE.service;

import com.SGE.exceptions.BusinessException;
import com.SGE.model.Disciplina;
import com.SGE.repository.DisciplinaRepository;
import com.SGE.exceptions.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    @Transactional
    public Disciplina salvar(Disciplina disciplina) throws BusinessException {
        if (disciplinaRepository.existsBySigla(disciplina.getSigla())) {
            throw new BusinessException("Já existe uma disciplina com esta sigla");
        }
        return disciplinaRepository.save(disciplina);
    }

    @Transactional(readOnly = true)
    public List<Disciplina> listarTodos() {
        return disciplinaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Disciplina buscarPorId(Long id) throws NotFoundException {
        return disciplinaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Disciplina não encontrada"));
    }

    @Transactional
    public void excluir(Long id) throws NotFoundException {
        if (!disciplinaRepository.existsById(id)) {
            throw new NotFoundException("Disciplina não encontrada");
        }
        disciplinaRepository.deleteById(id);
    }
    
}