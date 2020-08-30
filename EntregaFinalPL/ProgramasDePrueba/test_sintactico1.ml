programa test_lexico0;

entero variable, variable2;
caracter  variableChar;
booleano boo, boo2;

accion a(val entero valent;ref entero enter);
caracter c, vecc[10];
principio
    escribir(valent, "Prueba dentro de la acción: \n", c, "ñññññ");    
fin

accion b; % Se puede declarar sin parametros
principio
    escribir("Accion sin parametros");
fin

principio

    a(10, variable);
    b; % b se puede llamar con o sin parametros
    b();    
fin