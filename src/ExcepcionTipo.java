import ClasesJava.Simbolo;
import ClasesJava.Tipo_variable;

public class ExcepcionTipo extends SemanticException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public ExcepcionTipo(Token currentToken, Tipo_variable encontrado, Tipo_variable esperado) {
	super(inicializar(currentToken, encontrado, esperado));
    }

    private static String inicializar(Token currentToken, Tipo_variable encontrado, Tipo_variable esperado) {
	StringBuilder sb = new StringBuilder();

	sb.append("ERROR SEMÁNTICO: Se esperaba un tipo " + esperado + " en la línea: " + currentToken.beginLine
		+ ", columna: " + currentToken.beginColumn + ".\nPero se ha encontrado " + encontrado);

	return sb.toString();
    }
}
