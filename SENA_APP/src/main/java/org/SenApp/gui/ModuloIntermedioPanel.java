package org.SenApp.gui;

import javax.swing.*;
import java.awt.*;

public class ModuloIntermedioPanel extends JPanel {
    public ModuloIntermedioPanel(JFrame frame, CardLayout cards, JPanel container) {
        setLayout(new GridLayout(0,1,10,10));

        JButton l1 = new JButton("Expresiones Cotidianas");
        JButton l2 = new JButton("Familia y Relaciones");
        JButton l3 = new JButton("Emociones y Estados de \u00c1nimo");
        JButton back = new JButton("Regresar");

        l1.addActionListener(e -> JOptionPane.showMessageDialog(frame,
                "Expresiones Cotidianas: Frases como 'necesito ayuda', '¿d\u00f3nde est\u00e1 el ba\u00f1o?', 'vamos'."));
        l2.addActionListener(e -> JOptionPane.showMessageDialog(frame,
                "Familia: Aprende se\u00f1as para mam\u00e1, pap\u00e1, hermano, abuela, etc."));
        l3.addActionListener(e -> JOptionPane.showMessageDialog(frame,
                "Emociones: Aprende a expresar alegr\u00eda, enojo, tristeza, miedo."));
        back.addActionListener(e -> cards.show(container, "lecciones"));

        add(l1);
        add(l2);
        add(l3);
        add(back);
    }
}