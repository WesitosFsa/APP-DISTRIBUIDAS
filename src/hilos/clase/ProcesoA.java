package hilos.clase;

import javax.naming.Name;

public class ProcesoA extends Thread{

    private String Name;

    public ProcesoA(String Name) {
        this.Name = Name;
    }



    public void saludar(String Name){
        System.out.println("Hola " + Name);
    }

    @Override
    public void run() {
        saludar(Name);
    }
}
