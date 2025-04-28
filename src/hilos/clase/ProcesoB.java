package hilos.clase;

public class ProcesoB extends Thread{

    private int n;

    public ProcesoB(int n) {
        this.n = n;
    }

    public void contar(int n){
        for (int i = 1; i < n; i++) {
            System.out.println("Numero en itteraccion " +i);
        }
    }

    @Override
    public void run() {
        contar(n);
    }
}
