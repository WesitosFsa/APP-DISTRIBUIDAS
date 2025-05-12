package pruebarep.cliente.clase;

public class Persona {
    private String id;
    private String nombre;
    private String cedula;
    private int edad;

    public Persona(String id, String nombre, String cedula, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCedula() { return cedula; }
    public int getEdad() { return edad; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCedula(String cedula) { this.cedula = cedula; }
    public void setEdad(int edad) { this.edad = edad; }

    @Override
    public String toString() {
        return "id: " + id + ", nombre: " + nombre + ", cedula: " + cedula + ", edad: " + edad;
    }
}
