package com.SGE.model;

import jakarta.persistence.*;

@Entity
@Table(name = "salas_turmas")
public class SalaTurma {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salas_turmas_id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "sala_id", nullable = false)
    private Sala sala;
    
    @ManyToOne
    @JoinColumn(name = "turma_id", nullable = false)
    private Turma turma;
    
     private String diaSemana;
    private String horaInicio;
    private String horaFim;
    
    // Getters e Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Sala getSala() {
        return sala;
    }
    
    public void setSala(Sala sala) {
        this.sala = sala;
    }
    
    public Turma getTurma() {
        return turma;
    }
    
    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getDiaSemana() {
return diaSemana;
    }
    
public void setDiaSemana(String DiaSemana) {
        this.diaSemana = diaSemana;
    }
    
    public String getHoraInicio() {
return horaInicio;
    }

    public String getHoraFim() {
return horaFim;
    }
}