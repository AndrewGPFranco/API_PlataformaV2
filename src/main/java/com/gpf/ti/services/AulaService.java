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
        return this.aulaRepository.findAll();
    }

    public Optional<Aula> obterAulaPorId(Long id) {
        Optional<Aula> aula = this.aulaRepository.findById(id);
        if(aula != null) {
            Integer contagem = aula.get().getVisualizacoes();
            Integer novaVisualizacao = contagem + 1;
            aulaRepository.atualizarContagemDeVisualizacoes(novaVisualizacao, aula.get().getId());
        }
        return aula;
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
            aulaEditada.setCadastro(dto.cadastro());
            aulaEditada.setDuracao(dto.duracao());
            aulaEditada.setImagem(dto.imagem());
            aulaEditada.setUrl(dto.url());
            aulaEditada.setTech(dto.tech());
            aulaEditada.setCategoria(dto.categoria());
            aulaEditada.setCurso(dto.curso());

            aulaRepository.save(aulaEditada);

            return aulaMapper.aulaToAulaEditadaDto(aulaEditada);
        }

        return null;
    }

    public List<Aula> buscarAulaPorTecnologia(TechnologyType tech) {
        return aulaRepository.aulaPorTech(tech);
    }
}
