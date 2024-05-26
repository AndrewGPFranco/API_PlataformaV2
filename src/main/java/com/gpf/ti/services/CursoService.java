package com.gpf.ti.services;

import com.gpf.ti.model.Curso;
import com.gpf.ti.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> obterCursos() {
        return this.cursoRepository.findAll();
    }
}
