package edu.unimagdalena.modelo_relacional.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import edu.unimagdalena.modelo_relacional.AbstractIntegrationDBTest;
import edu.unimagdalena.modelo_relacional.entidades.Sugerencia;
import edu.unimagdalena.modelo_relacional.entidades.Usuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SugerenciaRepositoryTest extends AbstractIntegrationDBTest{
    SugerenciaRepository sugerenciaRepository;

    @Autowired
    public SugerenciaRepositoryTest(SugerenciaRepository sugerenciaRepository) {
        this.sugerenciaRepository = sugerenciaRepository;
    }

    void initMockSugerencias(){
        Sugerencia sugerencia = Sugerencia.builder()
                .descripcion("es una descripcion")
                .build();
        sugerenciaRepository.save(sugerencia);

        Sugerencia sugerencia1 = Sugerencia.builder()
        
                .descripcion("El sol salio de mañana")
                .build();
        sugerenciaRepository.save(sugerencia1);
        sugerenciaRepository.flush();
    }

    @BeforeEach
    void setUp() {
        sugerenciaRepository.deleteAll();
    }

    @Test
    void givenAnSugerencia_whenSave_thenSugerenciawithId(){
        //given
        Sugerencia sugerencia = Sugerencia.builder()
                .descripcion("es una descripcion")
                .build();
        sugerenciaRepository.save(sugerencia);
        //when
        Sugerencia sugerenciaSaved = sugerenciaRepository.save(sugerencia);
        //then
        assertThat(sugerenciaSaved.getId()).isNotNull();
    }

    @Test
    void givenAnSuggestion_whenGetReferenceById_thenGetSuggestionWithId(){
        //given
        Sugerencia sugerenciaPruebaGet=Sugerencia.builder()
                   .descripcion("realización de la prueba 1")
                .build();
        sugerenciaRepository.save(sugerenciaPruebaGet);
        //when 
        Sugerencia sugerenciaObtenido=sugerenciaRepository.getReferenceById(sugerenciaPruebaGet.getId());
        //then
        assertThat(sugerenciaObtenido.getId()).isNotNull();
        assertThat(sugerenciaObtenido.getId()).isEqualTo(sugerenciaPruebaGet.getId());
    }

    @Test
    void givenAnSuggestion_whenDelete_thenCountSuggestionIsZero(){
        //given 
        Sugerencia sugerenciaPruebaDelete=Sugerencia.builder()
                 .descripcion("Probar eliminación de sugerencia 1") 
               .build();
        sugerenciaRepository.save(sugerenciaPruebaDelete);
        //when 
        sugerenciaRepository.deleteById(sugerenciaPruebaDelete.getId()); 
        //then
        assertThat(sugerenciaRepository.count()).isZero();
    }

    @Test
    void givenAnSuggestion_whenUpdate_thenSuggestionDescripcionIsEqualsTo(){
        Sugerencia sugerenciaPruebaUpdate=Sugerencia.builder()
             .descripcion("Actualizacion de descripcion 1")
              .build();
        sugerenciaRepository.save(sugerenciaPruebaUpdate);
        //when 
        sugerenciaRepository.updateDescripcionById(sugerenciaPruebaUpdate.getId(), "nuevaDescripcion");
        //then
        assertThat(sugerenciaRepository.getReferenceById(sugerenciaPruebaUpdate.getId()).getDescripcion()).isEqualTo("nuevaDescripcion");
    }
}    
