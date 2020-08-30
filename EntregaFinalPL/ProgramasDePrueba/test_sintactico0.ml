programa test_sintactico0;

entero variable, variable2;
caracter  variableChar;
booleano boo, boo2;

accion a(val entero valent;ref entero enter);
caracter c, vecc[10];
principio
    escribir(valent, "Prueba dentro de la acción: \n", c, "ñññññ");    
fin

principio

    variable2 := 1;
    variableChar := "A" - "aaaaaa"; % Falla ya que no se puede utilizar asi un string
    variable := -3 * 5 /6 ;
    variableChar := "a";
    a(variable2, variable);
fin