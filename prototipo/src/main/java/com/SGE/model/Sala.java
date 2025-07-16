package com.SGE.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "salas")
public class Sala {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "numero_sala", nullable = false)
    private Integer numeroSala;
    
    @ManyToOne
    @JoinColumn(name = "tipo_sala_id", nullable = false)
    private TipoSala tipoSala;
    
    @OneToMany(mappedBy = "sala")
    private List<SalaTurma> salasTurmas;
    
    // Construtores
    public Sala() {
    }
    
    public Sala(Integer numeroSala, TipoSala tipoSala) {
        this.numeroSala = numeroSala;
        this.tipoSala = tipoSala;
    }
    
    // Getters e Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Integer getNumeroSala() {
        return numeroSala;
    }
    
    public void setNumeroSala(Integer numeroSala) {
        this.numeroSala = numeroSala;
    }
    
    public TipoSala getTipoSala() {
        return tipoSala;
    }
    
    public void setTipoSala(TipoSala tipoSala) {
        this.tipoSala = tipoSala;
    }
    
    public List<SalaTurma> getSalasTurmas() {
        return salasTurmas;
    }
    
    public void setSalasTurmas(List<SalaTurma> salasTurmas) {
        this.salasTurmas = salasTurmas;
    }
    
    @Override
    public String toString() {
        return "Sala{" +
                "id=" + id +
                ", numeroSala=" + numeroSala +
                ", tipoSala=" + tipoSala +
                '}';
    }
}