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
import edu.unimagdalena.modelo_relacional.entidades.Partida;
import edu.unimagdalena.modelo_relacional.entidades.Sugerencia;
import edu.unimagdalena.modelo_relacional.entidades.Usuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PartidaRepositoryTest extends AbstractIntegrationDBTest{
    PartidaRepository partidaRepository;

    @Autowired
    public PartidaRepositoryTest(PartidaRepository partidaRepository) {
        this.partidaRepository = partidaRepository;
    }

    void initMockPartidas(){
        Partida partida = Partida.builder()
                .ciudad("garagoa")
                .comentarios("El arquero realizo un autogol")
                .participantes(22)
                .build();
        partidaRepository.save(partida);

        Partida partida1 = Partida.builder()
       
                .ciudad("Malambo")
                .build();
        partidaRepository.save(partida1);
        partidaRepository.flush();
    }

    @BeforeEach
    void setUp() {
        partidaRepository.deleteAll();
    }

    @Test
    void givenAnPartida_whenSave_thenPartidawithId(){
        //given
        Partida partida = Partida.builder()
                .ciudad("Bogota")
                .creador("Jorge")
                .comentarios("Se realizo el juego sin ningun contratiempo")
                .participantes(23)
                .deporte("Futbol")
                .provincia("Patio bonito")
                .suplentes(4)
                .build();
        partidaRepository.save(partida);
        //when
        Partida partidaSaved = partidaRepository.save(partida);
        //then
        assertThat(partidaSaved.getId()).isNotNull();
    }

}
