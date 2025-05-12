package pruebarep.servidor.servicio;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import pruebarep.cliente.clase.Persona;

public class Servicio {
    // Puerto en el que el servidor va a escuchar
    private static final int PUERTO = 5000;

    // Lista para almacenar objetos Persona
    private static final ArrayList<Persona> personas = new ArrayList<>();

    // Método que arranca el servicio UDP
    public void servicio() {
        try (DatagramSocket socket = new DatagramSocket(PUERTO)) {
            // Imprime que el servicio está corriendo
            System.out.println("Servicio corriendo en puerto " + PUERTO + "...");

            // Bucle infinito para recibir y responder mensajes
            while (true) {
                // Buffer para recibir los datos entrantes
                byte[] buffer = new byte[1024];

                // Objeto para recibir el paquete UDP
                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
                socket.receive(paquete); // Espera y recibe un paquete

                // Convierte los bytes recibidos en un String
                String mensaje = new String(paquete.getData(), 0, paquete.getLength());

                // Divide el mensaje por comas (formato esperado: accion,id,nombre,cedula,edad)
                String[] partes = mensaje.split(",");

                // Variable para la respuesta que se enviará de vuelta
                String respuesta;

                // Verifica que haya al menos una acción y un ID
                if (partes.length >= 2) {
                    String accion = partes[0]; // puede ser "crear", "buscar" o "editar"
                    String id = partes[1];

                    // Switch para ejecutar la acción correspondiente
                    switch (accion) {
                        case "crear" -> {
                            // Si no existe ya una persona con ese ID y hay suficientes datos
                            if (buscarPersona(id) == null && partes.length == 5) {
                                String nombre = partes[2];
                                String cedula = partes[3];
                                int edad = Integer.parseInt(partes[4]);

                                // Crea y agrega la nueva persona a la lista
                                personas.add(new Persona(id, nombre, cedula, edad));
                                respuesta = "Persona creada";
                            } else {
                                // ID ya existe o datos incompletos
                                respuesta = "ID duplicado o datos incompletos";
                            }
                        }
                        case "buscar" -> {
                            // Busca la persona por ID
                            Persona p = buscarPersona(id);
                            // Si la encuentra, envía su info, si no, dice que no existe
                            respuesta = (p != null) ? p.toString() : "No encontrado";
                        }
                        case "editar" -> {
                            // Busca a la persona que se quiere editar
                            Persona p = buscarPersona(id);
                            // Si existe y hay suficientes datos, actualiza sus valores
                            if (p != null && partes.length == 5) {
                                p.setNombre(partes[2]);
                                p.setCedula(partes[3]);
                                p.setEdad(Integer.parseInt(partes[4]));
                                respuesta = "Persona actualizada";
                            } else {
                                respuesta = "Persona no encontrada o datos incompletos";
                            }
                        }
                        default -> respuesta = "Acción no reconocida"; // Si la acción no es válida
                    }
                } else {
                    respuesta = "Formato inválido"; // Si no se recibió ni acción ni ID
                }

                // Convierte la respuesta a bytes
                byte[] bufferRespuesta = respuesta.getBytes();

                // Prepara un paquete UDP de respuesta al cliente
                DatagramPacket paqueteRespuesta = new DatagramPacket(
                        bufferRespuesta, bufferRespuesta.length,
                        paquete.getAddress(), paquete.getPort());

                // Envía la respuesta de vuelta al cliente
                socket.send(paqueteRespuesta);
            }
        } catch (Exception e) {
            // Si ocurre algún error, se imprime el stack trace
            e.printStackTrace();
        }
    }

    // Método para buscar una persona por su ID en la lista
    private Persona buscarPersona(String id) {
        for (Persona p : personas) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null; // Si no se encuentra la persona
    }
}
