package org.SenApp.app;

import java.util.Scanner;

import org.SenApp.SistemaReportes.Reportes;
import org.SenApp.lecciones.LeccionesApp;
import org.SenApp.model.GestorUsuarios;
import org.SenApp.model.Usuario;


public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorUsuarios gestor = new GestorUsuarios();

        while (true) {
            System.out.println("Menú Principal");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            String opcion = scanner.nextLine();

            if (opcion.equals("1")) {
                System.out.print("Correo: ");
                String email = scanner.nextLine();
                System.out.print("Contraseña: ");
                String contraseña = scanner.nextLine();
                gestor.registrar(email, contraseña);
            } else if (opcion.equals("2")) {
                System.out.print("Correo: ");
                String email = scanner.nextLine();
                System.out.print("Contraseña: ");
                String contraseña = scanner.nextLine();
                Usuario usuario = gestor.iniciarSesion(email, contraseña);
                if (usuario != null) {
                    Reportes.guardarProgreso(usuario, "test_manual", 10, 10); // prueba para verificar que si se guarden datos
                    LeccionesApp.iniciar(usuario);
                }
            } else if (opcion.equals("3")) {
                System.out.println("Saliendo");
                break;
            } else {
                System.out.println("Opción erronea, porfavor elija una opción valida.");
            }
        }

        scanner.close();
    }
}
