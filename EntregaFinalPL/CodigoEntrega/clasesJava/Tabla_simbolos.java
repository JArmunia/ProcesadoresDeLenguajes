package clasesJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Tabla_simbolos {

    private ArrayList<ArrayList<Simbolo>> vector;
    private int size;
    private static Tabla_simbolos instancia;
    private static Integer[] T;

    private Tabla_simbolos(int size) {
	this.size = size;
	T = new Integer[256];
	vector = new ArrayList<ArrayList<Simbolo>>();
	for (int i = 0; i < size; i++) {
	    vector.add(new ArrayList<Simbolo>());
	}

	ArrayList<Integer> l = new ArrayList<>();
	for (int i = 0; i < 256; i++) {
	    l.add(i);
	}
	Collections.shuffle(l);
	l.toArray(T);
    }

    /**
     * Crea una tabla de símbolos vacía. Este procedimiento debe invocarse antes de
     * hacer ninguna operación con la tabla de símbolos.
     * 
     * @param size
     * @return tabla de simbolos (Singleton)
     */
    public static Tabla_simbolos inicializar_tabla(int size) {
	if (instancia == null) {

	    instancia = new Tabla_simbolos(size);
	}
	return instancia;
    }

    /**
     * Devuelve verdadero si el está el símbolo con el nivel indicado
     * 
     * @param nombre
     * @param nivel
     * @return
     */
    private boolean esta(String nombre, int nivel) {
	for (Simbolo simbolo : vector.get(getPosicion(nombre))) {
	    if (simbolo.getNombre().equals(nombre) && simbolo.getNivel() == nivel) {

		return true;
	    }
	}
	return false;
    }

    /**
     * Busca en la tabla el símbolo de mayor nivel cuyo nombre coincida con el del
     * parámetro (se distinguen minúsculas y mayúsculas). Si existe, devuelve un
     * puntero como resultado, de lo contrario devuelve null.
     * 
     * @param nombre
     * @return
     * @throws SimboloNoEncontradoException
     */
    public Simbolo buscar_simbolo(String nombre) {
	int posicion = hashCode(nombre) % size;
	for (Simbolo simbolo : vector.get(posicion)) {
	    if (simbolo.getNombre().equals(nombre)) {
		return simbolo;
	    }
	}
	return null;
    }

    /**
     * Introduce un símbolo en la tabla hash
     * 
     * @param simbolo
     */
    private void introducir(Simbolo simbolo) {
	vector.get(getPosicion(simbolo.getNombre())).add(0, simbolo);
    }

    /**
     * Introduce en la tabla un simbolo PROGRAMA, con el nombre del parametro, de
     * nivel 0, con la direccion del parametro. Dado que debe ser el primer simbolo
     * a introducir, NO SE VERIFICA QUE EL SIMBOLO YA EXISTA.
     * 
     * @param nombre
     * @param dir
     * @return
     */
    public Simbolo introducir_programa(String nombre, long dir) {
	Simbolo programa = Simbolo.programa(nombre, dir);

	introducir(programa);

	return programa;
    }

    /**
     * Si existe un símbolo en la tabla del mismo nivel y con el mismo nombre,
     * devuelve NULL. De lo contrario, introduce un símbolo VARIABLE (simple) con
     * los datos de los argumentos.
     *
     * 
     * @param nombre
     * @param variable
     * @param nivel
     * @param dir
     * @return
     */
    public Simbolo introducir_variable(String nombre, Tipo_variable t_variable, int nivel, long dir) {
	Simbolo variable = null;
	if (!esta(nombre, nivel)) {

	    variable = Simbolo.variable(nombre, t_variable, nivel, dir);
	    variable.setParametro(Clase_parametro.REF);
	    introducir(variable);
	}
	return variable;
    }

    /**
     * Si existe un símbolo en la tabla del mismo nivel y con el mismo nombre,
     * devuelve NULL. De lo contrario, introduce un símbolo ACCION (simple) con los
     * datos de los argumentos.
     * 
     * @param nombre
     * @param nivel
     * @param dir
     * @return
     */
    public Simbolo introducir_accion(String nombre, int nivel, String etiqueta) {
	Simbolo accion = null;
	if (!esta(nombre, nivel)) {

	    accion = Simbolo.accion(nombre, nivel, etiqueta);
	    introducir(accion);
	}
	return accion;
    }

    /**
     * Si existe un símbolo en la tabla del mismo nivel y con el mismo nombre,
     * devuelve NULL. De lo contrario, introduce un símbolo PARAMETRO con los datos
     * de los argumentos
     * 
     * @param nombre
     * @param variable
     * @param parametro
     * @param nivel
     * @param dir
     * @return
     */
    public Simbolo introducir_parametro(String nombre, Tipo_variable variable, Clase_parametro c_parametro, int nivel,
	    long dir) {
	Simbolo parametro = null;
	if (!esta(nombre, nivel)) {

	    parametro = Simbolo.parametro(nombre, variable, c_parametro, nivel, dir);
	    introducir(parametro);
	}
	return parametro;
    }

    /**
     * Elimina de la tabla todos los símbolos PROGRAMA de nivel 0 (debería haber uno
     * solo).
     */
    public void eliminar_programa() {
	for (ArrayList<Simbolo> lista : vector) {
	    lista.removeIf(simbolo -> simbolo.getTipoSimbolo() == Tipo_simbolo.PROGRAMA && simbolo.getNivel() == 0);
	}
    }

    /**
     * Elimina de la tabla todas las variables que sean del nivel del argumento. NO
     * ELIMINA PARÁMETROS.
     * 
     * @param nivel
     */
    public void eliminar_variables(int nivel) {
	for (ArrayList<Simbolo> lista : vector) {
	    lista.removeIf(simbolo -> simbolo.getTipoSimbolo() == Tipo_simbolo.VARIABLE && simbolo.getNivel() == nivel);
	}
    }

    /**
     * Marca todos los parámetros de un nivel como ocultos para que no puedan ser
     * encontrados, pero se mantenga la definición completa de la acción donde están
     * declarados para verificación de invocaciones a la acción.
     * 
     * @param nivel
     */
    public void ocultar_parametros(int nivel) {
	for (ArrayList<Simbolo> lista : vector) {
	    for (Simbolo simbolo : lista) {
		if (simbolo.getTipoSimbolo() == Tipo_simbolo.PARAMETRO && simbolo.getNivel() == nivel) {
		    simbolo.setVisible(false);
		}
	    }
	}
    }

    /**
     * Elimina de la tabla todas los parámetros que hayan sido ocultados
     * previamente.
     * 
     * @param nivel
     */
    private void eliminar_parametros_ocultos(int nivel) {
	for (ArrayList<Simbolo> lista : vector) {
	    lista.removeIf(simbolo -> simbolo.getTipoSimbolo() == Tipo_simbolo.PARAMETRO && simbolo.getNivel() == nivel
		    && !simbolo.esVisible());
	}
    }

    /**
     * Elimina de la tabla todas los procedimientos de un nivel. LOS PARAMETROS DE
     * ESTAS ACCIONES DEBEN SER ELIMINADOS TAMBIEN PARA MANTENER LA COHERENCIA DE LA
     * TABLA.
     * 
     * @param nivel
     */
    public void eliminar_acciones(int nivel) {
	for (ArrayList<Simbolo> lista : vector) {
	    lista.removeIf(simbolo -> simbolo.getTipoSimbolo() == Tipo_simbolo.ACCION && simbolo.getNivel() == nivel);
	}
	ocultar_parametros(nivel + 1);
	// Elimino los parámetros de la acción ya que se pueden acceder desde la lista
	// de parámetros de la acción
	eliminar_parametros_ocultos(nivel);
    }

    /**
     * Obtiene la posición que corresponde a un código hash
     * 
     * @param nombre
     * @return
     */
    private int getPosicion(String nombre) {
	return hashCode(nombre) % this.size;
    }

    /**
     * Función hash de Pearson
     * 
     * @param key
     * @return
     */
    private int hashCode(String key) {
	char[] C = key.toCharArray();
	int h = 0;
	for (int i = 0; i < key.length(); i++) {
	    h = T[h ^ C[i]];
	}
	return h;
    }

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < vector.size(); i++) {
	    ArrayList<Simbolo> bloque = vector.get(i);
	    if (bloque.size() > 0) {
		sb.append("\nBloque " + i
			+ "______________________________________________________________________________________\n|");
	    }
	    for (Simbolo simbolo : bloque) {
		sb.append(simbolo.toString() + " | ");
	    }

	}
	return sb.toString();
    }

}
