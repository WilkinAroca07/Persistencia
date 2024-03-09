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
import edu.unimagdalena.modelo_relacional.entidades.Mensaje;
import edu.unimagdalena.modelo_relacional.entidades.Sugerencia;
import edu.unimagdalena.modelo_relacional.entidades.Usuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MensajeRepositoryTest extends AbstractIntegrationDBTest{
    MensajeRepository mensajeRepository;

    @Autowired
    public MensajeRepositoryTest(MensajeRepository mensajeRepository) {
        this.mensajeRepository = mensajeRepository;
    }

    void initMockMensaje(){
        Mensaje mensaje = Mensaje.builder()
                .creador("Andres")
                .destinatario("Julian") 
                .build();
        mensajeRepository.save(mensaje);

        Mensaje mensaje1 = Mensaje.builder()
       
                .creador("Pablo")
                .destinatario("Jorge") 
                .build();
        mensajeRepository.save(mensaje1);
        mensajeRepository.flush();
    }

    @BeforeEach
    void setUp() {
        mensajeRepository.deleteAll();
    }

    @Test
    void givenAnMensajewhenSavethenMensajewithid(){
        //given
        Mensaje mensaje = Mensaje.builder()
                .creador("Miguel")
                .destinatario("Pablo") 
                .build();
        mensajeRepository.save(mensaje);
        //when
        Mensaje mensajeSaved = mensajeRepository.save(mensaje);
        //then
        assertThat(mensajeSaved.getId()).isNotNull();
    }

   
}