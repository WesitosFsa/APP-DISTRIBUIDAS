package pruebarep.servidor.servicio;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import pruebarep.cliente.clase.Persona;

public class Servicio {
    private static final int PUERTO = 5000;
    private static final ArrayList<Persona> personas = new ArrayList<>();

    public void servicio() {
        try (DatagramSocket socket = new DatagramSocket(PUERTO)) {
            System.out.println("Servicio corriendo en puerto " + PUERTO + "...");

            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
                socket.receive(paquete);

                String mensaje = new String(paquete.getData(), 0, paquete.getLength());
                String[] partes = mensaje.split(",");
                String respuesta;

                if (partes.length >= 2) {
                    String accion = partes[0];
                    String id = partes[1];

                    switch (accion) {
                        case "crear" -> {
                            if (buscarPersona(id) == null && partes.length == 5) {
                                String nombre = partes[2];
                                String cedula = partes[3];
                                int edad = Integer.parseInt(partes[4]);
                                personas.add(new Persona(id, nombre, cedula, edad));
                                respuesta = "Persona creada";
                            } else {
                                respuesta = "ID duplicado o datos incompletos";
                            }
                        }
                        case "buscar" -> {
                            Persona p = buscarPersona(id);
                            respuesta = (p != null) ? p.toString() : "No encontrado";
                        }
                        case "editar" -> {
                            Persona p = buscarPersona(id);
                            if (p != null && partes.length == 5) {
                                p.setNombre(partes[2]);
                                p.setCedula(partes[3]);
                                p.setEdad(Integer.parseInt(partes[4]));
                                respuesta = "Persona actualizada";
                            } else {
                                respuesta = "Persona no encontrada o datos incompletos";
                            }
                        }
                        default -> respuesta = "Acción no reconocida";
                    }
                } else {
                    respuesta = "Formato inválido";
                }

                byte[] bufferRespuesta = respuesta.getBytes();
                DatagramPacket paqueteRespuesta = new DatagramPacket(
                        bufferRespuesta, bufferRespuesta.length,
                        paquete.getAddress(), paquete.getPort());
                socket.send(paqueteRespuesta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Persona buscarPersona(String id) {
        for (Persona p : personas) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
}
