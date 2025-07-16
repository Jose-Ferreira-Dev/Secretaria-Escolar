package com.SGE.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "turmas")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_turma", nullable = false, length = 4)
    private String codigoTurma;
    
    @Column(name = "diaSemana", length = 20)
    private String diaSemana;

    @Column(name = "horaInicio", length = 10)
    private String horaInicio;

    @Column(name = "horaFim", length = 10)
    private String horaFim;

    @ManyToOne
    @JoinColumn(name = "disciplina_id", nullable = false)
    private Disciplina disciplina;
    
    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Sala sala;

    @OneToMany(mappedBy = "turma")
    private List<AlunoTurma> alunosTurmas;

    @OneToMany(mappedBy = "turma")
    private List<ProfessorTurma> professoresTurmas;

    @OneToMany(mappedBy = "turma")
    private List<SalaTurma> salasTurmas;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
    

    // Construtores
    public Turma() {
    }

    public Turma(String codigoTurma, Disciplina disciplina) {
        this.codigoTurma = codigoTurma;
        this.disciplina = disciplina;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoTurma() {
        return codigoTurma;
    }

    public void setCodigoTurma(String codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public List<AlunoTurma> getAlunosTurmas() {
        return alunosTurmas;
    }

    public void setAlunosTurmas(List<AlunoTurma> alunosTurmas) {
        this.alunosTurmas = alunosTurmas;
    }

    public List<ProfessorTurma> getProfessoresTurmas() {
        return professoresTurmas;
    }

    public void setProfessoresTurmas(List<ProfessorTurma> professoresTurmas) {
        this.professoresTurmas = professoresTurmas;
    }

    public List<SalaTurma> getSalasTurmas() {
        return salasTurmas;
    }

    public void setSalasTurmas(List<SalaTurma> salasTurmas) {
        this.salasTurmas = salasTurmas;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
    
    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    // Método toString
    @Override
    public String toString() {
        return "Turma{"
                + "id=" + id
                + ", codigoTurma='" + codigoTurma + '\''
                + ", disciplina=" + disciplina
                + '}';
    }
}
