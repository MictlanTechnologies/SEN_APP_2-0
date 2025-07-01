package org.SenApp.gui;

import javax.swing.*;
import java.awt.*;

public class CuestionarioPanel extends JPanel {
    private final JFrame frame;
    private final CardLayout cards;
    private final JPanel container;

    private static final String[] PREGUNTAS = {
            "\u00bfCu\u00e1l es la se\u00f1a para 'Hola'?",
            "\u00bfC\u00f3mo se representa la letra 'A' en el alfabeto manual?",
            "\u00bfQu\u00e9 se\u00f1a se usa para 'Gracias'?"
    };

    private static final String[][] OPCIONES = {
            {"Mano en el pecho", "Mano abierta saludando", "Dedos cruzados"},
            {"Mano cerrada con pulgar al lado", "Dos dedos arriba", "Mano en forma de C"},
            {"Mano cerrada tocando el pecho", "Mano abierta desde la boca hacia adelante", "\u00cdndice se\u00f1alando al coraz\u00f3n"}
    };

    private static final int[] RESPUESTAS = {1,0,1};

    public CuestionarioPanel(JFrame frame, CardLayout cards, JPanel container) {
        this.frame = frame;
        this.cards = cards;
        this.container = container;
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Cuestionario", SwingConstants.CENTER);
        JButton start = new JButton("Comenzar");
        JButton back = new JButton("Regresar");
        JPanel bottom = new JPanel();
        bottom.add(start);
        bottom.add(back);

        add(title, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        start.addActionListener(e -> iniciar());
        back.addActionListener(e -> cards.show(container, "extras"));
    }

    private void iniciar() {
        int puntuacion = 0;
        for (int i = 0; i < PREGUNTAS.length; i++) {
            Object sel = JOptionPane.showInputDialog(
                    frame,
                    PREGUNTAS[i],
                    "Pregunta " + (i + 1),
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    OPCIONES[i],
                    OPCIONES[i][0]);
            if (sel == null) return;
            if (sel.equals(OPCIONES[i][RESPUESTAS[i]])) {
                puntuacion++;
            }
        }
        JOptionPane.showMessageDialog(frame,
                "Tu puntuaci\u00f3n final: " + puntuacion + "/" + PREGUNTAS.length);
    }
}