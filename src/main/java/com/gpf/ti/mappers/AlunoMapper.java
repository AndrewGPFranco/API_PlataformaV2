package com.gpf.ti.mappers;

import com.gpf.ti.dtos.aluno.AlunoDto;
import com.gpf.ti.model.Aluno;

public class AlunoMapper {

    public static AlunoDto studentToAlunoDto(Aluno aluno) {
        if ( aluno == null ) {
            return null;
        }
        AlunoDto student = new AlunoDto(aluno.getNome(), aluno.getNivel(), aluno.getEmail());
        return student;
    }

    public static Aluno alunoDtoToAluno(AlunoDto aluno) {
        if ( aluno == null ) {
            return null;
        }
        Aluno student = new Aluno(aluno.nome(), aluno.nivel(), aluno.email());
        return student;
    }
}
