import clasesJava.Simbolo;

public class ExcepcionTablaSimbolos extends SemanticException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public ExcepcionTablaSimbolos(Token currentToken, int nivel, Simbolo conflicto) {
	super(inicializar(currentToken, nivel, conflicto));
    }

    public ExcepcionTablaSimbolos(String identificador, int linea, int nivel, Simbolo conflicto) {
	super(inicializar(identificador, linea, nivel, conflicto));
    }

    private static String inicializar(Token currentToken, int nivel, Simbolo conflicto) {
	StringBuilder sb = new StringBuilder();

	sb.append(
		"ERROR SEMÁNTICO: Se ha producido un error al intentar declarar " + currentToken.image + " en el nivel "
			+ nivel + " en la línea: " + currentToken.beginLine + ", columna: " + currentToken.beginColumn
			+ ".\nPero ya hay un/a " + conflicto.getTipoSimbolo().toString().toLowerCase()
			+ " con ese nombre en el nivel " + conflicto.getNivel());

	return sb.toString();
    }

    private static String inicializar(String identificador, int linea, int nivel, Simbolo conflicto) {
	StringBuilder sb = new StringBuilder();

	sb.append("ERROR SEMÁNTICO: Se ha producido un error al intentar declarar " + identificador + " en el nivel "
		+ nivel + " en la línea: " + linea + ".\nPero ya hay un/a "
		+ conflicto.getTipoSimbolo().toString().toLowerCase() + " con ese nombre en el nivel "
		+ conflicto.getNivel());

	return sb.toString();
    }
}
