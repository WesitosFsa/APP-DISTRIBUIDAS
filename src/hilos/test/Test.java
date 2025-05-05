package hilos.test;

import hilos.clase.*;

import static java.lang.Thread.sleep;

public class Test {
    public static void main(String[] args) {
        Persona p= new Persona();
        p.setNombre("Wesitos");
        p.setDireccion("Sopa de camaron");
        p.setFechaNacimiento("2003");

        ProcesoA a = new ProcesoA("wesitos");
        ProcesoB b = new ProcesoB(100);
        ProcesoC c = new ProcesoC(10);
        Runnable x = new ProcesoD(100);
        Runnable x2 = new ProcesoE("Hola como esta ?");

        Autos auto = new Autos(null,null,0);

        Thread d = new Thread(x);
        Thread ed = new Thread(x2);
        // Paralelismo y Concurrencia Thread and runnable wtf

        // Inicializar el Hilo
        a.start();
        b.start();
        c.start();
        //
        d.start();

        auto.start();



        System.out.println("Nombre: " + p.getNombre());
        System.out.println("Direccion: " + p.getDireccion());
        System.out.println("Fecha Nacimiento: " + p.getFechaNacimiento());


    }
}
