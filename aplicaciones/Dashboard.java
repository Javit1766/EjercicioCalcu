package aplicaciones;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Dashboard extends JFrame {

    public Dashboard() {
        setTitle("Mi Dashboard");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Mis Aplicaciones", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(titulo, BorderLayout.NORTH);

        JPanel panelApps = new JPanel();
        panelApps.setLayout(new BoxLayout(panelApps, BoxLayout.Y_AXIS));
        panelApps.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));

        // Calculadora
        JButton btnCalc = new JButton("Calculadora");
        btnCalc.setFont(new Font("Arial", Font.PLAIN, 18));
        btnCalc.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCalc.setMaximumSize(new Dimension(200, 40));
        btnCalc.addActionListener(e -> new CalculadoraVentana());
        panelApps.add(btnCalc);
        panelApps.add(Box.createRigidArea(new Dimension(0, 10)));

        // Reloj
        JButton btnReloj = new JButton("Reloj");
        btnReloj.setFont(new Font("Arial", Font.PLAIN, 18));
        btnReloj.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnReloj.setMaximumSize(new Dimension(200, 40));
        btnReloj.addActionListener(e -> new RelojVentana());
        panelApps.add(btnReloj);
        panelApps.add(Box.createRigidArea(new Dimension(0, 10)));

        // Hora/Fecha
        JButton btnHoraFecha = new JButton("Hora / Fecha");
        btnHoraFecha.setFont(new Font("Arial", Font.PLAIN, 18));
        btnHoraFecha.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnHoraFecha.setMaximumSize(new Dimension(200, 40));
        btnHoraFecha.addActionListener(e -> mostrarHoraFecha());
        panelApps.add(btnHoraFecha);

        add(panelApps, BorderLayout.CENTER);
        setVisible(true);

JButton btnSerpiente = new JButton("Serpiente Nokia");
btnSerpiente.setFont(new Font("Arial", Font.PLAIN, 18));
btnSerpiente.setAlignmentX(Component.CENTER_ALIGNMENT);
btnSerpiente.setMaximumSize(new Dimension(200, 40));
btnSerpiente.addActionListener(e -> new SerpienteVentana());
panelApps.add(btnSerpiente);
panelApps.add(Box.createRigidArea(new Dimension(0, 10)));


    }

    private void mostrarHoraFecha() {
        LocalTime hora = LocalTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
        JOptionPane.showMessageDialog(this,
                "Hora actual: " + hora.format(formato) + "\nFecha: " + java.time.LocalDate.now(),
                "Hora / Fecha", JOptionPane.INFORMATION_MESSAGE);
    }
}
