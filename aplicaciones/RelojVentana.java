package aplicaciones;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RelojVentana extends JFrame {

    private JLabel lblHora;

    public RelojVentana() {
        setTitle("Reloj");
        setSize(250, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        lblHora = new JLabel("", SwingConstants.CENTER);
        lblHora.setFont(new Font("Arial", Font.BOLD, 36));
        add(lblHora, BorderLayout.CENTER);

        new Timer(1000, e -> actualizarHora()).start();
        actualizarHora();

        setVisible(true);
    }

    private void actualizarHora() {
        LocalTime hora = LocalTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
        lblHora.setText(hora.format(formato));
    }
}
