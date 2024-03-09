package edu.unimagdalena.modelo_relacional.entidades;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="usuarios")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(unique = true, nullable = false)
    private String email;
    private String nombre;
    private String apellidos;
    private Integer edad;
    private String password;
    private String rep_password;
    private Boolean enabled;
    private String foto;
    private String rol;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime create_at;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.REFRESH,orphanRemoval = true)
    private List<Sugerencia>sugerencias;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.REFRESH,orphanRemoval = true)
    private List<Mensaje>mensajes;

    @ManyToMany(cascade=CascadeType.REFRESH)
    @JoinTable(name="usuarios_partidas",joinColumns = @JoinColumn(name="idUsuario",
        referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name="idPartida",referencedColumnName="id"))
    private List<Partida>partidas;    
}
