package com.SGE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nomeAluno;
    private String rgAluno;
    private String cpfAluno;
    private LocalDate dataNascimento;
    private String numeroResponsavel;
    private String enderecoAluno;
    
    @OneToMany(mappedBy = "aluno")
    private List<AlunoCurso> cursos;
    
    @OneToMany(mappedBy = "aluno")
    private List<AlunoProntuario> prontuarios;
    
    @OneToMany(mappedBy = "aluno")
    private List<AlunoDisciplina> disciplinas;
    
    @OneToMany(mappedBy = "aluno")
    private List<AlunoTurma> turmas;
    
    @OneToOne(mappedBy = "aluno")
    private Rematricula rematricula;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getRgAluno() {
        return rgAluno;
    }

    public void setRgAluno(String rgAluno) {
        this.rgAluno = rgAluno;
    }

    public String getCpfAluno() {
        return cpfAluno;
    }

    public void setCpfAluno(String cpfAluno) {
        this.cpfAluno = cpfAluno;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNumeroResponsavel() {
        return numeroResponsavel;
    }

    public void setNumeroResponsavel(String numeroResponsavel) {
        this.numeroResponsavel = numeroResponsavel;
    }

    public String getEnderecoAluno() {
        return enderecoAluno;
    }

    public void setEnderecoAluno(String enderecoAluno) {
        this.enderecoAluno = enderecoAluno;
    }

    public List<AlunoCurso> getCursos() {
        return cursos;
    }

    public void setCursos(List<AlunoCurso> cursos) {
        this.cursos = cursos;
    }

    public List<AlunoProntuario> getProntuarios() {
        return prontuarios;
    }

    public void setProntuarios(List<AlunoProntuario> prontuarios) {
        this.prontuarios = prontuarios;
    }

    public List<AlunoDisciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<AlunoDisciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<AlunoTurma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<AlunoTurma> turmas) {
        this.turmas = turmas;
    }

    public Rematricula getRematricula() {
        return rematricula;
    }

    public void setRematricula(Rematricula rematricula) {
        this.rematricula = rematricula;
    }

    // Métodos adicionais
    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nomeAluno='" + nomeAluno + '\'' +
                ", rgAluno='" + rgAluno + '\'' +
                ", cpfAluno='" + cpfAluno + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", numeroResponsavel='" + numeroResponsavel + '\'' +
                ", enderecoAluno='" + enderecoAluno + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return id.equals(aluno.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}