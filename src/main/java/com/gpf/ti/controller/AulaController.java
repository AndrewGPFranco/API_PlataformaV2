package com.gpf.ti.controller;

import com.gpf.ti.dtos.AulaDto;
import com.gpf.ti.dtos.DadosAulaDto;
import com.gpf.ti.services.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cadastro")
public class AulaController {
    @Autowired
    private AulaService aulaService;

    @PostMapping("/aula")
    public ResponseEntity<DadosAulaDto> cadastrarAula(@RequestBody AulaDto dto) {
        DadosAulaDto dadosAula = aulaService.cadastrarAula(dto);
        return new ResponseEntity<>(dadosAula, HttpStatus.CREATED);
    }
}
