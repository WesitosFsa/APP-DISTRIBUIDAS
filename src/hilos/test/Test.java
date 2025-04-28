package hilos.test;

import hilos.clase.ProcesoA;
import hilos.clase.ProcesoB;
import hilos.clase.ProcesoC;

public class Test {
    public static void main(String[] args) {
        ProcesoA a = new ProcesoA();
        ProcesoB b = new ProcesoB();
        ProcesoC c = new ProcesoC();
        c.dividir(5);
        a.saludar("wesitos");
        b.contar(10);
    }
}
