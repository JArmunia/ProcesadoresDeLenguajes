package clasesJava;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GeneracionCodigo {
    private int etiqueta = -1;
    private boolean generaCodigo = true;
    private PrintWriter pw = null;
    private static GeneracionCodigo instancia = null;
    private StringBuffer sb;

    private GeneracionCodigo(String filePath) {
	    try {
		pw = new PrintWriter(new FileWriter(filePath));
		sb = new StringBuffer();
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("Error en el fichero de salida de la generación de código");
		e.printStackTrace();
		System.exit(-1);
	    }
	    

    }
    
    // Singleton
    public static GeneracionCodigo getInstancia(String filePath) {
	if (instancia == null) {
	    instancia = new GeneracionCodigo(filePath);
	}
	return instancia;
    }

    public String getEtiqueta() {
	etiqueta++;
	return "L" + etiqueta;
    }

    public void pararGeneracionCodigo() {
	generaCodigo = false;
    }

    public void escribir(String line) {
	if (!line.startsWith(";")) {
	    line = "    " + line;
	}
	System.out.println(line);
	sb.append(line + "\n");
    }
    
    public void escribirPrograma() {
	if (generaCodigo) {
	    pw.write(sb.toString());
	    pw.close();
	    System.out.println("Programa escrito");
	}else {
	    System.err.println("El programa tiene errores, por lo que no se ha generado código");
	}
    }    

}
