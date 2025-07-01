package org.SenApp.app;      // ← ajústalo si tu jerarquía real difiere

import org.SenApp.Util.readUtil;
import org.SenApp.SistemaReportes.Reportes;
import org.SenApp.Util.HibernateUtil;
import org.SenApp.model.Usuario;          // DAO dedicado a Usuario
import org.SenApp.model.GestorUsuarios;
import org.SenApp.lecciones.LeccionesApp;

/**
 * Punto de entrada a la aplicación de consola.
 * <p>
 * 1. Muestra los usuarios existentes (debug).
 * 2. Permite crear cuenta o iniciar sesión.
 * 3. Tras iniciar, redirige a LeccionesApp e inserta un registro de prueba
 *    en la tabla de progreso (Reportes).
 */
public final class LoginSystem {
    // Utilidad para lectura desde consola
    private static final readUtil RU = readUtil.getInstance();
    public static void main(String[] args) {
        /* ─────────────────────── Bootstrap de Hibernate ─────────────────────── */
        // Asegúrate de que HibernateUtil haya inicializado el SessionFactory
        // antes de que cualquier DAO intente abrir sesión.
        HibernateUtil.getSession();  // implementa este método si todavía no existe

        /* ───────────── Depuración: listar los usuarios actuales ─────────────── */
        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            HibernateUtil.UsuarioDAO dao = new HibernateUtil.UsuarioDAO();
            dao.findAll()
                    .forEach(u -> System.out.printf("Nombre: %s | Correo: %s%n",
                            u.getNombre(), u.getEmail()));
        } catch (Exception e) {
            System.err.println("No se pudieron cargar los usuarios: " + e.getMessage());
        }

        /* ─────────────────────────── Menú principal ────────────────────────── */
        GestorUsuarios gestor = new GestorUsuarios();

        loop: while (true) {
            System.out.println(" ===== MENÚ PRINCIPAL =====");
            System.out.println( "1. Crear cuenta");
            System.out.println( "2. Iniciar sesión");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            String opcion = RU.read().trim();

            switch (opcion) {
                case "1" -> crearCuenta(gestor);
                case "2" -> iniciarSesion(gestor);
                case "3" -> {
                    System.out.println("Saliendo…");
                    break loop;
                }
                default -> System.out.println("Opción incorrecta, intenta de nuevo.");
            }
        }

        /* ────────────────────────── Limpieza final ─────────────────────────── */
        RU.getScanner().close();
        HibernateUtil.getSession(); // cierra el SessionFactory
    }

    /* -------------------------------------------------------------------------
     * Métodos auxiliares
     * ---------------------------------------------------------------------- */

    private static void crearCuenta(GestorUsuarios gestor) {
        System.out.print("Correo: ");
        String email = RU.read().trim();

        System.out.print("Contraseña: ");
        String contrasena = RU.read();

        try {
            gestor.registrar(email, contrasena);
            System.out.println("✅ Cuenta creada con éxito.\n");
        } catch (Exception e) {
            System.err.println("❌ No se pudo crear la cuenta: " + e.getMessage());
        }
    }

    private static void iniciarSesion(GestorUsuarios gestor) {
        System.out.print("Correo: ");
        String email = RU.read().trim();

        System.out.print("Contraseña: ");
        String contrasena = RU.read();

        Usuario usuario = gestor.iniciarSesion(email, contrasena);
        if (usuario == null) {
            System.out.println("❌ Credenciales incorrectas.\n");
            return;
        }

        // Demo: registrar un progreso ficticio y lanzar la app de lecciones
        Reportes.guardarProgreso(usuario, "test_manual", 10, 10);
        LeccionesApp.iniciar(usuario);
    }
}
