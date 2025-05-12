package pruebarep.cliente.servicio;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {
    public String enviarPeticion(String ip, int puerto, String mensaje) {
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress direccion = InetAddress.getByName(ip);
            byte[] datos = mensaje.getBytes();
            DatagramPacket paquete = new DatagramPacket(datos, datos.length, direccion, puerto);
            socket.send(paquete);

            byte[] bufferRespuesta = new byte[1024];
            DatagramPacket respuesta = new DatagramPacket(bufferRespuesta, bufferRespuesta.length);
            socket.receive(respuesta);

            return new String(respuesta.getData(), 0, respuesta.getLength());
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al conectar";
        }
    }
}
