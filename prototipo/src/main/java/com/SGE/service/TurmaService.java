package com.sge.service;

import com.sge.model.Turma;
import com.SGE.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {
    
    private final TurmaRepository turmaRepository;
    
    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }
    
    public List<Turma> listarTodos() {
        return turmaRepository.findAll();
    }
    
    public Turma salvar(Turma turma) {
        return turmaRepository.save(turma);
    }
    
    public Turma obterPorId(Long id) {
        return turmaRepository.findById(id).orElse(null);
    }
    
    public void excluir(Long id) {
        turmaRepository.deleteById(id);
    }
    
    public Turma buscarPorCodigo(String codigo) {
        return turmaRepository.findByCodigoTurma(codigo).orElse(null);
    }
    
    public List<Turma> buscarPorDisciplina(Long disciplinaId) {
        return turmaRepository.findByDisciplinaId(disciplinaId);
    }
}