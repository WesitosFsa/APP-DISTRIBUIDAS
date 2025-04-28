package clase.impl;

public class OperacionesImpl implements clase.interfaz.Operaciones {

    @Override
    public double sumar(double x, double y) {
        return x+y;
    }

    @Override
    public double restar(double x, double y) {
        return x-y;
    }

    @Override
    public double multiplicar(double x, double y) {
        return x*y;
    }

    @Override
    public double dividir(double x, double y) {
        return x/y;
    }
}
