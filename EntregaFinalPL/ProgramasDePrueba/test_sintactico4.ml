programa test_sintactico4;

%%
    Comprobamos estructuras de control
    Es correcto
%%

booleano b; 
entero i, j;

accion a;
entero e, i;
principio
    i := 1;
    mq i < 10
        leer(e); 
        si e > 1 ent
            i:= i - 1;
        fsi
    fmq
fin

accion f(val booleano b; ref entero i, j);
principio
    si b ent
        i := j;
    si_no
        j := i;
    fsi
fin
principio
    a;
    b:= true;
    j:= 10;
    i := 99;
    f(b, i, j);
fin
