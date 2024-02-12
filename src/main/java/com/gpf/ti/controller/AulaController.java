package com.gpf.ti.controller;

import com.gpf.ti.dtos.AulaDto;
import com.gpf.ti.model.Aula;
import com.gpf.ti.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cadastro")
public class AulaController {

    @Autowired
    private AulaRepository repository;

    @Transactional
    @PostMapping("/aula")
    public ResponseEntity<Aula> cadastrarAula(@RequestBody AulaDto dto) {
        Aula aula = new Aula(
                dto.getTitulo(),
                dto.getDescricao(),
                dto.getCadastro(),
                dto.getDuracao(),
                dto.getStatus(),
                dto.getCategoria()
        );

        Aula AulaCadastrada = this.repository.save(aula);

        return new ResponseEntity<>(AulaCadastrada, HttpStatus.OK);
    }
}