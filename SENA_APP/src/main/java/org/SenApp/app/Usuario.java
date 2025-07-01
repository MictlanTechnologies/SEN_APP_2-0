package org.SenApp.app;

public class Usuario {
    private String email;
    private String contraseña;
    private String nombreUsuario;

    public Usuario(String email, String contraseña, String nombreUsuario) {
        this.email = email;
        this.contraseña = contraseña;
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
}
