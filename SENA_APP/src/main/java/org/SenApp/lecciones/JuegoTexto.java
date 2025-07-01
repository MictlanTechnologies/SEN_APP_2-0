package org.SenApp.lecciones;

import org.SenApp.SistemaReportes.Reportes;
import org.SenApp.model.Usuario;

import java.util.Random;
import java.util.Scanner;

public class JuegoTexto {
    public static Usuario usuario;

    public static void iniciar() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int puntuacion = 0;

        String[][] preguntas = {
                {"¿Cuál es la seña correcta para 'Hola'?", "saludar"},
                {"¿Cómo se dice 'Gracias' en señas?", "mano boca"},
                {"¿Cuál es la seña de 'Familia'?", "circulo f"}
        };

        System.out.println("\n🎮 BIENVENIDO AL JUEGO: ¡ADIVINA LA SEÑA!");

        for (int i = 0; i < preguntas.length; i++) {
            System.out.println("\n" + preguntas[i][0]);
            System.out.print("Ingresa una palabra clave asociada: ");
            String respuesta = scanner.nextLine().trim().toLowerCase();

            if (respuesta.contains(preguntas[i][1])) {
                System.out.println("Correcto");
                puntuacion++;
            } else {
                System.out.println("Incorrecto. Pista: incluía '" + preguntas[i][1] + "'");
            }
        }

        System.out.println("\nTu puntuación fue: " + puntuacion + "/" + preguntas.length);
        Reportes.guardarProgreso(usuario, "Juego Texto", puntuacion, preguntas.length);
    }
}
