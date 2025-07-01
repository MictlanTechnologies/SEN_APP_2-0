package org.SenApp.lecciones;

import org.SenApp.SistemaReportes.Reportes;
import java.util.Scanner;

import static org.SenApp.lecciones.JuegoTexto.usuario;

public class EjercicioInteractivo {
    public static void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int puntuacion = 0;

        System.out.println("EJERCICIOS INTERACTIVOS");
        String[][] ejercicios = {
                {"¿Qué letra representa esta descripción? 'Mano cerrada, con el pulgar al costado'", "a) A\nb) B\nc) C", "a"},
                {"¿Cuál de estas señas representa 'Gracias'?", "a) Mano cerrada al pecho\nb) Mano extendida desde la boca hacia afuera\nc) Mano en la frente", "b"},
                {"¿Qué seña representa una emoción positiva?", "a) Mano abierta en la frente\nb) Puños cerrados\nc) Sonrisa con mano en el pecho", "c"}
        };

        for (int i = 0; i < ejercicios.length; i++) {
            System.out.println("\nEjercicio " + (i + 1));
            System.out.println(ejercicios[i][0]);
            System.out.println(ejercicios[i][1]);
            System.out.print("Tu respuesta: ");
            String respuesta = scanner.nextLine().trim().toLowerCase();

            if (respuesta.equals(ejercicios[i][2])) {
                System.out.println("Correcto");
                puntuacion++;
            } else {
                System.out.println("Incorrecto. La respuesta correcta era '" + ejercicios[i][2] + "'.");
            }
        }

        System.out.println("Finalizaste los ejercicios. Puntuación: " + puntuacion + "/" + ejercicios.length);
        Reportes.guardarProgreso(usuario, "Ejercicios", puntuacion, ejercicios.length);
    }
}