package com.SGE.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "prontuario_alunos")
public class ProntuarioAluno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "notas_aluno", nullable = false, length = 255)
    private String notasAluno;
    
    @Column(name = "frequencia_aluno", nullable = false, length = 255)
    private String frequenciaAluno;
    
    @Column(name = "observacoes", nullable = false, length = 255)
    private String observacoes;
    
    @OneToOne
    @JoinColumn(name = "aluno_id", referencedColumnName = "id")
    private Aluno aluno;
    
    @OneToMany(mappedBy = "prontuario")
    private List<AlunoProntuario> alunosProntuarios;
    
    // Construtores
    public ProntuarioAluno() {
    }
    
    public ProntuarioAluno(String notasAluno, String frequenciaAluno, String observacoes, Aluno aluno) {
        this.notasAluno = notasAluno;
        this.frequenciaAluno = frequenciaAluno;
        this.observacoes = observacoes;
        this.aluno = aluno;
    }
    
    // Getters e Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNotasAluno() {
        return notasAluno;
    }
    
    public void setNotasAluno(String notasAluno) {
        this.notasAluno = notasAluno;
    }
    
    public String getFrequenciaAluno() {
        return frequenciaAluno;
    }
    
    public void setFrequenciaAluno(String frequenciaAluno) {
        this.frequenciaAluno = frequenciaAluno;
    }
    
    public String getObservacoes() {
        return observacoes;
    }
    
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    public Aluno getAluno() {
        return aluno;
    }
    
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public List<AlunoProntuario> getAlunosProntuarios() {
        return alunosProntuarios;
    }
    
    public void setAlunosProntuarios(List<AlunoProntuario> alunosProntuarios) {
        this.alunosProntuarios = alunosProntuarios;
    }
    
    @Override
    public String toString() {
        return "ProntuarioAluno{" +
                "id=" + id +
                ", notasAluno='" + notasAluno + '\'' +
                ", frequenciaAluno='" + frequenciaAluno + '\'' +
                ", observacoes='" + observacoes + '\'' +
                ", aluno=" + (aluno != null ? aluno.getNomeAluno() : "null") +
                '}';
    }
}