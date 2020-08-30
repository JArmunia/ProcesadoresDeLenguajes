programa test_semantico0;

%%
    Test de un programa en el que no se realiza ninguna declaracion
%%

principio
    a := 1 +1;
    b := a - 3 > 10 or q;
    c := "a";
    a := b - c;
    q(); % q no es una accion
    qaccion();
    qaccion();
fin