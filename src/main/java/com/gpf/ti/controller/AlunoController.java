package com.gpf.ti.controller;

import com.gpf.ti.dtos.AlunoDto;
import com.gpf.ti.model.Aluno;
import com.gpf.ti.services.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {

    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Map<String, Object>> createStudent(@RequestBody AlunoDto dto) {
        AlunoDto dadosAluno = alunoService.createStudent(dto);

        Map<String, Object> resposta = new HashMap<>();
        resposta.put("Aluno cadastrado com Sucesso", dadosAluno);

        return new ResponseEntity<>(resposta, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllStudents() {
        List<Aluno> students = alunoService.getAllStudents();

        Map<String, Object> response = new HashMap<>();
        response.put("Alunos Encontrados: ", students);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
