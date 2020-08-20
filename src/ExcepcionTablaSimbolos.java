import ClasesJava.Simbolo;

public class ExcepcionTablaSimbolos extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public ExcepcionTablaSimbolos(Token currentToken, Simbolo conflicto) {
	super(inicializar(currentToken, conflicto));
    }
    
    private static String inicializar(Token currentToken, Simbolo conflicto) {
	StringBuilder sb = new StringBuilder();
	
	sb.append("ERROR SEMÁNTICO: Se ha producido un error al intentar declarar " + currentToken.image 
		+ " en la línea: " + currentToken.beginLine + ", columna: " + currentToken.beginColumn + 
		".\nPero ya hay un/a " + conflicto.getTipoSimbolo().toString().toLowerCase() + " con ese nombre."); 
	
	return sb.toString();
    }
}
