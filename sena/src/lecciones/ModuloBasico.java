package lecciones;

import java.util.Scanner;

public class ModuloBasico {
    public static void mostrarLecciones() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Módulos Básicos");
            System.out.println("1. Introducción a la Lengua de Señas");
            System.out.println("2. Alfabeto Manual");
            System.out.println("3. Saludos y Presentaciones");
            System.out.println("4. Regresar");
            System.out.print("Selecciona una lección: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println(" Introducción: La lengua de señas es esencial para la comunicación con personas sordas. Tiene historia, reglas y cultura propia.");
                    break;
                case "2":
                    System.out.println(" Alfabeto Manual: Aprende a deletrear nombres y palabras letra por letra.");
                    break;
                case "3":
                    System.out.println(" Saludos: Aprende a decir 'Hola', '¿Cómo estás?', 'Me llamo...'");
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
