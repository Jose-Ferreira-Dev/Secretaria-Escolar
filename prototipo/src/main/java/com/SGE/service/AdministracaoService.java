package com.SGE.service;

import com.SGE.exceptions.BusinessException;
import com.SGE.model.Administracao;
import com.SGE.repository.AdministracaoRepository;
import com.SGE.exceptions.NotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdministracaoService {

    private final AdministracaoRepository administracaoRepository;
    private final PasswordEncoder passwordEncoder;

    public AdministracaoService(AdministracaoRepository administracaoRepository, 
                              PasswordEncoder passwordEncoder) {
        this.administracaoRepository = administracaoRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public Administracao salvar(Administracao administracao) throws BusinessException {
        if (administracaoRepository.existsByUsername(administracao.getUsername())) {
            throw new BusinessException("Já existe um administrador com este username");
        }
        
        administracao.setSenha(passwordEncoder.encode(administracao.getSenha()));
        return administracaoRepository.save(administracao);
    }

    @Transactional(readOnly = true)
    public List<Administracao> listarTodos() {
        return administracaoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Administracao buscarPorId(Long id) throws NotFoundException {
        return administracaoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Administrador não encontrado"));
    }

    @Transactional
    public void alterarSenha(Long id, String novaSenha) throws NotFoundException {
        Administracao admin = buscarPorId(id);
        admin.setSenha(passwordEncoder.encode(novaSenha));
        administracaoRepository.save(admin);
    }

    @Transactional
    public void excluir(Long id) throws NotFoundException {
        if (!administracaoRepository.existsById(id)) {
            throw new NotFoundException("Administrador não encontrado");
        }
        administracaoRepository.deleteById(id);
    }
}