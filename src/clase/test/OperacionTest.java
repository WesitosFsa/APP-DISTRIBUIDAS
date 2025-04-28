package clase.test;
import clase.impl.OperacionesImpl;
import clase.interfaz.Operaciones;

import javax.swing.*;
import java.util.Scanner;

public class OperacionTest {
    public static void main(String[] args) {
        System.out.println("test");
        System.out.println("jaja xd");
        Operaciones op = new OperacionesImpl();
        Scanner ENTRADA = new Scanner(System.in);
        double x = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el primero numero"));
        double y=Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el primero numero"));

        JOptionPane.showMessageDialog(null,"La respuesta es :" + op.sumar(x,y));
        System.out.println("La suma es "+ op.sumar(x,y));
    }

}
