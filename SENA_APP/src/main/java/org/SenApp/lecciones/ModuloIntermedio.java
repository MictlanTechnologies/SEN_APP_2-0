package org.SenApp.lecciones;

import java.util.Scanner;

public class ModuloIntermedio {
    public static void mostrarLecciones() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Módulos Intermedios");
            System.out.println("1. Expresiones Cotidianas");
            System.out.println("2. Familia y Relaciones");
            System.out.println("3. Emociones y Estados de Ánimo");
            System.out.println("4. Regresar");
            System.out.print("Selecciona una lección: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println(" Expresiones Cotidianas: Frases como 'necesito ayuda', '¿dónde está el baño?', 'vamos'.");
                    break;
                case "2":
                    System.out.println(" Familia: Aprende señas para mamá, papá, hermano, abuela, etc.");
                    break;
                case "3":
                    System.out.println(" Emociones: Aprende a expresar alegría, enojo, tristeza, miedo.");
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
