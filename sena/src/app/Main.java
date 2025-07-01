package app;

import conexion.Base;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        // Crea un objeto de la clase Base (para conectarse a MySQL)
        Base base = new Base();
        base.conectar();  // Intenta conectarse

        try {
            // Consulta la tabla 'usuarios'
            ResultSet rs = base.consulta("SELECT * FROM usuarios");

            // Recorre los resultados y los imprime
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                System.out.println("Nombre: " + nombre + " | Correo: " + correo);
            }

            base.cierraConexion();  // Cierra la conexión al final

        } catch (Exception e) {
            e.printStackTrace();  // Muestra los errores q ocurran
        }
    }
}
