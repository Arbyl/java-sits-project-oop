abstract class Persona {
    protected String nombre;
    protected int edad;
    protected int id;

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }   

    public void setId(int id) {
        this.id = id;
    }

}
