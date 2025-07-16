package com.SGE.dto;

import com.SGE.model.Aluno;
import java.time.format.DateTimeFormatter;

public class AlunoDTO {
    private Long id;
    private String nomeAluno;
    private String rgAluno;
    private String cpfAluno;
    private String dataNascimentoFormatada;
    private String numeroResponsavel;
    private String enderecoAluno;

    public AlunoDTO(Aluno aluno) {
        this.id = aluno.getId();
        this.nomeAluno = aluno.getNomeAluno();
        this.rgAluno = aluno.getRgAluno();
        this.cpfAluno = aluno.getCpfAluno();
        this.numeroResponsavel = aluno.getNumeroResponsavel();
        this.enderecoAluno = aluno.getEnderecoAluno();
        
        // Conversão simplificada para LocalDate
        if (aluno.getDataNascimento() != null) {
            this.dataNascimentoFormatada = aluno.getDataNascimento()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } else {
            this.dataNascimentoFormatada = "Não informado";
        }
    }

    // Getters
    public Long getId() { return id; }
    public String getNomeAluno() { return nomeAluno; }
    public String getRgAluno() { return rgAluno; }
    public String getCpfAluno() { return cpfAluno; }
    public String getDataNascimentoFormatada() { return dataNascimentoFormatada; }
    public String getNumeroResponsavel() { return numeroResponsavel; }
    public String getEnderecoAluno() { return enderecoAluno; }
}