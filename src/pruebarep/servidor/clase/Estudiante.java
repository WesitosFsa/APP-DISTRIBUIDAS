package pruebarep.servidor.clase;

public class Estudiante {
    private String id;
    private String nombre;
    private String telefono;
    private String carrera;
    private int semestre;
    private boolean gratuidad;

    public Estudiante(String id, String nombre, String telefono,String carrera, int semestre, boolean gratuidad) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.semestre = semestre;
        this.carrera = carrera;
        this.gratuidad = gratuidad;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getCarrera() {return carrera;}
    public int getSemestre() { return semestre; }
    public boolean getgratuidad() {return gratuidad;}


    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setSemestre(int semestre) { this.semestre = semestre; }
    public void setCarrera(String carrera) {this.carrera = carrera;}
    public void setGratuidad(boolean gratuidad) {this.gratuidad = gratuidad;}

    @Override
    public String toString() {
        return "id: " + id + ", nombre: " + nombre + ", telefono: " + telefono + ", semestre: " + semestre + ", carrera: " + carrera + ", gratuidad: " + gratuidad;
    }
}
