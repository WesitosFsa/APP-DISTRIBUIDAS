package pruebarep.servidor.servicio;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;

import pruebarep.servidor.clase.Estudiante;

public class Servicio {
    // Puerto en el que el servidor va a escuchar
    private static final int PUERTO = 4005;

    // Lista para almacenar objetos Persona
    private static final ArrayList<Estudiante> estudiantes = new ArrayList<>();

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
                System.out.println("Estudiante consultado con el ID: " + mensaje);
                String[] partes = mensaje.split(",");

                Estudiante estudiante1 = new Estudiante("00001","Wesitos","0962893787","Software",2,true);
                Estudiante estudiante2 = new Estudiante("00002","Kairos","0962893787","Mecanica",2,false);
                Estudiante estudiante3 = new Estudiante("00003","Yuverly","0962893787","Software",2,true);
                Estudiante estudiante4 = new Estudiante("00004","Juan","0962893787","Software",2,true);
                Estudiante estudiante5 = new Estudiante("00005","Diego","0962893787","Elenctronica",2,false);
                Estudiante estudiante6 = new Estudiante("00006","Lenin","0962893787","Software",2,true);
                Estudiante estudiante7 = new Estudiante("00007","Naim","0962893787","Software",2,false);
                Estudiante estudiante8 = new Estudiante("00008","Eduardo","0962893787","Software",2,true);
                Estudiante estudiante9 = new Estudiante("00009","Joshep Caza","0962893787","Software",5,true);
                Estudiante estudiante10 = new Estudiante("00010","Mateo Garzon","0962893787","Software",5,true);



                estudiantes.add(estudiante1);
                estudiantes.add(estudiante2);
                estudiantes.add(estudiante3);
                estudiantes.add(estudiante4);
                estudiantes.add(estudiante5);
                estudiantes.add(estudiante6);
                estudiantes.add(estudiante7);
                estudiantes.add(estudiante8);
                estudiantes.add(estudiante9);
                estudiantes.add(estudiante10);


                // Variable para la respuesta que se enviará de vuelta
                String respuesta;

                // Verifica que haya al menos una acción y un ID
                if (partes.length >= 1) {
                    String id = partes[0]; // puede ser "crear", "buscar" o "editar"

                    // Switch para ejecutar la acción correspondiente

                            Estudiante e = buscarEstudiante(id);
                            // Si la encuentra, envía su info, si no, dice que no existe
                            respuesta = (e != null) ? e.toString() : "No encontrado";


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

    // Método paa buscar una persona por su ID en la lista
    private Estudiante buscarEstudiante(String id) {
        for (Estudiante e : estudiantes) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null; // Si no se encuentra la persona
    }
}
