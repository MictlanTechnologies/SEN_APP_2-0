package org.SenApp.lecciones;

import org.SenApp.model.Usuario;

import java.util.Scanner;

public class LeccionesApp {
    public static void iniciar(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lecciones de Lengua de Señas");
        System.out.println("Bienvenido, " + usuario.getNombre() + "!");

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Módulos Básicos");
            System.out.println("2. Módulos Intermedios");
            System.out.println("3. Módulos Avanzados");
            System.out.println("4. Extras: Ejercicios, Juegos y Cuestionarios");
            System.out.println("5. Regresar al menú principal");
            System.out.print("Opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    org.SenApp.lecciones.ModuloBasico.mostrarLecciones();
                    break;
                case "2":
                    org.SenApp.lecciones.ModuloIntermedio.mostrarLecciones();
                    break;
                case "3":
                    org.SenApp.lecciones.ModuloAvanzado.mostrarLecciones();
                    break;
                case "4":
                    org.SenApp.lecciones.Extras.mostrarExtras(usuario);
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
