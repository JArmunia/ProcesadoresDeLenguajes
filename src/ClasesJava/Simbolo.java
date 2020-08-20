package ClasesJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.lang.UnsupportedOperationException;

public class Simbolo {

    private Tipo_simbolo tipo;
    private Tipo_variable variable;
    private Clase_parametro parametro;

    private String nombre;
    private int nivel;
    private boolean visible;
    private ArrayList<Simbolo> lista_parametros;
    private long direccion;

    public Simbolo(String nombre, Tipo_simbolo tipo, Tipo_variable variable, Clase_parametro c_parametro, int nivel,
	    boolean visible, ArrayList<Simbolo> lista_parametros, long direccion) {
	this.nombre = nombre;
	this.nivel = nivel;
	this.visible = visible;
	this.lista_parametros = lista_parametros;
	this.direccion = direccion;
	this.tipo = tipo;
	this.variable = variable;
	this.parametro = c_parametro;
    }

    /**
     * Crea un símbolo de timpo programa
     * 
     * @param nombre
     * @param direccion
     * @return
     */
    public static Simbolo programa(String nombre, long direccion) {
	return new Simbolo(nombre, Tipo_simbolo.PROGRAMA, null, null, 0, true, null, direccion);
    }

    /**
     * Crea un símbolo de tipo variable
     * 
     * @param nombre
     * @param variable
     * @param nivel
     * @param direccion
     * @return
     */
    public static Simbolo variable(String nombre, Tipo_variable variable, int nivel, long direccion) {
	return new Simbolo(nombre, Tipo_simbolo.VARIABLE, variable, null, nivel, true, null,
		direccion);
    }

    /**
     * Crea un símbolo de tipo acción
     * 
     * @param nombre
     * @param nivel
     * @param direccion
     * @return
     */
    public static Simbolo accion(String nombre, int nivel, long direccion) {
	return new Simbolo(nombre, Tipo_simbolo.ACCION, null, null, nivel, true,  new ArrayList<Simbolo>(), direccion);
    }

    /**
     * Crea un símbolo de tipo parámetro
     * 
     * @param nombre
     * @param variable
     * @param c_parametro
     * @param nivel
     * @param direccion
     * @return
     */
    public static Simbolo parametro(String nombre, Tipo_variable variable, Clase_parametro c_parametro, int nivel,
	    long direccion) {
	return new Simbolo(nombre, Tipo_simbolo.PARAMETRO, variable, c_parametro, nivel, true, null, direccion);
    }

    
    
    /**
     * Introduce un parámetro en el símbolo
     */
    public void introducir_parametro(Simbolo parametro) {
	lista_parametros.add(parametro);
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String name) {
	this.nombre = name;
    }

    public int getNivel() {
	return nivel;
    }

    public void setNivel(int level) {
	this.nivel = level;
    }

    public Tipo_simbolo getTipoSimbolo() {
	return tipo;
    }

    public void setSimbolo(Tipo_simbolo simbolo) {
	this.tipo = simbolo;
    }

    public Tipo_variable getVariable() {
	return variable;
    }

    public void setVariable(Tipo_variable variable) {
	this.variable = variable;
    }

    public Clase_parametro getParametro() {
	return parametro;
    }

    public void setParametro(Clase_parametro parametro) {
	this.parametro = parametro;
    }

    public boolean esVisible() {
	return visible;
    }

    public void setVisible(boolean visible) {
	this.visible = visible;
    }

    public ArrayList<Simbolo> getListaParametros() {
	return lista_parametros;
    }

    public void setListaParametros(ArrayList<Simbolo> parameter_list) {
	this.lista_parametros = parameter_list;
    }

    public long getDireccion() {
	return direccion;
    }

    public void setDir(long dir) {
	this.direccion = dir;
    }

    public boolean esVariable() {
	return this.tipo.equals(Tipo_simbolo.VARIABLE);
    }

    public boolean esPrograma() {
	return this.tipo.equals(Tipo_simbolo.PROGRAMA);
    }

    public boolean esAccion() {
	return this.tipo.equals(Tipo_simbolo.ACCION);
    }

    public boolean esParametro() {
	return this.tipo.equals(Tipo_simbolo.PARAMETRO);
    }

    public boolean esRef() {
	return this.parametro.equals(Clase_parametro.REF);
    }

    public boolean esVal() {
	return this.parametro.equals(Clase_parametro.VAL);
    }

    public boolean esUnknown() {
	return this.variable.equals(Tipo_variable.DESCONOCIDO);
    }

    public boolean esEntero() {
	return this.variable.equals(Tipo_variable.ENTERO);
    }

    public boolean esBooleano() {
	return this.variable.equals(Tipo_variable.BOOLEANO);
    }

    public boolean esChar() {
	return this.variable.equals(Tipo_variable.CHAR);
    }

    public boolean esCadena() {
	return this.variable.equals(Tipo_variable.CADENA);
    }
    
    @Override
    public String toString() {
	String str = null;
        switch(tipo) {
        case PROGRAMA:
            str = "Pr: " + nombre + ":" + nivel;
            break;
	case ACCION:
	    
	    str = "Acc: " + nombre + ":" + nivel + "(" + lista_parametros.stream()
	    	.map(Object::toString).collect(Collectors.joining(", ")) + ")";
	    break;
	case PARAMETRO:
	    str = "Par: " + parametro + " " + variable + " " + nombre + ":" + nivel ;
	    break;
	case VARIABLE:
	    str = "Var: " + variable + " " + nombre  + ":" + nivel; 
	    break;
	default:
	    break;
            
        }
        return str;
    }

}
