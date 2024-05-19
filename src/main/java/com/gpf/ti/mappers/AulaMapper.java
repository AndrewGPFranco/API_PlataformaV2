package com.gpf.ti.mappers;

import com.gpf.ti.dtos.aula.AulaDto;
import com.gpf.ti.dtos.aula.AulaEditadaDto;
import com.gpf.ti.dtos.aula.DadosAulaDto;
import com.gpf.ti.model.Aula;

public class AulaMapper {

    public static Aula aulaDtoToAula(AulaDto value) {
        if(value == null) {
            return null;
        }
        Aula aula = new Aula(value.titulo(), value.descricao(), value.cadastro(), value.duracao(), value.imagem(), value.url(), value.tech(), value.categoria());
        return aula;
    }

    public static AulaDto aulaToAulaDto(Aula value) {
        if(value == null) {
            return null;
        }
        AulaDto aulaDto = new AulaDto(value.getTitulo(), value.getDescricao(), value.getCadastro(), value.getDuracao(), value.getImagem(), value.getUrl(), value.getTech(), value.getCategoria());
        return aulaDto;
    }

    public static DadosAulaDto aulaToDadosAulaDto (Aula value) {
        if(value == null) {
            return null;
        }
        DadosAulaDto dados = new DadosAulaDto(value.getTitulo(), value.getDescricao(), value.getCadastro(), value.getImagem(), value.getDuracao(), value.getTech(), value.getCategoria());
        return dados;
    }

    public static AulaEditadaDto aulaToAulaEditadaDto(Aula value) {
        if(value == null) {
            return null;
        }
        AulaEditadaDto aula = new AulaEditadaDto(value.getTitulo(), value.getDescricao(), value.getDuracao(), value.getImagem(), value.getUrl(), value.getTech(), value.getCategoria());
        return aula;
    }
}
