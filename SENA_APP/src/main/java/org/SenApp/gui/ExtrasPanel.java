package org.SenApp.gui;

import javax.swing.*;
import java.awt.*;

public class ExtrasPanel extends JPanel {
    public ExtrasPanel(JFrame frame, CardLayout cards, JPanel container) {
        setLayout(new GridLayout(0,1,10,10));

        JButton ejercicios = new JButton("Ejercicios Interactivos");
        JButton juego = new JButton("Juego de Texto");
        JButton cuestionario = new JButton("Cuestionario");
        JButton back = new JButton("Regresar");

        ejercicios.addActionListener(e -> cards.show(container, "ejercicio"));
        juego.addActionListener(e -> cards.show(container, "juego"));
        cuestionario.addActionListener(e -> cards.show(container, "cuestionario"));
        back.addActionListener(e -> cards.show(container, "lecciones"));

        add(ejercicios);
        add(juego);
        add(cuestionario);
        add(back);
    }
}