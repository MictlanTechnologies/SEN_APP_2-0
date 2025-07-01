package org.SenApp.lecciones;

import org.SenApp.model.Usuario;

import org.SenApp.Util.readUtil;

public class Extras {
    public static void mostrarExtras(Usuario usuario) {
        var scanner = readUtil.getInstance().getScanner();
        while (true) {
            System.out.println("\n--- Extras ---");
            System.out.println("1. Ejercicios Interactivos");
            System.out.println("2. Juegos");
            System.out.println("3. Cuestionarios");
            System.out.println("4. Regresar");
            System.out.print("Selecciona una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    EjercicioInteractivo.iniciar();
                    break;
                case "2":
                    JuegoTexto.iniciar();
                    break;
                case "3":
                    Cuestionario.iniciarCuestionario();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

}
