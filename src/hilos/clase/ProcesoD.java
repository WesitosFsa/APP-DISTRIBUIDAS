package hilos.clase;

public class ProcesoD implements Runnable{

    private int n;

    public ProcesoD(int n) {
        this.n = n;
    }

    public void imprimir(int n){
        System.out.println("Hola este es el proceso D");

        for (int i = 0; i < n; i++) {
            System.out.println("****************");
        }
    }

    @Override
    public void run() {
        imprimir(n);
    }
}
