package servidor.servicio;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class Servidor {
    public void servicio() {
        int puerto = 4005;
        try {
            DatagramSocket socket = new DatagramSocket(puerto);
            System.out.println("Servidor UDP corriendo en el puerto " + puerto + "...");
            byte[] bufferEntrada = new byte[1024];
            while (true) {
                DatagramPacket paqueteEntrada = new DatagramPacket(bufferEntrada, bufferEntrada.length);
                socket.receive(paqueteEntrada);
                String mensaje = new String(paqueteEntrada.getData(), 0, paqueteEntrada.getLength());
                System.out.println("Mensaje recibido: " + mensaje);
                String[] partes = mensaje.split(",");
                if (partes.length == 3) {
                    int num1 = Integer.parseInt(partes[0].trim());
                    int num2 = Integer.parseInt(partes[1].trim());
                    String operacion = partes[2].trim();
                    String respuesta = switch (operacion) {
                        case "+" -> "Resultado: " + (num1 + num2);
                        case "-" -> "Resultado: " + (num1 - num2);
                        case "*" -> "Resultado: " + (num1 * num2);
                        case "/" -> num2 != 0
                                ? "Resultado: " + ((double) num1 / num2)
                                : "Error: División por cero";
                        default -> "Operación no válida";
                    };
                    byte[] bufferSalida = respuesta.getBytes();
                    DatagramPacket paqueteSalida = new DatagramPacket(
                            bufferSalida, bufferSalida.length,
                            paqueteEntrada.getAddress(), paqueteEntrada.getPort());
                    socket.send(paqueteSalida);
                    System.out.println("Respuesta enviada: " + respuesta);
                } else {
                    System.out.println("Errorn");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
