package com.sge.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cursos_disciplinas")
public class CursoDisciplina {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cursos_disciplinas_id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;
    
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
    
    public Curso getCurso() {
        return curso;
    }
    
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    public Disciplina getDisciplina() {
        return disciplina;
    }
    
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}