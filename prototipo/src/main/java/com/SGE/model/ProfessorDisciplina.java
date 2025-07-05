package com.sge.model;

import jakarta.persistence.*;

@Entity
@Table(name = "professores_disciplinas")
public class ProfessorDisciplina {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professores_disciplinas_id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;
    
    @ManyToOne
    @JoinColumn(name = "disciplina_id", nullable = false)
    private Disciplina disciplina;
    
    // Getters e Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Professor getProfessor() {
        return professor;
    }
    
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    public Disciplina getDisciplina() {
        return disciplina;
    }
    
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}