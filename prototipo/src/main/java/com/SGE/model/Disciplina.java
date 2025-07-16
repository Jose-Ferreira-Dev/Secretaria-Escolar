package com.SGE.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "disciplinas")
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nomeDisciplina;
    private String sigla;
    private String semestres;
    private int aulasSemana;
    private int aulasTotais;
    
    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area area;
    
    @OneToMany(mappedBy = "disciplina")
    private List<ProfessorDisciplina> professoresDisciplinas;
    
    @OneToMany(mappedBy = "disciplina")
    private List<CursoDisciplina> cursosDisciplinas;
    
    @OneToMany(mappedBy = "disciplina")
    private List<Turma> turmas;

    // **Getters e Setters**

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getSemestres() {
        return semestres;
    }

    public void setSemestres(String semestres) {
        this.semestres = semestres;
    }

    public int getAulasSemana() {
        return aulasSemana;
    }

    public void setAulasSemana(int aulasSemana) {
        this.aulasSemana = aulasSemana;
    }

    public int getAulasTotais() {
        return aulasTotais;
    }

    public void setAulasTotais(int aulasTotais) {
        this.aulasTotais = aulasTotais;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public List<ProfessorDisciplina> getProfessoresDisciplinas() {
        return professoresDisciplinas;
    }

    public void setProfessoresDisciplinas(List<ProfessorDisciplina> professoresDisciplinas) {
        this.professoresDisciplinas = professoresDisciplinas;
    }

    public List<CursoDisciplina> getCursosDisciplinas() {
        return cursosDisciplinas;
    }

    public void setCursosDisciplinas(List<CursoDisciplina> cursosDisciplinas) {
        this.cursosDisciplinas = cursosDisciplinas;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    // **Métodos Adicionais (toString, equals, hashCode)**

    @Override
    public String toString() {
        return "Disciplina{" +
                "id=" + id +
                ", nomeDisciplina='" + nomeDisciplina + '\'' +
                ", sigla='" + sigla + '\'' +
                ", semestres='" + semestres + '\'' +
                ", aulasSemana=" + aulasSemana +
                ", aulasTotais=" + aulasTotais +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}