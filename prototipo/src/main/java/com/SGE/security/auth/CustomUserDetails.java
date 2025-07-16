package com.SGE.security.auth;

import com.SGE.model.Administracao;
import com.SGE.model.Aluno;
import com.SGE.model.Professor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final String username;
    private final String password;
    private final String role;
    private final Long userId;

    public CustomUserDetails(Administracao admin) {
        this.username = admin.getUsername();
        this.password = admin.getSenha();
        this.role = "ROLE_ADMIN";
        this.userId = admin.getId();
    }

    public CustomUserDetails(Professor professor) {
        this.username = professor.getCpfProfessor();
        this.password = professor.getCpfProfessor(); // Senha inicial = CPF
        this.role = "ROLE_PROFESSOR";
        this.userId = professor.getId();
    }

    public CustomUserDetails(Aluno aluno) {
        this.username = aluno.getCpfAluno();
        this.password = aluno.getCpfAluno(); // Senha inicial = CPF
        this.role = "ROLE_ALUNO";
        this.userId = aluno.getId();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getUserId() {
        return userId;
    }

    public String getRole() {
        return role;
    }
}