package org.SenApp.app;

import org.senaa.util.HibernateUtil;
import org.senaa.util.HibernateUtil.UsuarioDAO;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO dao = new HibernateUtil.UsuarioDAO();
        for (org.senaa.model.Usuario u : dao.findAll()) {
            System.out.println("Nombre: " + u.getNombre() + " | Correo: " + u.getEmail());
        }
    }
}
