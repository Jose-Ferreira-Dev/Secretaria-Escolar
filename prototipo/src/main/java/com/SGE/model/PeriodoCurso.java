package com.SGE.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "periodo_cursos")
public class PeriodoCurso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nome_periodo", nullable = false, length = 100)
    private String nomePeriodo;
    
    @OneToMany(mappedBy = "periodo")
    private List<CursoPeriodo> cursosPeriodos;
    
    // Construtores
    public PeriodoCurso() {
    }
    
    public PeriodoCurso(String nomePeriodo) {
        this.nomePeriodo = nomePeriodo;
    }
    
    // Getters e Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNomePeriodo() {
        return nomePeriodo;
    }
    
    public void setNomePeriodo(String nomePeriodo) {
        this.nomePeriodo = nomePeriodo;
    }
    
    public List<CursoPeriodo> getCursosPeriodos() {
        return cursosPeriodos;
    }
    
    public void setCursosPeriodos(List<CursoPeriodo> cursosPeriodos) {
        this.cursosPeriodos = cursosPeriodos;
    }
    
    @Override
    public String toString() {
        return "PeriodoCurso{" +
                "id=" + id +
                ", nomePeriodo='" + nomePeriodo + '\'' +
                '}';
    }
}