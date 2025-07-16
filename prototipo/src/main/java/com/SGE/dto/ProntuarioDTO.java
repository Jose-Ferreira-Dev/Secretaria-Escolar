package com.SGE.dto;

public record ProntuarioDTO(
    Long alunoId,
    String nomeAluno,
    String nomeCurso,
    String situacaoCurso,
    String notasAluno,
    String frequenciaAluno,
    String observacoes,
    String disciplinas,
    String turmas
) {}