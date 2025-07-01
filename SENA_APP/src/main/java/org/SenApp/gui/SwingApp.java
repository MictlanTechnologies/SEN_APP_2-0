package org.SenApp.gui;

import org.SenApp.model.GestorUsuarios;
import org.SenApp.model.Usuario;


import javax.swing.*;
import java.awt.*;

public class SwingApp {
    private final JFrame frame = new JFrame("SenApp");
    private final CardLayout cards = new CardLayout();
    private final JPanel container = new JPanel(cards);

    private final GestorUsuarios gestor = new GestorUsuarios();
    private Usuario currentUser;

    public SwingApp() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        container.add(createLoginPanel(), "login");
        frame.setContentPane(container);
    }

    public void show() {
        frame.setVisible(true);
    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JTextField emailField = new JTextField();
        JPasswordField passField = new JPasswordField();

        JButton loginBtn = new JButton("Iniciar sesión");
        JButton registerBtn = new JButton("Registrar");

        gbc.gridx = 0; gbc.gridy = 0; panel.add(new JLabel("Correo:"), gbc);
        gbc.gridx = 1; panel.add(emailField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; panel.add(new JLabel("Contraseña:"), gbc);
        gbc.gridx = 1; panel.add(passField, gbc);

        JPanel buttons = new JPanel();
        buttons.add(loginBtn);
        buttons.add(registerBtn);
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; panel.add(buttons, gbc);

        loginBtn.addActionListener(e -> {
            String email = emailField.getText().trim();
            String pass = new String(passField.getPassword());
            Usuario u = gestor.iniciarSesion(email, pass);
            if (u != null) {
                currentUser = u;
                container.add(createMainMenu(u), "menu");
                addUserPanels();
                cards.show(container, "menu");
            } else {
                JOptionPane.showMessageDialog(frame, "Credenciales inválidas");
            }
        });

        registerBtn.addActionListener(e -> {
            String email = emailField.getText().trim();
            String pass = new String(passField.getPassword());
            if (gestor.registrar(email, pass)) {
                JOptionPane.showMessageDialog(frame, "Cuenta creada");
            }
        });

        return panel;
    }

    private JPanel createMainMenu(Usuario usuario) {
        JPanel panel = new JPanel(new GridLayout(0,1,10,10));

        JLabel welcome = new JLabel("Bienvenido, " + usuario.getNombre(), SwingConstants.CENTER);
        JButton lecciones = new JButton("Lecciones y Extras");
        JButton salir = new JButton("Salir");

        lecciones.addActionListener(e -> cards.show(container, "lecciones"));
        salir.addActionListener(e -> {
            currentUser = null;
            cards.show(container, "login");
        });

        panel.add(welcome);
        panel.add(lecciones);
        panel.add(salir);

        return panel;
    }

    private void addUserPanels() {
        container.add(new LeccionesAppPanel(frame, cards, container), "lecciones");
        container.add(new ModuloBasicoPanel(frame, cards, container), "basico");
        container.add(new ModuloIntermedioPanel(frame, cards, container), "intermedio");
        container.add(new ModuloAvanzadoPanel(frame, cards, container), "avanzado");
        container.add(new ExtrasPanel(frame, cards, container), "extras");
        container.add(new EjercicioInteractivoPanel(frame, cards, container), "ejercicio");
        container.add(new JuegoTextoPanel(frame, cards, container), "juego");
        container.add(new CuestionarioPanel(frame, cards, container), "cuestionario");
    }

    public static void main(String[] args) {
        new SwingApp().show();
    }
}