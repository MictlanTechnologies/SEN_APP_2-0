package org.SenApp.gui;

import javax.swing.*;
import java.awt.*;

public class LeccionesAppPanel extends JPanel {
    public LeccionesAppPanel(JFrame frame, CardLayout cards, JPanel container) {
        setLayout(new GridLayout(0,1,10,10));

        JButton basico = new JButton("M\u00f3dulos B\u00e1sicos");
        JButton intermedio = new JButton("M\u00f3dulos Intermedios");
        JButton avanzado = new JButton("M\u00f3dulos Avanzados");
        JButton extras = new JButton("Extras");
        JButton back = new JButton("Regresar");

        basico.addActionListener(e -> cards.show(container, "basico"));
        intermedio.addActionListener(e -> cards.show(container, "intermedio"));
        avanzado.addActionListener(e -> cards.show(container, "avanzado"));
        extras.addActionListener(e -> cards.show(container, "extras"));
        back.addActionListener(e -> cards.show(container, "menu"));

        add(basico);
        add(intermedio);
        add(avanzado);
        add(extras);
        add(back);
    }
}