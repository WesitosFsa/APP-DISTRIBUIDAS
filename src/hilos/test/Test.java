package hilos.test;

import hilos.clase.ProcesoA;
import hilos.clase.ProcesoB;
import hilos.clase.ProcesoC;

public class Test {
    public static void main(String[] args) {
        ProcesoA a = new ProcesoA("wesitos");
        ProcesoB b = new ProcesoB(5);
        ProcesoC c = new ProcesoC(10);

        // Inicializar el Hilo
        a.start();
        b.start();
        c.start();

    }
}
