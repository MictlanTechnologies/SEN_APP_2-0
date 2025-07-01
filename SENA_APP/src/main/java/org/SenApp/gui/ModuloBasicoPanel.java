package org.SenApp.gui;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ModuloBasicoPanel extends JPanel {
    private final JFrame frame;
    private final CardLayout cards;
    private final JPanel container;
    public ModuloBasicoPanel(JFrame frame, CardLayout cards, JPanel container) {
        this.frame = frame;
        this.cards = cards;
        this.container = container;
        setLayout(new GridLayout(0,1,10,10));

        JButton l1 = new JButton("Introducci\u00f3n a la Lengua de Se\u00f1as")
        JButton l2 = new JButton("Alfabeto Manual");
        JButton l3 = new JButton("Saludos y Presentaciones");
        JButton back = new JButton("Regresar");

        l1.addActionListener(e -> JOptionPane.showMessageDialog(frame,
                "Introducci\u00f3n: La lengua de se\u00f1as es esencial para la comunicaci\u00f3n con personas sordas. Tiene historia, reglas y cultura propia."));
        l2.addActionListener(e -> mostrarAlfabeto());
        l3.addActionListener(e -> mostrarSaludos());
        back.addActionListener(e -> cards.show(container, "lecciones"));

        add(l1);
        add(l2);
        add(l3);
        add(back);
    }
    private void mostrarIntroduccion() {
        Map<String, String> vids = new LinkedHashMap<>();
        vids.put("Introducci\u00f3n", "/videos/basico/intro.mp4");
        VideoLessonPanel p = new VideoLessonPanel(frame, cards, container,
                "Introducci\u00f3n a la Lengua de Se\u00f1as", vids, "basico");
        container.add(p, "basico_intro");
        cards.show(container, "basico_intro");
    }

    private void mostrarAlfabeto() {
        Map<String, String> vids = new LinkedHashMap<>();
        String letras = "ABCDEFGHIJKLMN\u00d1OPQRSTUVWXYZ";
        for (char c : letras.toCharArray()) {
            vids.put(String.valueOf(c), "/recursosGraficos/Modulo Basico/Abecedario/" + c + ".mp4");
        }
        VideoLessonPanel p = new VideoLessonPanel(frame, cards, container,
                "Alfabeto Manual", vids, "basico");
        container.add(p, "basico_alfabeto");
        cards.show(container, "basico_alfabeto");
    }

    private void mostrarSaludos() {
        Map<String, String> vids = new LinkedHashMap<>();
        vids.put("Hola", "/recursosGraficos/Modulo Basico/hola.mp4");
        vids.put("\u00bfC\u00f3mo est\u00e1s?", "/recursosGraficos/Modulo Basico/como estas.mp4");
        vids.put("Me llamo...", "/recursosGraficos/Modulo Basico/Mi nombre es.mp4");
        VideoLessonPanel p = new VideoLessonPanel(frame, cards, container,
                "Saludos y Presentaciones", vids, "basico");
        container.add(p, "basico_saludos");
        cards.show(container, "basico_saludos");
    }
}
