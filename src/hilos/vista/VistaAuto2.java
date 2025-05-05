package hilos.vista;

import hilos.clase.Autos;
import javax.swing.*;
import java.awt.*;

public class VistaAuto2 extends JFrame {

    public VistaAuto2(Autos auto) {
        setTitle("Datos del Auto");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));

        add(new JLabel("Marca: " + auto.getMarca()));
        add(new JLabel("Modelo: " + auto.getModelo()));
        add(new JLabel("Precio:" + auto.getPrecio()));

    }
}

