package com.SGE.dto;

import com.SGE.model.Disciplina;
import java.util.List;

public class TurmaDTO {
    private Long id;
    private String codigoTurma;
    private Disciplina disciplina;
    private Integer quantidadeAlunos;
    private List<String> horariosAula;  // Opcional, se tiver horários

    // Construtores
    public TurmaDTO() {
    }

    public TurmaDTO(Long id, String codigoTurma, Disciplina disciplina, Integer quantidadeAlunos) {
        this.id = id;
        this.codigoTurma = codigoTurma;
        this.disciplina = disciplina;
        this.quantidadeAlunos = quantidadeAlunos;
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

    public Integer getQuantidadeAlunos() {
        return quantidadeAlunos;
    }

    public void setQuantidadeAlunos(Integer quantidadeAlunos) {
        this.quantidadeAlunos = quantidadeAlunos;
    }

    public List<String> getHorariosAula() {
        return horariosAula;
    }

    public void setHorariosAula(List<String> horariosAula) {
        this.horariosAula = horariosAula;
    }

    // Método toString para debug
    @Override
    public String toString() {
        return "TurmaDTO{" +
                "id=" + id +
                ", codigoTurma='" + codigoTurma + '\'' +
                ", disciplina=" + (disciplina != null ? disciplina.getNomeDisciplina() : "null") +
                ", quantidadeAlunos=" + quantidadeAlunos +
                '}';
    }
}