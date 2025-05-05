package hilos.vista;
import hilos.clase.Autos;
import javax.swing.*;
import java.awt.*;

public class VistaAuto extends JFrame {



    public VistaAuto() {
        setTitle("Ingreso de Auto");
        setSize(300, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        JTextField campoMarca = new JTextField();
        JTextField campoModelo = new JTextField();
        JTextField campoPrecio = new JTextField();

        JButton botonEnviar = new JButton("Enviar");

        add(new JLabel("Marca:"));
        add(campoMarca);
        add(new JLabel("Modelo:"));
        add(campoModelo);
        add(new JLabel("Precio:"));
        add(campoPrecio);
        add(new JLabel());
        add(botonEnviar);
        botonEnviar.addActionListener(e -> {
            String marca = campoMarca.getText();
            String modelo = campoModelo.getText();
            double precio = Double.parseDouble(campoPrecio.getText());
            Autos auto = new Autos(marca, modelo, precio);
            new VistaAuto2(auto).setVisible(true);

            dispose();
        });
    }

}
