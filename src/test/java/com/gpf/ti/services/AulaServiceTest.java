package com.gpf.ti.services;

import com.gpf.ti.enums.CategoryType;
import com.gpf.ti.enums.TechnologyType;
import com.gpf.ti.model.Aula;
import com.gpf.ti.repository.AulaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.when;

class AulaServiceTest {

    @Mock
    private AulaRepository aulaRepository;

    @InjectMocks
    private AulaService aulaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testeObterAulaPorId() {
        Long id = 21L;

        Aula aula = new Aula(
                "Utilizando testes",
                "Descrição",
                new Date(),
                10,
                "https://e1.pxfuel.com/desktop-wallpaper/458/360/desktop-wallpaper-nuxt-js-vuejs.jpg",
                "https://www.youtube.com/embed/3dJnfvvX2ag?si=Y_AeDeVBLnmYdQEk",
                TechnologyType.JAVA,
                CategoryType.BACKEND
        );

        when(aulaRepository.findById(id)).thenReturn(Optional.of(aula));

        Optional<Aula> result = aulaService.obterAulaPorId(id);

        assertEquals(Optional.of(aula), result);
    }

    @Test
    public void testeObterAulas() {
        List<Aula> listaAulas = new ArrayList<>();

        when(aulaRepository.findAll()).thenReturn(listaAulas);

        List<Aula> result = aulaService.obterAulas();

        assertIterableEquals(listaAulas, result);
    }
}
