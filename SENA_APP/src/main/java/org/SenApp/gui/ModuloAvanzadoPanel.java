package org.SenApp.gui;

import javax.swing.*;
import java.awt.*;

public class ModuloAvanzadoPanel extends JPanel {
    public ModuloAvanzadoPanel(JFrame frame, CardLayout cards, JPanel container) {
        setLayout(new GridLayout(0,1,10,10));

        JButton l1 = new JButton("Conversaciones Completas");
        JButton l2 = new JButton("Lengua de Se\u00f1as en el Trabajo");
        JButton l3 = new JButton("Se\u00f1as T\u00e9cnicas y Especializadas");
        JButton back = new JButton("Regresar");

        l1.addActionListener(e -> JOptionPane.showMessageDialog(frame,
                "Conversaciones: Aprende a mantener di\u00e1logos m\u00e1s fluidos y naturales."));
        l2.addActionListener(e -> JOptionPane.showMessageDialog(frame,
                "Trabajo: Se\u00f1ales \u00fatiles para reuniones, entrevistas y tareas laborales."));
        l3.addActionListener(e -> JOptionPane.showMessageDialog(frame,
                "T\u00e9cnicas: Aprende t\u00e9rminos de \u00e1reas como medicina, tecnolog\u00eda y educaci\u00f3n."));
        back.addActionListener(e -> cards.show(container, "lecciones"));

        add(l1);
        add(l2);
        add(l3);
        add(back);
    }
}