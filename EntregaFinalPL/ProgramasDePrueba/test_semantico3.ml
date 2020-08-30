programa test_semantico3;

%%
    Test de operadores y tipos
%%
entero e;

booleano b;

caracter c;

accion acc(ref entero e; ref booleano b; ref caracter c);
principio
    escribir(e, b, c);
fin

principio
    e := 10 - 3 * 5 / 6 ;

    c := "a";

    b := 21 < 18;

    e := caraent(c);

    c := entacar(e);

    b := e < caraent(c) -1;

    escribir(e, c, b);

    e := desconocido; % Error, variable desconocida

    desconocido:= b; % Ya no da error

    desconocido:= c;

    desconocido := e;

    acc(e, b, c);

    acc(desconocido, desconocido, desconocido); % No da error

    acc(b,c,e); % Error, los parametros estan desordenados y los tipos no coinciden

    e := b; % Error

    c := e; % Error

    b := c; % Error

    e := 1- 3 + 4 > 10 - 3; % Error, porque el resultado es booleano

    b := 1 and 2; % Error

    c:= true or "a"; % Error

    b:= "a" = "a";

    e := caraent(true); % Error

    e := caraent(1); % Error

    c := entacar(true); % Error

    c := entacar("a"); % Error
    
    escribir(true, " ", false); % Escribe Verdadero y Falso
fin