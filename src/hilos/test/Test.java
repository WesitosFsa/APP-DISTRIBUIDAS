package hilos.test;

import hilos.clase.ProcesoA;
import hilos.clase.ProcesoB;
import hilos.clase.ProcesoC;
import hilos.clase.ProcesoD;

public class Test {
    public static void main(String[] args) {
        ProcesoA a = new ProcesoA("wesitos");
        ProcesoB b = new ProcesoB(5);
        ProcesoC c = new ProcesoC(10);
        Runnable x = new ProcesoD(100);
        Thread d = new Thread(x);
        // Paralelismo y Concurrencia Thread and runnable wtf

        // Inicializar el Hilo
        a.start();
        b.start();
        c.start();
        //
        d.start();

    }
}
