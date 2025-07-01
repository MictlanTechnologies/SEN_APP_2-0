package org.SenApp.gui;

import javax.swing.*;
import java.awt.*;

public class EjercicioInteractivoPanel extends JPanel {
    private final JFrame frame;
    private final CardLayout cards;
    private final JPanel container;

    public EjercicioInteractivoPanel(JFrame frame, CardLayout cards, JPanel container) {
        this.frame = frame;
        this.cards = cards;
        this.container = container;
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Ejercicios Interactivos", SwingConstants.CENTER);
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
        String[][] ejercicios = {
                {"\u00bfQu\u00e9 letra representa esta descripci\u00f3n? 'Mano cerrada, con el pulgar al costado'", "a) A\nb) B\nc) C", "a"},
                {"\u00bfCu\u00e1l de estas se\u00f1as representa 'Gracias'?", "a) Mano cerrada al pecho\nb) Mano extendida desde la boca hacia afuera\nc) Mano en la frente", "b"},
                {"\u00bfQu\u00e9 se\u00f1a representa una emoci\u00f3n positiva?", "a) Mano abierta en la frente\nb) Pu\u00f1os cerrados\nc) Sonrisa con mano en el pecho", "c"}
        };
        int puntuacion = 0;
        for (String[] e : ejercicios) {
            String resp = JOptionPane.showInputDialog(frame, e[0] + "\n" + e[1]);
            if (resp == null) return;
            if (resp.trim().equalsIgnoreCase(e[2])) {
                puntuacion++;
            }
        }
        JOptionPane.showMessageDialog(frame, "Puntuaci\u00f3n: " + puntuacion + "/" + ejercicios.length);
    }
}