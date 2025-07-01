package org.SenApp.gui;

import javax.swing.*;
import java.awt.*;

public class ModuloBasicoPanel extends JPanel {
    public ModuloBasicoPanel(JFrame frame, CardLayout cards, JPanel container) {
        setLayout(new GridLayout(0,1,10,10));

        JButton l1 = new JButton("Introducci\u00f3n a la Lengua de Se\u00f1as");
        JButton l2 = new JButton("Alfabeto Manual");
        JButton l3 = new JButton("Saludos y Presentaciones");
        JButton back = new JButton("Regresar");

        l1.addActionListener(e -> JOptionPane.showMessageDialog(frame,
                "Introducci\u00f3n: La lengua de se\u00f1as es esencial para la comunicaci\u00f3n con personas sordas. Tiene historia, reglas y cultura propia."));
        l2.addActionListener(e -> JOptionPane.showMessageDialog(frame,
                "Alfabeto Manual: Aprende a deletrear nombres y palabras letra por letra."));
        l3.addActionListener(e -> JOptionPane.showMessageDialog(frame,
                "Saludos: Aprende a decir 'Hola', '¿C\u00f3mo est\u00e1s?', 'Me llamo...'"));
        back.addActionListener(e -> cards.show(container, "lecciones"));

        add(l1);
        add(l2);
        add(l3);
        add(back);
    }
}