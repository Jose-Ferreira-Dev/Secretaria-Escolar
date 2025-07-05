package com.sge.security.auth;

import com.sge.model.Administracao;
import com.sge.model.Aluno;
import com.sge.model.Professor;
import com.sge.repository.AdministracaoRepository;
import com.sge.repository.AlunoRepository;
import com.sge.repository.ProfessorRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final LoginAttemptService loginAttemptService;
    private final AdministracaoRepository adminRepository;
    private final ProfessorRepository professorRepository;
    private final AlunoRepository alunoRepository;

    public CustomUserDetailsService(AdministracaoRepository adminRepository,
                                  ProfessorRepository professorRepository,
                                  AlunoRepository alunoRepository) {
        this.adminRepository = adminRepository;
        this.professorRepository = professorRepository;
        this.alunoRepository = alunoRepository;
        this.loginAttemptService = null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (loginAttemptService.isBlocked(username)) {
            throw new RuntimeException("IP bloqueado por excesso de tentativas");
        }
        // Tenta encontrar como admin
        Administracao admin = adminRepository.findByUsername(username);
        if (admin != null) {
            return new CustomUserDetails(admin);
        }

        // Tenta encontrar como professor (por CPF)
        Professor professor = professorRepository.findByCpfProfessor(username);
        if (professor != null) {
            return new CustomUserDetails(professor);
        }

        // Tenta encontrar como aluno (por CPF)
        Aluno aluno = alunoRepository.findByCpfAluno(username);
        if (aluno != null) {
            return new CustomUserDetails(aluno);
        }

        throw new UsernameNotFoundException("Usuário não encontrado: " + username);
    }
}