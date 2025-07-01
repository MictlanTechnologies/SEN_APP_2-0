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

        JButton l1 = new JButton("Introducci\u00f3n a la Lengua de Se\u00f1as");
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
        vids.put("Hola", "/recursosGraficos/Modulo Basico/Hola.mp4");
        vids.put("Mi nombre es", "/recursosGraficos/Modulo Basico/Mi nombre es.mp4");
        vids.put("Adi\u00f3s", "/recursosGraficos/Modulo Basico/Adi\u00f3s.mp4");
        vids.put("Bien", "/recursosGraficos/Modulo Basico/Bien.mp4");
        vids.put("Buenas Tardes", "/recursosGraficos/Modulo Basico/Buenas Tardes.mp4");
        vids.put("Buenas noches", "/recursosGraficos/Modulo Basico/Buenas noches.mp4");
        vids.put("De nada", "/recursosGraficos/Modulo Basico/De nada.mp4");
        vids.put("Gracias", "/recursosGraficos/Modulo Basico/Gracias.mp4");
        vids.put("Gusto en conocerte", "/recursosGraficos/Modulo Basico/Gusto en conocerte.mp4");
        vids.put("Mal", "/recursosGraficos/Modulo Basico/Mal.mp4");
        vids.put("M\u00e1s o menos", "/recursosGraficos/Modulo Basico/Mas o menos.mp4");
        vids.put("Nos vemos", "/recursosGraficos/Modulo Basico/Nos vemos.mp4");
        VideoLessonPanel p = new VideoLessonPanel(frame, cards, container,
                "Saludos y Presentaciones", vids, "basico");
        container.add(p, "basico_saludos");
        cards.show(container, "basico_saludos");
    }
}
