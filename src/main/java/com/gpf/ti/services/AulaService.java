package com.gpf.ti.services;

import com.gpf.ti.dtos.AulaDto;
import com.gpf.ti.dtos.DadosAulaDto;
import com.gpf.ti.model.Aula;
import com.gpf.ti.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AulaService {

    @Autowired
    private AulaRepository aulaRepository;

    public DadosAulaDto cadastrarAula(AulaDto dto){
        Aula aula = new Aula(
                dto.getTitulo(),
                dto.getDescricao(),
                dto.getCadastro(),
                dto.getDuracao(),
                dto.getStatus(),
                dto.getCategoria()
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
}
