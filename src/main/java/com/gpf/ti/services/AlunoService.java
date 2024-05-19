package com.gpf.ti.services;

import com.gpf.ti.dtos.aluno.AlunoDto;
import com.gpf.ti.mappers.AlunoMapper;
import com.gpf.ti.model.Aluno;
import com.gpf.ti.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;

    public AlunoService(AlunoRepository alunoRepository, AlunoMapper alunoMapper) {
        this.alunoRepository = alunoRepository;
        this.alunoMapper = alunoMapper;
    }

    public AlunoDto createStudent(AlunoDto dto) {
        Aluno aluno = alunoMapper.alunoDtoToAluno(dto);
        AlunoDto alunoDto = alunoMapper.studentToAlunoDto(aluno);

        alunoRepository.save(aluno);
        return alunoDto;
    }

    public List<Aluno> getAllStudents() {
        return alunoRepository.findAll();
    }

    public Aluno findByEmail(String email) {
        return alunoRepository.findByEmail(email);
    }
}
