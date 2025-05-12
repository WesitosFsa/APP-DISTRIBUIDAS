package pruebarep.cliente.vista;


import pruebarep.cliente.servicio.Cliente;

import javax.swing.*;
import java.awt.*;

public class VistaCliente extends JFrame {

    private JTextField campoId, campoNombre, campoCedula, campoEdad, campoRespuesta;

    public VistaCliente() {
        setTitle("Gestión de Personas");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 2, 10, 10));

        // Crear campos
        campoId = new JTextField();
        campoNombre = new JTextField();
        campoCedula = new JTextField();
        campoEdad = new JTextField();
        campoRespuesta = new JTextField();
        campoRespuesta.setEditable(false);

        JButton btnCrear = new JButton("Crear");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnEditar = new JButton("Editar");

        // Agregar componentes
        add(new JLabel("ID:"));
        add(campoId);
        add(new JLabel("Nombre:"));
        add(campoNombre);
        add(new JLabel("Cédula:"));
        add(campoCedula);
        add(new JLabel("Edad:"));
        add(campoEdad);
        add(new JLabel("Respuesta:"));
        add(campoRespuesta);
        add(btnCrear);
        add(btnBuscar);
        add(btnEditar);

        // Cliente para enviar peticiones
        Cliente cliente = new Cliente();
        String ipServidor = "127.0.0.1"; // cambia si estás en red
        int puerto = 5000;

        // Acciones
        btnCrear.addActionListener(e -> {
            String id = campoId.getText();
            String nombre = campoNombre.getText();
            String cedula = campoCedula.getText();
            String edad = campoEdad.getText();

            String mensaje = "crear," + id + "," + nombre + "," + cedula + "," + edad;
            String respuesta = cliente.enviarPeticion(ipServidor, puerto, mensaje);
            campoRespuesta.setText(respuesta);
        });

        btnBuscar.addActionListener(e -> {
            String id = campoId.getText();
            String mensaje = "buscar," + id;
            String respuesta = cliente.enviarPeticion(ipServidor, puerto, mensaje);
            campoRespuesta.setText(respuesta);
        });

        btnEditar.addActionListener(e -> {
            String id = campoId.getText();
            String nombre = campoNombre.getText();
            String cedula = campoCedula.getText();
            String edad = campoEdad.getText();

            String mensaje = "editar," + id + "," + nombre + "," + cedula + "," + edad;
            String respuesta = cliente.enviarPeticion(ipServidor, puerto, mensaje);
            campoRespuesta.setText(respuesta);
        });
    }

    public static void main(String[] args) {
        new VistaCliente().setVisible(true);
    }
}