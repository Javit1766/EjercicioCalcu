package aplicaciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Dashboard extends JFrame {

    public Dashboard() {
        setTitle("Mi Dashboard"); // Cambié el título
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Encabezado
        JLabel titulo = new JLabel("Mis Aplicaciones", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(titulo, BorderLayout.NORTH);

        // Panel de aplicaciones
        JPanel panelApps = new JPanel();
        panelApps.setLayout(new BoxLayout(panelApps, BoxLayout.Y_AXIS)); // Botones verticales
        panelApps.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));

        // Botón Calculadora
        JButton btnCalculadora = new JButton("Calculadora");
        btnCalculadora.setFont(new Font("Arial", Font.PLAIN, 18));
        btnCalculadora.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCalculadora.setMaximumSize(new Dimension(200, 40));
        btnCalculadora.addActionListener(e -> new CalculadoraVentana());
        panelApps.add(btnCalculadora);
        panelApps.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre botones

        // Botón Reloj
        JButton btnReloj = new JButton("Reloj");
        btnReloj.setFont(new Font("Arial", Font.PLAIN, 18));
        btnReloj.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnReloj.setMaximumSize(new Dimension(200, 40));
        btnReloj.addActionListener(e -> new RelojVentana());
        panelApps.add(btnReloj);
        panelApps.add(Box.createRigidArea(new Dimension(0, 10)));

        // Botón Hora/Fecha
        JButton btnHoraFecha = new JButton("Hora / Fecha");
        btnHoraFecha.setFont(new Font("Arial", Font.PLAIN, 18));
        btnHoraFecha.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnHoraFecha.setMaximumSize(new Dimension(200, 40));
        btnHoraFecha.addActionListener(e -> mostrarHoraFecha());
        panelApps.add(btnHoraFecha);

        add(panelApps, BorderLayout.CENTER);

        setVisible(true);
    }

    // Método para mostrar Hora/Fecha en un diálogo
    private void mostrarHoraFecha() {
        LocalTime hora = LocalTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
        JOptionPane.showMessageDialog(this, "Hora actual: " + hora.format(formato) 
            + "\nFecha: " + java.time.LocalDate.now(), "Hora / Fecha", JOptionPane.INFORMATION_MESSAGE);
    }
}
