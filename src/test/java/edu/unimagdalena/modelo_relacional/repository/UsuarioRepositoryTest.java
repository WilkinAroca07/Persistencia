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
import edu.unimagdalena.modelo_relacional.entidades.Usuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class UsuarioRepositoryTest extends AbstractIntegrationDBTest{
    UsuarioRepository usuarioRepository;


    @Autowired
    public UsuarioRepositoryTest(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    void initMockUsuarios(){
        Usuario usuario = Usuario.builder()
                .nombre("Andres")
                .apellidos("Barrera")
                .username("andresBarrera")
                .password("123")
                .build();
        usuarioRepository.save(usuario);
        usuarioRepository.flush();
    }

    @BeforeEach
    void setUp() {

        usuarioRepository.deleteAll();

    }
    @Test
    void givenAnUser_whenSave_thenUserwithId(){
        //given
        Usuario usuario = Usuario.builder()
                .nombre("Andres")
                .apellidos("Barrera")
                .username("andresBarrera")
                .email("andres@gamil.com")
                .password("123")
                .build();
        //when
        Usuario userSaved = usuarioRepository.save(usuario);
        //then
        assertThat(userSaved.getId()).isNotNull();
    }
    
    @Test
    void givenAnUser_whenGetReferenceById_thenGetUserWithId(){
        //given
        Usuario usuarioPruebaGet=Usuario.builder()
                .nombre("Pablo")
                .apellidos("Barrera")
                .username("pbarrera")
                .email("barrera123@gmail.com")
                .password("12345")
                .build();
        usuarioRepository.save(usuarioPruebaGet);
        //when 
        Usuario usuarioObtenido=usuarioRepository.getReferenceById(usuarioPruebaGet.getId());

        //then
        assertThat(usuarioObtenido.getId()).isNotNull();
        assertThat(usuarioObtenido.getId()).isEqualTo(usuarioPruebaGet.getId());
    }

    @Test
    void givenAnUser_whenDelete_thenCountUserIsZero(){
        //given 
        Usuario usuarioPruebaDelete=Usuario.builder()
                .nombre("Pablo")
                .apellidos("Barrera")
                .username("pbarrera")
                .email("barrera123@gmail.com")
                .password("12345")
                .build();
        usuarioRepository.save(usuarioPruebaDelete);
        //when 
        usuarioRepository.deleteById(usuarioPruebaDelete.getId()); 
        //then
        assertThat(usuarioRepository.count()).isZero();
    }

    @Test
    void givenAnUser_whenUpdate_thenUserUsernameIsEqualsTo(){
        Usuario usuarioPruebaUpdate=Usuario.builder()
                .nombre("Pablo")
                .apellidos("Barrera")
                .username("pbarrera")
                .email("barrera123@gmail.com")
                .password("12345")
                .build();
        usuarioRepository.save(usuarioPruebaUpdate);
        //when 
        usuarioRepository.updateUsernameById(usuarioPruebaUpdate.getId(), "nuevoUsername");
        //then
        assertThat(usuarioRepository.getReferenceById(usuarioPruebaUpdate.getId()).getUsername()).isEqualTo("nuevoUsername");
    }
}
