package com.sge.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "professores")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nomeProfessor;
    private String rgProfessor;
    private String cpfProfessor;
    private String numeroTelefone;
    private String emailProfessor;
    private String enderecoProfessor;
    
    @OneToMany(mappedBy = "professor")
    private List<ProfessorDisciplina> disciplinas;
    
    @OneToMany(mappedBy = "professor")
    private List<ProfessorTurma> turmas;

    // **Getters e Setters**

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getRgProfessor() {
        return rgProfessor;
    }

    public void setRgProfessor(String rgProfessor) {
        this.rgProfessor = rgProfessor;
    }

    public String getCpfProfessor() {
        return cpfProfessor;
    }

    public void setCpfProfessor(String cpfProfessor) {
        this.cpfProfessor = cpfProfessor;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getEmailProfessor() {
        return emailProfessor;
    }

    public void setEmailProfessor(String emailProfessor) {
        this.emailProfessor = emailProfessor;
    }

    public String getEnderecoProfessor() {
        return enderecoProfessor;
    }

    public void setEnderecoProfessor(String enderecoProfessor) {
        this.enderecoProfessor = enderecoProfessor;
    }

    public List<ProfessorDisciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<ProfessorDisciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<ProfessorTurma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<ProfessorTurma> turmas) {
        this.turmas = turmas;
    }

    // **Métodos Adicionais (toString, equals, hashCode)**

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", nomeProfessor='" + nomeProfessor + '\'' +
                ", rgProfessor='" + rgProfessor + '\'' +
                ", cpfProfessor='" + cpfProfessor + '\'' +
                ", numeroTelefone='" + numeroTelefone + '\'' +
                ", emailProfessor='" + emailProfessor + '\'' +
                ", enderecoProfessor='" + enderecoProfessor + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return id != null && id.equals(professor.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}