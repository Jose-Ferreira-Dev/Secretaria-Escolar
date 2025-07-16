package com.SGE.service;

import com.SGE.model.Turma;
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
    
    public List<Turma> listarPorProfessor(Long professorId) {
    return turmaRepository.findByProfessorId(professorId); // ou equivalente via JPQL
}
    
    public List<Turma> listarPorAluno(Long alunoId) {
    return turmaRepository.findByAlunoId(alunoId); // via JPQL ou native query
}
    
    public List<Turma> buscarPorDisciplina(Long disciplinaId) {
        return turmaRepository.findByDisciplinaId(disciplinaId);
    }
}