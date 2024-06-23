package com.gpf.ti.controller;

import com.gpf.ti.dtos.aula.AulaDto;
import com.gpf.ti.dtos.aula.AulaEditadaDto;
import com.gpf.ti.dtos.aula.DadosAulaDto;
import com.gpf.ti.enums.TechnologyType;
import com.gpf.ti.exception.AulaNotFoundException;
import com.gpf.ti.model.Aula;
import com.gpf.ti.services.AulaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AulaController {

    private final AulaService aulaService;
    public AulaController(AulaService aulaService) {
        this.aulaService = aulaService;
    }

    @PostMapping("/cadastro/aula")
    public ResponseEntity<Map<String, Object>> cadastrarAula(@RequestBody @Valid AulaDto dto) {
        DadosAulaDto dadosAula = aulaService.cadastrarAula(dto);

        Map<String, Object> resposta = new HashMap<>();
        resposta.put("Aula cadastrada com Sucesso", dadosAula);

        return new ResponseEntity<>(resposta, HttpStatus.CREATED);
    }

    @GetMapping("/dados/aulas")
    public ResponseEntity<Map<String, Object>> obterAulas() {
        List<Aula> aulas = aulaService.obterAulas();

        if(aulas.isEmpty()) {
            Map<String, Object> response = new HashMap<>();
            response.put("Aviso:", "Não foi encontrado aulas no sistema!");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        Map<String, Object> resposta = new HashMap<>();
        resposta.put("Aulas Encontradas: ", aulas);

        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    @GetMapping("/dados/aula/{id}")
    public ResponseEntity<Map<String, Object>> obterAulaPeloId(@PathVariable Long id) {
        try {
            Optional<Aula> aula = aulaService.obterAulaPorId(id);

            if (aula.isEmpty()) {
                throw new AulaNotFoundException(id);
            }

            Map<String, Object> response = new HashMap<>();
            response.put("Aula Encontrada:", aula);

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (AulaNotFoundException e) {
            Map<String, Object> corpoErro = new HashMap<>();
            corpoErro.put("Erro", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(corpoErro);
        }
    }

    @DeleteMapping("/dados/aula/{id}")
    public ResponseEntity<Map<String, Object>> deletarAulaPeloId(@PathVariable Long id) {
        try {
            Optional<Aula> aula = aulaService.obterAulaPorId(id);

            if(aula.isEmpty()) {
                throw new AulaNotFoundException(id);
            }

            this.aulaService.deletarAula(id);

            Map<String, Object> response = new HashMap<>();
            response.put("Mensagem:", "Aula excluida com sucesso!");

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (AulaNotFoundException e) {
            Map<String, Object> corpoErro = new HashMap<>();
            corpoErro.put("Erro", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(corpoErro);
        }
    }

    @PutMapping("/dados/atualizar/{id}")
    public ResponseEntity<Map<String, Object>> atualizarAula(@PathVariable Long id, @RequestBody AulaDto dto) {
        try {
            Optional<Aula> aula = aulaService.obterAulaPorId(id);

            if(aula.isEmpty()) {
                throw new AulaNotFoundException(id);
            }

            AulaEditadaDto aulaAtualizada = aulaService.editarAula(dto, id);

            Map<String, Object> response = new HashMap<>();
            response.put("Aula atualizada!", aulaAtualizada);

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (AulaNotFoundException e) {
            Map<String, Object> corpoErro = new HashMap<>();
            corpoErro.put("Erro", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(corpoErro);
        }
    }

    @GetMapping("/aulas/tecnologia/{tech}")
    public List<Aula> buscarAulaPorTecnologia(@PathVariable TechnologyType tech) {
        return aulaService.buscarAulaPorTecnologia(tech);
    }

    @GetMapping("/aulas/maisvistas")
    public List<Aula> aulasMaisVistas(@RequestParam int limite) {
        return aulaService.videosMaisAssistidos(limite);
    }
}
