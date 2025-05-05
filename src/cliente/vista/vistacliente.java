package cliente.vista;

import cliente.clase.Cliente;

import javax.swing.*;
import java.awt.*;

public class vistacliente extends JFrame {
    public vistacliente() {
        setTitle("Ingreso de Numeros");
        setSize(300, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        JTextField num1 = new JTextField();
        JTextField num2 = new JTextField();
        JTextField resultado = new JTextField();

        JButton botonsumar = new JButton("+");
        JButton botonrestar = new JButton("-");
        JButton botonmultiplicar = new JButton("*");
        JButton botondividir = new JButton("/");


        add(new JLabel("num1:"));
        add(num1);
        add(new JLabel("num2:"));
        add(num2);
        add(new JLabel("Resultado:"));
        add(resultado);
        add(new JLabel());
        add(botonsumar);
        add(botonrestar);
        add(botonmultiplicar);
        add(botondividir);

        botonsumar.addActionListener(e -> {
            int numero1 = Integer.parseInt(num1.getText());
            int numero2 = Integer.parseInt(num2.getText());
            Cliente c = new Cliente();
            c.enviarNumeros("172.31.116.75",5000,2,2);

        });
    }

    public static void main(String[] args) {
        new vistacliente().setVisible(true);
    }

}
