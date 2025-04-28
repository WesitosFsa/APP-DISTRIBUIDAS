package clase.vista;
import clase.impl.OperacionesImpl;
import clase.interfaz.Operaciones;
import javax.swing.*;

public class Vista extends JFrame {
    private JPanel ventana;
    private JTextField num1;
    private JTextField num2;
    private JButton sumas;
    private JButton multiplicacion;
    private JButton restas;
    private JButton division;
    private JLabel resultado;
    private JButton sumar;
    public Vista(){
        setContentPane(ventana);
        setTitle("Calculadora");
        setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        String n1 = num1.getText();
        String n2 = num2.getText();

        double x = Double.parseDouble(String.valueOf(n1));
        double y = Double.parseDouble(String.valueOf(n2));
        Operaciones op = new OperacionesImpl();

        sumas.addActionListener(e -> {
            String texto = "El resultado es :"+ op.sumar(x,y);
            resultado.setText(texto);
        });
        restas.addActionListener(e -> {
            String texto = "El resultado es :"+ op.restar(x,y);
            resultado.setText(texto);
        });
        multiplicacion.addActionListener(e -> {
            String texto = "El resultado es :"+ op.multiplicar(x,y);
            resultado.setText(texto);

        });
        division.addActionListener(e -> {
            String texto = "El resultado es :"+ op.dividir(x,y);
            resultado.setText(texto);
        });




    }

    public static void main(String[] args) {
        new Vista();

    }
}