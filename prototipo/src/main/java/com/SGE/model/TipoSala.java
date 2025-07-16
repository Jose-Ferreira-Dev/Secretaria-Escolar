package com.SGE.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tipo_salas")
public class TipoSala {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "tipo_sala", nullable = false, length = 255)
    private String tipo;
    
    @ManyToOne
    @JoinColumn(name = "localizacao_id")
    private Area localizacao;
    
    @OneToMany(mappedBy = "tipoSala")
    private List<Sala> salas;
    
    // Construtores
    public TipoSala() {
    }
    
    public TipoSala(String tipo, Area localizacao) {
        this.tipo = tipo;
        this.localizacao = localizacao;
    }
    
    // Getters e Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public Area getLocalizacao() {
        return localizacao;
    }
    
    public void setLocalizacao(Area localizacao) {
        this.localizacao = localizacao;
    }
    
    public List<Sala> getSalas() {
        return salas;
    }
    
    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }
    
    @Override
    public String toString() {
        return "TipoSala{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", localizacao=" + localizacao +
                '}';
    }
}