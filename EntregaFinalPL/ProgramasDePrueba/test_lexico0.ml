%%
    Pruebo que reconozca un poco de todo
%%
programa test_lexico0;

entero variable, variable2;
caracter  variableChar;
booleano boo;

accion a(val entero valent;ref entero enter);
caracter c, vecc[10];
principio
    escribir(valent, "Prueba dentro de la acción: \n", c, "ñññññ");    
fin

principio

    variable2 := 1;
    variableChar := "A";
    variableChar := "a";
    a(variable2, variable);
    boo := (caraent("b") * 3 - 5 * variable2 mod 3 div 5 >= 3) or ((13 - 5 < variable) and (-3 <> caraent(entacar(199))));
    z : = 3; % Da error ya que no reconoce := si esta separado
fin