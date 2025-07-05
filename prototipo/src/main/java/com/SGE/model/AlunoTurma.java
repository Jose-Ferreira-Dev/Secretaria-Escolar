package com.sge.model;

import jakarta.persistence.*;

@Entity
@Table(name = "alunos_turmas")
public class AlunoTurma {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alunos_turmas_id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;
    
    @ManyToOne
    @JoinColumn(name = "turma_id", nullable = false)
    private Turma turma;
    
    // Getters e Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Aluno getAluno() {
        return aluno;
    }
    
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public Turma getTurma() {
        return turma;
    }
    
    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}