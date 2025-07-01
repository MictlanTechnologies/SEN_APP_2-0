package lecciones;

import java.util.Scanner;

public class Cuestionario {
    private static String[] preguntas = {
            "¿Cuál es la seña para 'Hola'?",
            "¿Cómo se representa la letra 'A' en el alfabeto manual?",
            "¿Qué seña se usa para 'Gracias'?"
    };

    private static String[][] opciones = {
            {"1. Mano en el pecho", "2. Mano abierta saludando", "3. Dedos cruzados"},
            {"1. Mano cerrada con pulgar al lado", "2. Dos dedos arriba", "3. Mano en forma de C"},
            {"1. Mano cerrada tocando el pecho", "2. Mano abierta desde la boca hacia adelante", "3. Índice señalando al corazón"}
    };

    private static int[] respuestasCorrectas = {2, 1, 2};

    public static int iniciarCuestionario() {
        Scanner scanner = new Scanner(System.in);
        int puntuacion = 0;

        System.out.println("Comenzando Cuestionario");
        for (int i = 0; i < preguntas.length; i++) {
            System.out.println("\nPregunta " + (i + 1) + ": " + preguntas[i]);
            for (String opcion : opciones[i]) {
                System.out.println(opcion);
            }
            System.out.print("Tu respuesta: ");
            int respuesta = scanner.nextInt();

            if (respuesta == respuestasCorrectas[i]) {
                System.out.println("Correcto");
                puntuacion++;
            } else {
                System.out.println("Incorrecto. La respuesta correcta era " + respuestasCorrectas[i] + ".");
            }
        }

        System.out.println("Tu puntuación final: " + puntuacion + "/" + preguntas.length);
        return puntuacion;
    }
}
