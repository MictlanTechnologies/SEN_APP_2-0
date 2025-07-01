package org.SenApp.gui;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class VideoLessonPanel extends JPanel {
    public VideoLessonPanel(JFrame frame, CardLayout cards, JPanel container,
                            String title, Map<String, String> videos, String backCard) {
        setLayout(new BorderLayout());

        JLabel lbl = new JLabel(title, SwingConstants.CENTER);
        add(lbl, BorderLayout.NORTH);

        JPanel grid = new JPanel();
        int cols = Math.min(5, videos.size());
        grid.setLayout(new GridLayout(0, cols, 5, 5));

        for (Map.Entry<String, String> entry : videos.entrySet()) {
            JButton btn = new JButton(entry.getKey());
            btn.addActionListener(e -> VideoPlayer.play(entry.getValue()));
            grid.add(btn);
        }

        JScrollPane scroll = new JScrollPane(grid);
        add(scroll, BorderLayout.CENTER);

        JButton back = new JButton("Regresar");
        back.addActionListener(e -> cards.show(container, backCard));
        add(back, BorderLayout.SOUTH);
    }
}