package com.SGE.service;

import com.SGE.exceptions.BusinessException;
import com.SGE.model.Curso;
import com.SGE.repository.CursoRepository;
import com.SGE.exceptions.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Transactional
    public Curso salvar(Curso curso) throws BusinessException {
        if (cursoRepository.existsBySiglaCurso(curso.getSiglaCurso())) {
            throw new BusinessException("Já existe um curso com esta sigla");
        }
        return cursoRepository.save(curso);
    }

    @Transactional(readOnly = true)
    public List<Curso> listarTodos() {
        return cursoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Curso buscarPorId(Long id) throws NotFoundException {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Curso não encontrado"));
    }

    @Transactional
    public void excluir(Long id) throws NotFoundException {
        if (!cursoRepository.existsById(id)) {
            throw new NotFoundException("Curso não encontrado");
        }
        cursoRepository.deleteById(id);
    }
}