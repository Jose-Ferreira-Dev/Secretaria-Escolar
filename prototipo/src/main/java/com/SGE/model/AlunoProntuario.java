package com.SGE.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "aluno_prontuario")
public class AlunoProntuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aluno_prontuario_id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;
    
    @ManyToOne
    @JoinColumn(name = "prontuario_id", nullable = false)
    private ProntuarioAluno prontuario;
    
    @Column(name = "situacao_curso")
    private String situacaoCurso;
    
    @Column(name = "data_matricula")
    private LocalDateTime dataMatricula;
    
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
    
    public ProntuarioAluno getProntuario() {
        return prontuario;
    }
    
    public void setProntuario(ProntuarioAluno prontuario) {
        this.prontuario = prontuario;
    }
    
    public String getSituacaoCurso() {
        return situacaoCurso;
    }
    
    public void setSituacaoCurso(String situacaoCurso) {
        this.situacaoCurso = situacaoCurso;
    }
    
    public LocalDateTime getDataMatricula() {
        return dataMatricula;
    }
    
    public void setDataMatricula(LocalDateTime dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
}