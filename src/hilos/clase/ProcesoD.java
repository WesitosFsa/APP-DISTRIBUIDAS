package hilos.clase;

public class ProcesoD extends Thread{


    public void imprimir(){
        System.out.println("Hola este es el proceso D");

        for (int i = 0; i < 100; i++) {
            System.out.print("*");
        }
    }

    @Override
    public void run() {
        imprimir();
    }
}
