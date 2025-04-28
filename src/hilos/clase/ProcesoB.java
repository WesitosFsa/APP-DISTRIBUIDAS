package hilos.clase;

public class ProcesoB extends Thread{

    private int n;

    public ProcesoB(int n) {
        this.n = n;
    }

    public void contar(int n){
        try {
            for (int i = 1; i < n; i++) {
                sleep(1000);
                System.out.println("Numero en itteraccion " +i);
            }


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void run() {
        contar(n);
    }
}
