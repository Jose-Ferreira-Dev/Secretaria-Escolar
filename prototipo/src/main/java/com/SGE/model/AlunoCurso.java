package com.SGE.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "aluno_curso")
public class AlunoCurso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aluno_curso_id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;
    
    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;
    
    @Column(name = "data_matricula")
    private LocalDateTime dataMatricula;
    
    @Column(name = "situacao_curso")
    private String situacaoCurso;
    
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
    
    public Curso getCurso() {
        return curso;
    }
    
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    public LocalDateTime getDataMatricula() {
        return dataMatricula;
    }
    
    public void setDataMatricula(LocalDateTime dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
    
    public String getSituacaoCurso() {
        return situacaoCurso;
    }
    
    public void setSituacaoCurso(String situacaoCurso) {
        this.situacaoCurso = situacaoCurso;
    }
}