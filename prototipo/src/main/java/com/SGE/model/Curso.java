package com.SGE.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nomeCurso;
    private String siglaCurso;
    private String duracaoCurso;
    private Date dataInicio;
    
    @OneToMany(mappedBy = "curso")
    private List<CursoDisciplina> disciplinas;
    
    @OneToMany(mappedBy = "curso")
    private List<CursoPeriodo> periodos;
    
    @OneToMany(mappedBy = "curso")
    private List<AlunoCurso> alunos;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getSiglaCurso() {
        return siglaCurso;
    }

    public void setSiglaCurso(String siglaCurso) {
        this.siglaCurso = siglaCurso;
    }

    public String getDuracaoCurso() {
        return duracaoCurso;
    }

    public void setDuracaoCurso(String duracaoCurso) {
        this.duracaoCurso = duracaoCurso;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public List<CursoDisciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<CursoDisciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<CursoPeriodo> getPeriodos() {
        return periodos;
    }

    public void setPeriodos(List<CursoPeriodo> periodos) {
        this.periodos = periodos;
    }

    public List<AlunoCurso> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<AlunoCurso> alunos) {
        this.alunos = alunos;
    }

    // Métodos adicionais
    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nomeCurso='" + nomeCurso + '\'' +
                ", siglaCurso='" + siglaCurso + '\'' +
                ", duracaoCurso='" + duracaoCurso + '\'' +
                ", dataInicio=" + dataInicio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return id != null && id.equals(curso.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}