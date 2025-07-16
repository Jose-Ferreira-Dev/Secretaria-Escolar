package com.SGE.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "aluno_disciplinas")
public class AlunoDisciplina {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aluno_disciplinas_id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;
    
    @ManyToOne
    @JoinColumn(name = "disciplina_id", nullable = false)
    private Disciplina disciplina;
    
    @Column(name = "data_matricula", nullable = false)
    private LocalDateTime dataMatricula;
    
    @Column(name = "situacao_dp", nullable = false)
    private String situacaoDP;
    
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
    
    public Disciplina getDisciplina() {
        return disciplina;
    }
    
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    public LocalDateTime getDataMatricula() {
        return dataMatricula;
    }
    
    public void setDataMatricula(LocalDateTime dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
    
    public String getSituacaoDP() {
        return situacaoDP;
    }
    
    public void setSituacaoDP(String situacaoDP) {
        this.situacaoDP = situacaoDP;
    }
}