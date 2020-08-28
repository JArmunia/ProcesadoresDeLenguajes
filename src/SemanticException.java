import clasesJava.Simbolo;

public class SemanticException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public SemanticException(String message) {
	super(message);
    }

    public SemanticException(Token currentToken, String errormsg) {
	super(inicializar(currentToken, errormsg));
    }

    private static String inicializar(Token currentToken, String errormsg) {
	StringBuilder sb = new StringBuilder();

	sb.append("ERROR SEMÁNTICO: " + errormsg + "\nEn el token: " + currentToken.image + ", línea: "
		+ currentToken.beginLine + ", columna: " + currentToken.beginColumn);

	return sb.toString();
    }
}
