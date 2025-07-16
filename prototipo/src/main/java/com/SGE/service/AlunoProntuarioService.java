/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SGE.service;

import com.SGE.model.AlunoCurso;
import com.SGE.model.AlunoProntuario;
import com.SGE.repository.AlunoTurmaRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoProntuarioService {

    @Autowired
    private AlunoTurmaRepository alunoTurmaRepository;

    public void registrarSituacaoCurso(AlunoCurso alunoCurso) {
        AlunoProntuario prontuario = new AlunoProntuario();

        prontuario.setAluno(alunoCurso.getAluno());
        prontuario.setSituacaoCurso("Aluno matriculado no curso " + alunoCurso.getCurso().getNomeCurso()
            + " com a situação: " + alunoCurso.getSituacaoCurso());
        prontuario.setDataMatricula(LocalDateTime.now());

        alunoTurmaRepository.save(prontuario);
    }
}
