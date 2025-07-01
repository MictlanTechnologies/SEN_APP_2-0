package org.SenApp.model;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "progreso_usuarios")
public class ProgresoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Progreso_ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Usuario_ID")
    private app.Usuario usuario;

    @Column(name = "Estado")
    private String estado;

    @Column(name = "Fecha_inicio")
    private LocalDateTime fechaInicio;

    @Column(name = "Fecha_finalización")
    private LocalDateTime fechaFin;

    @Column(name = "Puntuación")
    private Integer puntuacion;

    public ProgresoUsuario() {
    }

    public ProgresoUsuario(app.Usuario usuario, int puntuacion) {
        this.usuario = usuario;
        this.puntuacion = puntuacion;
        this.estado = "completado";
        this.fechaInicio = LocalDateTime.now();
        this.fechaFin = LocalDateTime.now();
    }

    // getters y setters omitidos por brevedad
}
