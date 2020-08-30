programa test_lexico3;

%% 
    Testeando identificadores
%%
 
entero _, a; % Este no da error

entero z, 1e_; % No lo detecta como un identificador

caracter 1e; % No lo detecta como un identificador

booleano e_; % No lo detecta como un identificador



principio
    escribir("¡Hola, mundo!");      
      
fin