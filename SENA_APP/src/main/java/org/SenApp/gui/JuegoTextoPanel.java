package org.SenApp.gui;

import javax.swing.*;
import java.awt.*;

public class JuegoTextoPanel extends JPanel {
    private final JFrame frame;
    private final CardLayout cards;
    private final JPanel container;

    public JuegoTextoPanel(JFrame frame, CardLayout cards, JPanel container) {
        this.frame = frame;
        this.cards = cards;
        this.container = container;
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Juego de Texto", SwingConstants.CENTER);
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
        String[][] preguntas = {
                {"\u00bfCu\u00e1l es la se\u00f1a correcta para 'Hola'?", "saludar"},
                {"\u00bfC\u00f3mo se dice 'Gracias' en se\u00f1as?", "mano boca"},
                {"\u00bfCu\u00e1l es la se\u00f1a de 'Familia'?", "circulo f"}
        };
        int puntuacion = 0;
        for (String[] p : preguntas) {
            String resp = JOptionPane.showInputDialog(frame, p[0] + "\nIngresa una palabra clave asociada:");
            if (resp == null) return;
            if (resp.toLowerCase().contains(p[1])) {
                puntuacion++;
            }
        }
        JOptionPane.showMessageDialog(frame, "Puntuaci\u00f3n: " + puntuacion + "/" + preguntas.length);
    }
}