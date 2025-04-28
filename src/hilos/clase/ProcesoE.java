package hilos.clase;

import javax.swing.*;

public class ProcesoE implements Runnable{

    private String mensaje;

    public ProcesoE(String mensaje) {
        this.mensaje = mensaje;
    }

    public void imprimir(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }

    @Override
    public void run() {
        imprimir(mensaje);

    }
}
