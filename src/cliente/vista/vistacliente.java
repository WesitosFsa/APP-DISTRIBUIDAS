package cliente.vista;

import cliente.clase.Cliente;

import javax.swing.*;
import java.awt.*;

public class vistacliente extends JFrame {
    public vistacliente() {
        setTitle("Calculadora Cliente");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));
        JTextField num1 = new JTextField();
        JTextField num2 = new JTextField();
        JTextField resultado = new JTextField();
        resultado.setEditable(false);

        JButton botonsumar = new JButton("+");
        JButton botonrestar = new JButton("-");
        JButton botonmultiplicar = new JButton("*");
        JButton botondividir = new JButton("/");

        add(new JLabel("Num1:"));
        add(num1);
        add(new JLabel("Num2:"));
        add(num2);
        add(new JLabel("Resultado:"));
        add(resultado);
        add(botonsumar);
        add(botonrestar);
        add(botonmultiplicar);
        add(botondividir);


        botonsumar.addActionListener(e -> ejecutarOperacion(num1, num2, resultado, "+"));
        botonrestar.addActionListener(e -> ejecutarOperacion(num1, num2, resultado, "-"));
        botonmultiplicar.addActionListener(e -> ejecutarOperacion(num1, num2, resultado, "*"));
        botondividir.addActionListener(e -> ejecutarOperacion(num1, num2, resultado, "/"));
    }

    private void ejecutarOperacion(JTextField num1, JTextField num2, JTextField resultado, String operacion) {
        try {
            int n1 = Integer.parseInt(num1.getText());
            int n2 = Integer.parseInt(num2.getText());

            Cliente c = new Cliente();
            String respuesta = c.enviarNumeros("192.168.3.17", 5000, n1, n2, operacion);
            resultado.setText(respuesta);

        } catch (NumberFormatException e) {
            resultado.setText("Errors");
        }
    }

}
