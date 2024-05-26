package com.gpf.ti.mappers;

import com.gpf.ti.dtos.aula.AulaDto;
import com.gpf.ti.dtos.aula.AulaEditadaDto;
import com.gpf.ti.dtos.aula.DadosAulaDto;
import com.gpf.ti.model.Aula;
import org.springframework.stereotype.Component;

@Component
public class AulaMapper {

    public Aula aulaDtoToAula(AulaDto value) {
        if(value == null) {
            return null;
        }
        return new Aula(value.titulo(), value.descricao(), value.cadastro(), value.duracao(), value.imagem(), value.url(), value.tech(), value.categoria(), value.curso());
    }

    public AulaDto aulaToAulaDto(Aula value) {
        if(value == null) {
            return null;
        }
        return new AulaDto(value.getTitulo(), value.getDescricao(), value.getCadastro(), value.getDuracao(), value.getImagem(), value.getUrl(), value.getTech(), value.getCategoria(), value.getCurso());
    }

    public DadosAulaDto aulaToDadosAulaDto (Aula value) {
        if(value == null) {
            return null;
        }
        return new DadosAulaDto(value.getTitulo(), value.getDescricao(), value.getCadastro(), value.getImagem(), value.getDuracao(), value.getTech(), value.getCategoria(), value.getCurso());
    }

    public AulaEditadaDto aulaToAulaEditadaDto(Aula value) {
        if(value == null) {
            return null;
        }
        return new AulaEditadaDto(value.getTitulo(), value.getDescricao(), value.getDuracao(), value.getImagem(), value.getUrl(), value.getTech(), value.getCategoria(), value.getCurso());
    }
}