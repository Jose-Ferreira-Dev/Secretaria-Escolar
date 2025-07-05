package com.sge.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rematricula")
public class Rematricula {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;
    
    @Column(name = "status_rematricula", nullable = false, length = 3)
    private String statusRematricula; // "sim" ou "não"
    
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
    
    public String getStatusRematricula() {
        return statusRematricula;
    }
    
    public void setStatusRematricula(String statusRematricula) {
        this.statusRematricula = statusRematricula;
    }
    
    // Método utilitário
    public boolean isRematriculado() {
        return "sim".equalsIgnoreCase(statusRematricula);
    }
}