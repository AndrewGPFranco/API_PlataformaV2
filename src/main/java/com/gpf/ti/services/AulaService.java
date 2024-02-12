package com.gpf.ti.services;

import com.gpf.ti.dtos.AulaDto;
import com.gpf.ti.dtos.DadosAulaDto;
import com.gpf.ti.model.Aula;
import com.gpf.ti.repository.AulaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaService {

    private final AulaRepository aulaRepository;

    public AulaService(AulaRepository aulaRepository) {
        this.aulaRepository = aulaRepository;
    }

    public DadosAulaDto cadastrarAula(AulaDto dto){
        Aula aula = new Aula(
                dto.titulo(),
                dto.descricao(),
                dto.cadastro(),
                dto.duracao(),
                dto.status(),
                dto.categoria()
        );

        DadosAulaDto dadosAula = new DadosAulaDto(
                aula.getTitulo(),
                aula.getDescricao(),
                aula.getCadastro(),
                aula.getDuracao(),
                aula.getCategoria()
        );

        this.aulaRepository.save(aula);

        return dadosAula;
    }

    public List<Aula> obterAulas() {
        List<Aula> aulas = this.aulaRepository.findAll();
        return aulas;
    }
}
