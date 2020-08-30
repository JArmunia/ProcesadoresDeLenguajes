programa test_semantico4;

%% 
    Comprobaciones
%%
entero e;
caracter c;

principio
    e := 99999999; % Overflow
    e:= -9999999; % Underflow
    e:= 10 * 10 -10 *10 * 10 *(10 * 10 * 10); % Overflow
    e := 50 /0; % Error division por 0
    e := 50 mod 0; % Error modulo por 0

    c := entacar(300); % Error, solo se puede transformar hasta el 255

    si true ent % Error siempre es verdadero
        escribir("Verdad");
    fsi

    si false ent % Error siempre es falso
        escribir("Falso");
    fsi

    mq 1 = 1 % Error bucle infinito
        escribir("Infinito");
    fmq

    mq 1 <> 1 % Error no se entra nunca al buble
        escribir("Nada");
    fmq
fin
