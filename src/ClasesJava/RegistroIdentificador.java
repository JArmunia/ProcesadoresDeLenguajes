package clasesJava;

public class RegistroIdentificador {
    public String nombre;
    public boolean isVector;
    public int size;
    
    public RegistroIdentificador(String nombre, boolean isVector, int size) {
	this.nombre= nombre;
	this.isVector = isVector;
	this.size = size;
    }
    
    public RegistroIdentificador(String nombre) {
	this.nombre= nombre;
	this.isVector = false;
	this.size = 1;
    }
    
}
