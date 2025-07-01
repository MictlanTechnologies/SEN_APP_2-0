package org.SenApp.gui;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class VideoPlayer {
    public static void play(String resourcePath) {
        try {
            URL url = VideoPlayer.class.getResource(resourcePath);
            if (url == null) {
                JOptionPane.showMessageDialog(null, "No se encontró el video: " + resourcePath);
                return;
            }
            File file = new File(url.toURI());
            Desktop.getDesktop().open(file);
        } catch (URISyntaxException | java.io.IOException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo reproducir el video: " + ex.getMessage());
        }
    }
}