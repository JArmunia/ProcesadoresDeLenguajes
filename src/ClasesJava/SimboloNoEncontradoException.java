package clasesJava;

public class SimboloNoEncontradoException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public SimboloNoEncontradoException(String simbolo) {
	super("El simbolo " + simbolo + " no se ha encontrado");
    }
    
    public SimboloNoEncontradoException(Simbolo simbolo) {
	super("El simbolo " + simbolo.getNombre() + " de tipo " + simbolo.getTipoSimbolo() + " no se ha encontrado");
    }
    
    
    
}
