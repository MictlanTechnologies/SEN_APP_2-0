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
        vids.put("Necesito ayuda", "/recursosGraficos/Modulo Intermedio/Ayuda.mp4");
        vids.put("\u00bfD\u00f3nde est\u00e1 el ba\u00f1o?", "/recursosGraficos/Modulo Intermedio/Bano.mp4");
        vids.put("Vamos", "/recursosGraficos/Modulo Intermedio/Vamos.mp4");
        VideoLessonPanel p = new VideoLessonPanel(frame, cards, container,
                "Expresiones Cotidianas", vids, "intermedio");
        container.add(p, "inter_exp");
        cards.show(container, "inter_exp");
    }

    private void mostrarFamilia() {
        Map<String, String> vids = new LinkedHashMap<>();
        vids.put("Abuela", "/recursosGraficos/Modulo Intermedio/Abuela.mp4");
        vids.put("Abuelo", "/recursosGraficos/Modulo Intermedio/Abuelo.mp4");
        vids.put("Esposa", "/recursosGraficos/Modulo Intermedio/Esposa.mp4");
        vids.put("Esposo", "/recursosGraficos/Modulo Intermedio/Esposo.mp4");
        vids.put("Familia", "/recursosGraficos/Modulo Intermedio/Familia.mp4");
        vids.put("Grupo", "/recursosGraficos/Modulo Intermedio/Grupo.mp4");
        vids.put("Hermana", "/recursosGraficos/Modulo Intermedio/Hermana.mp4");
        vids.put("Hermano", "/recursosGraficos/Modulo Intermedio/Hermano.mp4");
        vids.put("Hija", "/recursosGraficos/Modulo Intermedio/Hija.mp4");
        vids.put("Hijo", "/recursosGraficos/Modulo Intermedio/Hijo.mp4");
        vids.put("Mam\u00e1", "/recursosGraficos/Modulo Intermedio/Mama.mp4");
        vids.put("Novia", "/recursosGraficos/Modulo Intermedio/Novia.mp4");
        vids.put("Novio", "/recursosGraficos/Modulo Intermedio/Novio.mp4");
        vids.put("Nuera", "/recursosGraficos/Modulo Intermedio/Nueva.mp4");
        vids.put("Pap\u00e1", "/recursosGraficos/Modulo Intermedio/Pap\u00e1.mp4");
        vids.put("Persona", "/recursosGraficos/Modulo Intermedio/Persona.mp4");
        vids.put("Prima", "/recursosGraficos/Modulo Intermedio/Prima.mp4");
        vids.put("Primo", "/recursosGraficos/Modulo Intermedio/Primo.mp4");
        vids.put("T\u00eda", "/recursosGraficos/Modulo Intermedio/Tia.mp4");
        vids.put("T\u00edo", "/recursosGraficos/Modulo Intermedio/Tio.mp4");
        vids.put("Yerno", "/recursosGraficos/Modulo Intermedio/Yerno.mp4");
        VideoLessonPanel p = new VideoLessonPanel(frame, cards, container,
                "Familia y Relaciones", vids, "intermedio");
        container.add(p, "inter_familia");
        cards.show(container, "inter_familia");
    }

    private void mostrarEmociones() {
        Map<String, String> vids = new LinkedHashMap<>();
        vids.put("Alegr\u00eda", "/recursosGraficos/Modulo Intermedio/Alegria.mp4");
        vids.put("Enojo", "/recursosGraficos/Modulo Intermedio/Enojo.mp4");
        vids.put("Tristeza", "/recursosGraficos/Modulo Intermedio/Triste.mp4");
        VideoLessonPanel p = new VideoLessonPanel(frame, cards, container,
                "Emociones y Estados de \u00c1nimo", vids, "intermedio");
        container.add(p, "inter_emociones");
        cards.show(container, "inter_emociones");
    }
}
