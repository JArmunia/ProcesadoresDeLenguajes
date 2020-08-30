programa test_vectores_valor;

caracter mundo[5], hola[4];

accion saluda(val caracter a[4], c; ref caracter b[5]);
principio
    
    escribir(a[0],a[1],a[2],a[3],c, " ", b[0], b[1], b[2], b[3], b[4] , "!")  ;
    
fin

principio
    hola[0] := "h";
    hola[1] := "o";
    hola[2] := "l";
    hola[3] := "a";  
    mundo[0] := "m";
    mundo[1] := "u";  
    mundo[2] := "n";    
    mundo[3] := "d";    
    mundo[4] := "o";
    saluda(hola, ",", mundo);
    
fin