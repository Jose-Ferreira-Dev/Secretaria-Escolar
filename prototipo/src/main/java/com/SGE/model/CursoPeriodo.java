package com.SGE.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cursos_periodos")
public class CursoPeriodo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cursos_periodos_id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;
    
    @ManyToOne
    @JoinColumn(name = "periodo_id", nullable = false)
    private PeriodoCurso periodo;
    
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
    
    public PeriodoCurso getPeriodo() {
        return periodo;
    }
    
    public void setPeriodo(PeriodoCurso periodo) {
        this.periodo = periodo;
    }
}