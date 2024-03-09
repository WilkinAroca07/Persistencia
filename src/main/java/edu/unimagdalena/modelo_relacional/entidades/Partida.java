package edu.unimagdalena.modelo_relacional.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "partidas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String creador;
    private String deporte;
    private String ciudad;
    private String provincia;
    @Temporal(TemporalType.DATE)
    private LocalDate fecha;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime hora_comienzo;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime hora_final;
    private Integer participantes;
    private Integer suplentes;
    private String comentarios;

    @ManyToMany(mappedBy="partidas",cascade=CascadeType.REFRESH)
    private List<Usuario>usuarios;
}
