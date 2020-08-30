programa test_semantico2;

%%
    Test de niveles
%%

entero variable, x;

accion a(ref entero variable);
booleano x;
    accion b(ref entero variable);
    caracter x;
        accion c(ref entero variable);
        entero x;
            accion d(ref entero variable);
            booleano x;

            principio
                x:= true;
            fin
        principio
            x:= 10;
        fin
    principio
        x:= "a";
    fin
principio
    x:= false;
fin

principio
    %% Error porque no hay sentencias, el resto es correcto
fin