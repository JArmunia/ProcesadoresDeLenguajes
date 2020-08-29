package clasesJava;

public class RegistroExpr {
    public Integer valorEnt = null;
    public Boolean valorBool = null;
    public String valorChar = null;
    public Float valorDecimal = null;
    public Clase_parametro parametro = Clase_parametro.VAL;
    public boolean isVector = false;

    public Tipo_variable tipo;

    public RegistroExpr() {
	tipo = Tipo_variable.DESCONOCIDO;
    }

    public RegistroExpr(Tipo_variable tipo) {
	this.tipo = tipo;
    }

    public RegistroExpr( Integer v) {
	this.tipo = Tipo_variable.ENTERO;
	this.valorEnt = v;
    }

    public RegistroExpr(Boolean v) {
	this.tipo = Tipo_variable.BOOLEANO;
	this.valorBool = v;
    }

    public RegistroExpr(String v) {
	this.tipo = Tipo_variable.CHAR;
	this.valorChar = v;
    }

    public RegistroExpr(RegistroExpr r1, RegistroExpr r2, String op) {
	boolean operacionViable = false;
	if ((r1.tipo != Tipo_variable.DESCONOCIDO) && (r2.tipo != Tipo_variable.DESCONOCIDO)) {
	    operacionViable = true;
	}

	switch (op) {

	case "+":
	    if (operacionViable && r1.valorEnt != null && r2.valorEnt != null) {
		this.valorEnt = r1.valorEnt + r2.valorEnt;
		this.tipo = Tipo_variable.ENTERO;
	    } else {
		this.tipo = Tipo_variable.DESCONOCIDO;
	    }
	    break;
	case "-":
	    if (operacionViable && r1.valorEnt != null && r2.valorEnt != null) {
		this.valorEnt = r1.valorEnt - r2.valorEnt;
		this.tipo = Tipo_variable.ENTERO;
	    } else {
		this.tipo = Tipo_variable.DESCONOCIDO;
	    }
	    break;
	case "or":
	    if (operacionViable && r1.valorBool != null && r2.valorBool != null) {
		this.valorBool = r1.valorBool | r2.valorBool;
		this.tipo = Tipo_variable.BOOLEANO;
	    } else {
		this.tipo = Tipo_variable.DESCONOCIDO;
	    }

	    break;
	case "*":
	    if (operacionViable && r1.valorEnt != null && r2.valorEnt != null) {
		this.valorEnt = r1.valorEnt * r2.valorEnt;
		this.tipo = Tipo_variable.ENTERO;
	    } else {
		this.tipo = Tipo_variable.DESCONOCIDO;
	    }

	    break;
	case "/":
	    if (operacionViable && r1.valorEnt != null && r2.valorEnt != null) {
		this.valorEnt = r1.valorEnt / r2.valorEnt;
		this.tipo = Tipo_variable.ENTERO;
	    } else {
		this.tipo = Tipo_variable.DESCONOCIDO;
	    }

	    break;
	case "div":
	    if (operacionViable && r1.valorEnt != null && r2.valorEnt != null) {
		this.valorEnt = r1.valorEnt / r2.valorEnt;
		this.tipo = Tipo_variable.ENTERO;
	    } else {
		this.tipo = Tipo_variable.DESCONOCIDO;
	    }

	    break;
	case "mod":
	    if (operacionViable && r1.valorEnt != null && r2.valorEnt != null) {
		this.valorEnt = r1.valorEnt % r2.valorEnt;
		this.tipo = Tipo_variable.ENTERO;
	    } else {
		this.tipo = Tipo_variable.DESCONOCIDO;
	    }

	    break;
	case "and":
	    if (operacionViable && r1.valorBool != null && r2.valorBool != null) {
		this.valorBool = r1.valorBool & r2.valorBool;
		this.tipo = Tipo_variable.BOOLEANO;
	    } else {
		this.tipo = Tipo_variable.DESCONOCIDO;
	    }

	    break;
	case "=":
	    if (operacionViable && r1.tipo == r2.tipo) {
		if (r1.valorBool != null && r2.valorBool != null) {
		    this.valorBool = r1.valorBool == r2.valorBool;
		} else if (r1.valorEnt != null && r2.valorEnt != null) {
		    this.valorBool = r1.valorEnt == r2.valorEnt;
		} else if (r1.valorChar != null && r2.valorChar != null) {
		    this.valorBool = r1.valorChar.equals(r2.valorChar);
		}
		this.tipo = Tipo_variable.BOOLEANO;
	    } else {
		this.tipo = Tipo_variable.DESCONOCIDO;
	    }
	    break;

	case "<>":
	    if (operacionViable && r1.tipo == r2.tipo) {
		if (r1.valorBool != null && r2.valorBool != null) {
		    this.valorBool = r1.valorBool != r2.valorBool;
		} else if (r1.valorEnt != null && r2.valorEnt != null) {
		    this.valorBool = r1.valorEnt != r2.valorEnt;
		} else if (r1.valorChar != null && r2.valorChar != null) {
		    this.valorBool = !r1.valorChar.equals(r2.valorChar);
		}
		this.tipo = Tipo_variable.BOOLEANO;
	    } else {
		this.tipo = Tipo_variable.DESCONOCIDO;
	    }
	    break;

	case "<":
	    if (r1.valorEnt != null && r2.valorEnt != null) {
		this.valorBool = r1.valorEnt < r2.valorEnt;
		this.tipo = Tipo_variable.BOOLEANO;
	    } else {
		this.tipo = Tipo_variable.DESCONOCIDO;
	    }
	    break;

	case ">":
	    if (r1.valorEnt != null && r2.valorEnt != null) {
		this.valorBool = r1.valorEnt > r2.valorEnt;
		this.tipo = Tipo_variable.BOOLEANO;
	    } else {
		this.tipo = Tipo_variable.DESCONOCIDO;
	    }
	    break;

	case ">=":
	    if (r1.valorEnt != null && r2.valorEnt != null) {
		this.valorBool = r1.valorEnt >= r2.valorEnt;
		this.tipo = Tipo_variable.BOOLEANO;
	    } else {
		this.tipo = Tipo_variable.DESCONOCIDO;
	    }
	    break;

	case "<=":
	    if (r1.valorEnt != null && r2.valorEnt != null) {
		this.valorBool = r1.valorEnt <= r2.valorEnt;
		this.tipo = Tipo_variable.BOOLEANO;
	    } else {
		this.tipo = Tipo_variable.DESCONOCIDO;
	    }
	    break;
	}

    }

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	StringBuilder sb = new StringBuilder();
	sb.append("Registro " + tipo + ", valor: ");
	switch (tipo) {
	case BOOLEANO:
	    sb.append(valorBool);
	    break;

	case ENTERO:
	    sb.append(valorEnt);
	    break;

	case CHAR:
	    sb.append(valorChar);
	    break;
	}
	sb.append(", par: " + parametro); 
	return sb.toString();
    }

}
