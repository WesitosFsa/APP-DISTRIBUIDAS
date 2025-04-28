package hilos.clase;

public class ProcesoC extends Thread {

    private int n;

    public ProcesoC(int n) {
        this.n = n;
    }

    public void dividir(int n){
        for (int i = 10; i > 1; i--) {
            System.out.println(n/i);

        }
    }

    @Override
    public void run() {
        dividir(n);
    }
}
