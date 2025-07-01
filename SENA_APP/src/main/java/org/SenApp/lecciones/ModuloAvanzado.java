package org.SenApp.lecciones;

import java.util.Scanner;

public class ModuloAvanzado {
    public static void mostrarLecciones() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(" Módulos Avanzados");
            System.out.println("1. Conversaciones Completas");
            System.out.println("2. Lengua de Señas en el Trabajo");
            System.out.println("3. Señas Técnicas y Especializadas");
            System.out.println("4. Regresar");
            System.out.print("Selecciona una lección: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Conversaciones: Aprende a mantener diálogos más fluidos y naturales.");
                    break;
                case "2":
                    System.out.println("Trabajo: Señales útiles para reuniones, entrevistas y tareas laborales.");
                    break;
                case "3":
                    System.out.println("Técnicas: Aprende términos de áreas como medicina, tecnología, y educación.");
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
