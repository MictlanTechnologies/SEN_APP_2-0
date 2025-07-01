package org.SenApp.gui;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ModuloAvanzadoPanel extends JPanel {
    private final JFrame frame;
    private final CardLayout cards;
    private final JPanel container;
    public ModuloAvanzadoPanel(JFrame frame, CardLayout cards, JPanel container) {
        this.frame = frame;
        this.cards = cards;
        this.container = container;
        setLayout(new GridLayout(0,1,10,10));

        JButton l1 = new JButton("Conversaciones Completas");
        JButton l2 = new JButton("Lengua de Se\u00f1as en el Trabajo");
        JButton l3 = new JButton("Se\u00f1as T\u00e9cnicas y Especializadas");
        JButton back = new JButton("Regresar");

        l1.addActionListener(e -> mostrarConversaciones());
        l2.addActionListener(e -> mostrarTrabajo());
        l3.addActionListener(e -> mostrarTecnicas());
        back.addActionListener(e -> cards.show(container, "lecciones"));

        add(l1);
        add(l2);
        add(l3);
        add(back);
    }
    private void mostrarConversaciones() {
        Map<String, String> vids = new LinkedHashMap<>();
        vids.put("Conversaci\u00f3n 1", "/videos/avanzado/conversacion1.mp4");
        vids.put("Conversaci\u00f3n 2", "/videos/avanzado/conversacion2.mp4");
        VideoLessonPanel p = new VideoLessonPanel(frame, cards, container,
                "Conversaciones Completas", vids, "avanzado");
        container.add(p, "avan_conv");
        cards.show(container, "avan_conv");
    }

    private void mostrarTrabajo() {
        Map<String, String> vids = new LinkedHashMap<>();
        vids.put("Reuni\u00f3n", "/videos/avanzado/reunion.mp4");
        vids.put("Entrevista", "/videos/avanzado/entrevista.mp4");
        VideoLessonPanel p = new VideoLessonPanel(frame, cards, container,
                "Lengua de Se\u00f1as en el Trabajo", vids, "avanzado");
        container.add(p, "avan_trabajo");
        cards.show(container, "avan_trabajo");
    }

    private void mostrarTecnicas() {
        Map<String, String> vids = new LinkedHashMap<>();
        vids.put("Medicina", "/videos/avanzado/medicina.mp4");
        vids.put("Tecnolog\u00eda", "/videos/avanzado/tecnologia.mp4");
        VideoLessonPanel p = new VideoLessonPanel(frame, cards, container,
                "Se\u00f1as T\u00e9cnicas y Especializadas", vids, "avanzado");
        container.add(p, "avan_tecnicas");
        cards.show(container, "avan_tecnicas");
    }
}
