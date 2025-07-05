package com.sge.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "turmas")
public class Turma {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "codigo_turma", nullable = false, length = 4)
    private String codigoTurma;
    
    @ManyToOne
    @JoinColumn(name = "disciplina_id", nullable = false)
    private Disciplina disciplina;
    
    @OneToMany(mappedBy = "turma")
    private List<AlunoTurma> alunosTurmas;
    
    @OneToMany(mappedBy = "turma")
    private List<ProfessorTurma> professoresTurmas;
    
    @OneToMany(mappedBy = "turma")
    private List<SalaTurma> salasTurmas;
    
    // Construtores
    public Turma() {
    }
    
    public Turma(String codigoTurma, Disciplina disciplina) {
        this.codigoTurma = codigoTurma;
        this.disciplina = disciplina;
    }
    
    // Getters e Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCodigoTurma() {
        return codigoTurma;
    }
    
    public void setCodigoTurma(String codigoTurma) {
        this.codigoTurma = codigoTurma;
    }
    
    public Disciplina getDisciplina() {
        return disciplina;
    }
    
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    public List<AlunoTurma> getAlunosTurmas() {
        return alunosTurmas;
    }
    
    public void setAlunosTurmas(List<AlunoTurma> alunosTurmas) {
        this.alunosTurmas = alunosTurmas;
    }
    
    public List<ProfessorTurma> getProfessoresTurmas() {
        return professoresTurmas;
    }
    
    public void setProfessoresTurmas(List<ProfessorTurma> professoresTurmas) {
        this.professoresTurmas = professoresTurmas;
    }
    
    public List<SalaTurma> getSalasTurmas() {
        return salasTurmas;
    }
    
    public void setSalasTurmas(List<SalaTurma> salasTurmas) {
        this.salasTurmas = salasTurmas;
    }
    
    // Método toString
    @Override
    public String toString() {
        return "Turma{" +
                "id=" + id +
                ", codigoTurma='" + codigoTurma + '\'' +
                ", disciplina=" + disciplina +
                '}';
    }
}