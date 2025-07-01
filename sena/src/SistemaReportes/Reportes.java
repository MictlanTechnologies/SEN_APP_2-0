package SistemaReportes;

import conexion.Base;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import app.Usuario;

public class Reportes {
    public static void guardarProgreso(Usuario usuario, String tipoActividad, int puntaje, int total) {
        if (usuario == null) {
            System.out.println("⚠️ No se puede guardar progreso sin un usuario válido.");
            return;
        }

        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String fecha = ahora.format(formato);

        System.out.println(" Reporte generado:");
        System.out.println("Usuario: " + usuario.getNombreUsuario());
        System.out.println("Actividad: " + tipoActividad);
        System.out.println("Puntaje: " + puntaje + "/" + total);
        System.out.println("Fecha: " + fecha);

        // Guardar en MySQL
        try {
            Base base = new Base();
            base.conectar();

            // Obtener el ID del usuario desde su correo
            String query = String.format(
                    "SELECT Usuario_ID FROM usuarios WHERE Correo_electronico = '%s'",
                    usuario.getEmail()
            );
            ResultSet rs = base.consulta(query);
            if (rs.next()) {
                int usuarioId = rs.getInt("Usuario_ID");

                String insertarSQL = String.format(
                        "INSERT INTO progreso_usuarios (Usuario_ID, Estado, Fecha_inicio, Fecha_finalización, Puntuación) " +
                                "VALUES (%d, 'completado', NOW(), NOW(), %d)",
                        usuarioId, puntaje
                );

                base.insertar(insertarSQL);
                System.out.println("✅ Progreso guardado en la base de datos.");
            } else {
                System.out.println("⚠️ Usuario no encontrado en la base.");
            }

            base.cierraConexion();
        } catch (SQLException e) {
            System.out.println("❌ Error al guardar el progreso: " + e.getMessage());
        }
    }
}
