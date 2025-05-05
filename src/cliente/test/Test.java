package cliente.test;

import cliente.clase.Cliente;

public class Test {
    public static void main(String[] args) {
        Cliente c = new Cliente();
        c.enviarNumeros("172.31.116.75",5000,10,12);
    }
}
