package aplicaciones;

import javax.swing.*;

import Calcu.Calculadora;

import java.awt.*;
import java.awt.event.*;

public class CalculadoraVentana extends JFrame {

    private JTextField pantalla;
    private String operacion = "";
    private double primerNumero = 0;
    private Calculadora calc;

    public CalculadoraVentana() {
        calc = new Calculadora();
        setTitle("Calculadora");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        pantalla = new JTextField();
        pantalla.setEditable(false);
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setFont(new Font("Arial", Font.BOLD, 24));
        add(pantalla, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] botones = {
            "7","8","9","/",
            "4","5","6","*",
            "1","2","3","-",
            "0","C","=","+"
        };

        for (String texto : botones) {
            JButton btn = new JButton(texto);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.addActionListener(e -> botonPresionado(e.getActionCommand()));
            panelBotones.add(btn);
        }

        add(panelBotones, BorderLayout.CENTER);
        setVisible(true);
    }

    private void botonPresionado(String comando) {
        try {
            switch (comando) {
                case "C":
                    pantalla.setText("");
                    operacion = "";
                    primerNumero = 0;
                    break;
                case "+": case "-": case "*": case "/":
                    primerNumero = Double.parseDouble(pantalla.getText());
                    operacion = comando;
                    pantalla.setText("");
                    break;
                case "=":
                    double segundoNumero = Double.parseDouble(pantalla.getText());
                    double resultado = 0;
                    switch (operacion) {
                        case "+": resultado = calc.sumar(primerNumero, segundoNumero); break;
                        case "-": resultado = calc.restar(primerNumero, segundoNumero); break;
                        case "*": resultado = calc.multiplicar(primerNumero, segundoNumero); break;
                        case "/": resultado = calc.dividir(primerNumero, segundoNumero); break;
                    }
                    pantalla.setText(String.valueOf(resultado));
                    operacion = "";
                    break;
                default:
                    pantalla.setText(pantalla.getText() + comando);
                    break;
            }
        } catch (Exception e) {
            pantalla.setText("Error");
        }
    }
}
