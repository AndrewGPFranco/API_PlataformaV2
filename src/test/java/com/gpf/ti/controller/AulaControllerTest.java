package com.gpf.ti.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gpf.ti.dtos.aula.AulaDto;
import com.gpf.ti.model.Aula;
import com.gpf.ti.services.AulaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AulaControllerTest {

    MockMvc mvc;

    @Mock
    AulaService aulaService;

    @Spy
    @InjectMocks
    AulaController controller;

    ObjectMapper objMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
        objMapper = new ObjectMapper();
    }

    @Test
    public void testeObterAulasRetornoIsOk() throws Exception {

        Aula aula01 = new Aula(1L, "Como fazer testes no Spring");
        Aula aula02 = new Aula(2L, "Como fazer testes no Spring");

        List<Aula> aulas = new ArrayList<>();
        aulas.add(aula01);
        aulas.add(aula02);

        Mockito.when(aulaService.obterAulas()).thenReturn(aulas);

        mvc.perform(MockMvcRequestBuilders.get("/api/dados/aulas")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testeObterAulasVaziaOuNull() throws Exception {
        List<Aula> aulas = new ArrayList<>();
        Mockito.when(aulaService.obterAulas()).thenReturn(aulas);

        mvc.perform(MockMvcRequestBuilders.get("/api/dados/aulas")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void testeCadastrarAula() throws Exception {
        AulaDto aula = new AulaDto(
                "titulo",
                "descrição",
                new Date(),
                10,
                "urlImagem",
                "url",
                true,
                "vue",
                "frontend"
        );

        String bodyJson = objMapper.writer().writeValueAsString(aula);

        mvc.perform(MockMvcRequestBuilders.post("/api/cadastro/aula")
                .contentType(MediaType.APPLICATION_JSON)
                .content(bodyJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated());
     }
}