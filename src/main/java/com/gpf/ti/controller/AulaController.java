package com.gpf.ti.controller;

import com.gpf.ti.dtos.AulaDto;
import com.gpf.ti.dtos.DadosAulaDto;
import com.gpf.ti.model.Aula;
import com.gpf.ti.services.AulaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AulaController {

    private final AulaService aulaService;
    public AulaController(AulaService aulaService) {
        this.aulaService = aulaService;
    }

    @PostMapping("/cadastro/aula")
    public ResponseEntity<Map<String, Object>> cadastrarAula(@RequestBody AulaDto dto) {
        DadosAulaDto dadosAula = aulaService.cadastrarAula(dto);

        Map<String, Object> resposta = new HashMap<>();
        resposta.put("Aula cadastrada com Sucesso", dadosAula);

        return new ResponseEntity<>(resposta, HttpStatus.CREATED);
    }

    @GetMapping("/dados/aulas")
    public ResponseEntity<Map<String, Object>> obterAulas() {
        List<Aula> aulas = aulaService.obterAulas();

        Map<String, Object> resposta = new HashMap<>();
        resposta.put("Aulas Encontradas: ", aulas);

        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

}
