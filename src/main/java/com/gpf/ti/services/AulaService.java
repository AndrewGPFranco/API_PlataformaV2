package com.gpf.ti.services;

import com.gpf.ti.dtos.aula.AulaDto;
import com.gpf.ti.dtos.aula.AulaEditadaDto;
import com.gpf.ti.dtos.aula.DadosAulaDto;
import com.gpf.ti.enums.TechnologyType;
import com.gpf.ti.mappers.AulaMapper;
import com.gpf.ti.model.Aula;
import com.gpf.ti.repository.AulaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AulaService {

    private final AulaRepository aulaRepository;
    private final AulaMapper aulaMapper;

    public AulaService(AulaRepository aulaRepository, AulaMapper aulaMapper) {
        this.aulaRepository = aulaRepository;
        this.aulaMapper = aulaMapper;
    }

    public DadosAulaDto cadastrarAula(AulaDto dto){
        Aula aula = aulaMapper.aulaDtoToAula(dto);
        DadosAulaDto dadosAula = aulaMapper.aulaToDadosAulaDto(aula);

        this.aulaRepository.save(aula);
        return dadosAula;
    }

    public List<Aula> obterAulas() {
        List<Aula> aulas = this.aulaRepository.findAll();

        return aulas;
    }

    public Optional<Aula> obterAulaPorId(Long id) {
        Optional<Aula> aulaEncontrada = this.aulaRepository.findById(id);
        return aulaEncontrada;
    }

    public void deletarAula(Long id) {
        this.aulaRepository.deleteById(id);
    }

    public AulaEditadaDto editarAula(AulaDto dto, Long id) {
        Optional<Aula> aulaParaEditar = aulaRepository.findById(id);

        if(aulaParaEditar.isPresent() && dto != null) {
            Aula aulaEditada = aulaParaEditar.get();

            aulaEditada.setTitulo(dto.titulo());
            aulaEditada.setDescricao(dto.descricao());
            aulaEditada.setDuracao(dto.duracao());

            aulaRepository.save(aulaEditada);

            AulaEditadaDto aula = aulaMapper.aulaToAulaEditadaDto(aulaEditada);
            return aula;
        }

        return null;
    }

    public List<Aula> buscarAulaPorTecnologia(TechnologyType tech) {
        List<Aula> aulas = aulaRepository.aulaPorTech(tech);
        return aulas;
    }
}
