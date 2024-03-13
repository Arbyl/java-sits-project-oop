public class Asistente extends Persona{
    private int dineroActual;

    public Asistente(String pNombre, int pId, int pEdad, int pDineroActual){
        id = pId;
        nombre =pNombre;
        edad = pEdad;
        dineroActual = pDineroActual;
    }

    public int getDineroActual() {
        return dineroActual;
    }

    public void setDineroActual(int dineroActual) {
        this.dineroActual = dineroActual;
    }
}
