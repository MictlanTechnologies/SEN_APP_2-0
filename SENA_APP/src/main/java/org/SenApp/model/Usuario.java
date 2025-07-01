package org.SenApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Usuario_ID")
    private Integer id;

    @Setter
    @Column(name = "Nombre")
    private String nombre;

    @Setter
    @Column(name = "Correo_electronico", unique = true)
    private String email;

    @Setter
    @Column(name = "Contraseña")
    private String contrasena;

    @Setter
    @Column(name = "Rol")
    private String rol;

    @Setter
    @Column(name = "Nivel_dificultad_actual")
    private String nivel;

    public Usuario() {
    }

    public Usuario(String email, String contrasena, String nombre) {
        this.email = email;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.rol = "usuario";
        this.nivel = "básico";
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getRol() {
        return rol;
    }

    public String getNivel() {
        return nivel;
    }
}