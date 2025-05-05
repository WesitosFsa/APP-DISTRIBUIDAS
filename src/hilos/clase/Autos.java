package hilos.clase;

import hilos.vista.VistaAuto;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

public class Autos extends Thread {

    @Getter @Setter private String marca;
    @Getter @Setter private String modelo;
    @Getter @Setter private double precio;

    public Autos(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    @Override
    public void run() {
        SwingUtilities.invokeLater(() -> new VistaAuto().setVisible(true));

    }
}
