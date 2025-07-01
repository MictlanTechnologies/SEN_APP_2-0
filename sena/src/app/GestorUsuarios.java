package app;

import conexion.Base;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestorUsuarios {
    private Base base;

    public GestorUsuarios() {
        base = new Base();
        base.conectar();  // Conexión a MySQL
    }

    public boolean registrar(String email, String contraseña) {
        try {
            // Verificar si ya existe un usuario con ese correo
            ResultSet rs = base.consulta("SELECT COUNT(*) AS total FROM usuarios WHERE Correo_electronico = '" + email + "'");
            if (rs.next() && rs.getInt("total") > 0) {
                System.out.println("Ya hay una cuenta con este correo.");
                return false;
            }

            // Generar nombre de usuario basado en el correo
            String baseNombre = email.split("@")[0];
            String nombreFinal = baseNombre;
            int contador = 1;

            ResultSet existeNombre = base.consulta(
                    "SELECT COUNT(*) AS total FROM usuarios WHERE Nombre = '" + nombreFinal + "'"
            );
            while (existeNombre.next() && existeNombre.getInt("total") > 0) {
                nombreFinal = baseNombre + contador;
                existeNombre = base.consulta(
                        "SELECT COUNT(*) AS total FROM usuarios WHERE Nombre = '" + nombreFinal + "'"
                );
                contador++;
            }

            // Insertar nuevo usuario
            String insertarSQL = String.format(
                    "INSERT INTO usuarios (Nombre, Correo_electronico, Contraseña, Rol, Nivel_dificultad_actual) " +
                            "VALUES ('%s', '%s', '%s', 'usuario', 'básico')",
                    nombreFinal, email, contraseña
            );

            base.insertar(insertarSQL);
            System.out.println("Cuenta creada exitosamente. Tu nombre de usuario es: " + nombreFinal);
            return true;

        } catch (SQLException e) {
            System.out.println("Error al registrar: " + e.getMessage());
            return false;
        }
    }

    public Usuario iniciarSesion(String email, String contraseña) {
        try {
            String consultaSQL = String.format(
                    "SELECT * FROM usuarios WHERE Correo_electronico = '%s' AND Contraseña = '%s'",
                    email, contraseña
            );

            ResultSet rs = base.consulta(consultaSQL);

            if (rs.next()) {
                String nombre = rs.getString("Nombre");
                System.out.println("Inicio de sesión exitoso. ¡Bienvenido " + nombre + "!");
                return new Usuario(email, contraseña, nombre);
            } else {
                System.out.println("Correo o contraseña incorrectos.");
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión: " + e.getMessage());
            return null;
        }
    }
}
