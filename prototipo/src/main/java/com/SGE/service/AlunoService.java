package com.sge.service;

import com.sge.model.Aluno;
import com.sge.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    
    private final AlunoRepository alunoRepository;
    
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }
    
    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }
    
    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }
    
    public Aluno obterPorId(Long id) {
        return alunoRepository.findById(id).orElse(null);
    }
    
    public void excluir(Long id) {
        alunoRepository.deleteById(id);
    }
    
    public Aluno buscarPorCpf(String cpf) {
        return alunoRepository.findByCpfAluno(cpf).orElse(null);
    }
    
    public Aluno buscarPorRg(String rg) {
        return alunoRepository.findByRgAluno(rg).orElse(null);
    }
}