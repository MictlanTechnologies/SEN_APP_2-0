package org.SenApp.gui;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ModuloIntermedioPanel extends JPanel {
    private final JFrame frame;
    private final CardLayout cards;
    private final JPanel container;
    public ModuloIntermedioPanel(JFrame frame, CardLayout cards, JPanel container) {
        this.frame = frame;
        this.cards = cards;
        this.container = container;
        setLayout(new GridLayout(0,1,10,10));

        JButton l1 = new JButton("Expresiones Cotidianas");
        JButton l2 = new JButton("Familia y Relaciones");
        JButton l3 = new JButton("Emociones y Estados de \u00c1nimo");
        JButton back = new JButton("Regresar");

        l1.addActionListener(e -> mostrarExpresiones());
        l2.addActionListener(e -> mostrarFamilia());
        l3.addActionListener(e -> mostrarEmociones());
        back.addActionListener(e -> cards.show(container, "lecciones"));

        add(l1);
        add(l2);
        add(l3);
        add(back);
    }
    private void mostrarExpresiones() {
        Map<String, String> vids = new LinkedHashMap<>();
        vids.put("Necesito ayuda", "/videos/intermedio/ayuda.mp4");
        vids.put("\u00bfD\u00f3nde est\u00e1 el ba\u00f1o?", "/videos/intermedio/bano.mp4");
        vids.put("Vamos", "/videos/intermedio/vamos.mp4");
        VideoLessonPanel p = new VideoLessonPanel(frame, cards, container,
                "Expresiones Cotidianas", vids, "intermedio");
        container.add(p, "inter_exp");
        cards.show(container, "inter_exp");
    }

    private void mostrarFamilia() {
        Map<String, String> vids = new LinkedHashMap<>();
        vids.put("Mamá", "/videos/intermedio/mama.mp4");
        vids.put("Papá", "/videos/intermedio/papa.mp4");
        vids.put("Hermano", "/videos/intermedio/hermano.mp4");
        VideoLessonPanel p = new VideoLessonPanel(frame, cards, container,
                "Familia y Relaciones", vids, "intermedio");
        container.add(p, "inter_familia");
        cards.show(container, "inter_familia");
    }

    private void mostrarEmociones() {
        Map<String, String> vids = new LinkedHashMap<>();
        vids.put("Alegr\u00eda", "/videos/intermedio/alegria.mp4");
        vids.put("Enojo", "/videos/intermedio/enojo.mp4");
        vids.put("Tristeza", "/videos/intermedio/tristeza.mp4");
        VideoLessonPanel p = new VideoLessonPanel(frame, cards, container,
                "Emociones y Estados de \u00c1nimo", vids, "intermedio");
        container.add(p, "inter_emociones");
        cards.show(container, "inter_emociones");
    }
}
