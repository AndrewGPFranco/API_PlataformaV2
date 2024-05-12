package com.gpf.ti.services;

import com.gpf.ti.dtos.AlunoDto;
import com.gpf.ti.model.Aluno;
import com.gpf.ti.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public AlunoDto createStudent(AlunoDto dto) {
        Aluno aluno = new Aluno(dto.nome(), dto.nivel(), dto.email());
        AlunoDto alunoDto = new AlunoDto(aluno.getNome(), aluno.getNivel(), aluno.getEmail());

        alunoRepository.save(aluno);

        return alunoDto;
    }

    public List<Aluno> getAllStudents() {
        return alunoRepository.findAll();
    }
}
