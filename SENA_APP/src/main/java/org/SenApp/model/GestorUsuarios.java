package org.SenApp.model;

import org.hibernate.Session;
import org.SenApp.Util.HibernateUtil;
import org.SenApp.Util.HibernateUtil.UsuarioDAO;
import org.SenApp.model.Usuario;

public class GestorUsuarios {
    private final UsuarioDAO dao;

    public GestorUsuarios() {
        dao = new HibernateUtil.UsuarioDAO();
    }

    public boolean registrar(String email, String contraseña) {
        try (Session s = HibernateUtil.getSession()) {
            Usuario existente = s.createQuery("from Usuario where email = :email", Usuario.class)
                    .setParameter("email", email)
                    .uniqueResult();
            if (existente != null) {
                System.out.println("Ya hay una cuenta con este correo.");
                return false;
            }


            String baseNombre = email.split("@")[0];
            String nombreFinal = baseNombre;
            int contador = 1;

            while (s.createQuery("select count(u) from Usuario u where nombre=:nom", Long.class)
                    .setParameter("nom", nombreFinal)
                    .uniqueResult() > 0) {
                nombreFinal = baseNombre + contador;
                contador++;
            }

            Usuario nuevo = new Usuario(email, contraseña, nombreFinal);
            dao.save(nuevo);
            System.out.println("Cuenta creada exitosamente. Tu nombre de usuario es: " + nombreFinal);
            return true;
        }
    }

    public Usuario iniciarSesion(String email, String contraseña) {
        try (Session s = HibernateUtil.getSession()) {
            Usuario entity = s.createQuery(
                            "from Usuario where email=:email and contrasena=:con",
                            Usuario.class)
                    .setParameter("email", email)
                    .setParameter("con", contraseña)
                    .uniqueResult();
            if (entity != null) {
                System.out.println("Inicio de sesión exitoso. ¡Bienvenido " + entity.getNombre() + "!");
                return new Usuario(email, contraseña, entity.getNombre());
            } else {
                System.out.println("Correo o contraseña incorrectos.");
                return null;
            }
        }
    }
}
