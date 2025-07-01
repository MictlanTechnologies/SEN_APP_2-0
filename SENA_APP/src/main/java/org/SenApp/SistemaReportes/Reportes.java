package SistemaReportes;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.senaa.model.ProgresoUsuario;
import org.senaa.util.HibernateUtil;
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

        // Guardar usando Hibernate
        try (Session s = HibernateUtil.getSession()) {
            org.senaa.model.Usuario entity = s.createQuery(
                            "from Usuario where email=:email",
                            org.senaa.model.Usuario.class)
                    .setParameter("email", usuario.getEmail())
                    .uniqueResult();
            if (entity != null) {
                Transaction tx = s.beginTransaction();
                ProgresoUsuario prog = new ProgresoUsuario(entity, puntaje);
                s.persist(prog);
                tx.commit();
                System.out.println("✅ Progreso guardado en la base de datos.");
            } else {
                System.out.println("⚠️ Usuario no encontrado en la base.");
            }
        } catch (Exception e) {
            System.out.println("❌ Error al guardar el progreso: " + e.getMessage());
        }
    }
}
