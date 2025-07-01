package org.SenApp.app;

import org.SenApp.Util.HibernateUtil;
import org.SenApp.Util.HibernateUtil.UsuarioDAO;
import org.SenApp.model.Usuario;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO dao = new HibernateUtil.UsuarioDAO();
        for (Usuario u : dao.findAll()) {
            System.out.println("Nombre: " + u.getNombre() + " | Correo: " + u.getEmail());
        }
    }
}
