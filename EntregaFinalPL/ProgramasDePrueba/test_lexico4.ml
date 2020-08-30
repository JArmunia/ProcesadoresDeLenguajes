%%
    Este programa debería ser correcto aunque este en mayusculas
%%

PROGRAMA TEST_LEXICO4;

ENTERO VARIABLE, VARIABLE2;
BOOLEANO BOO;
CARACTER CHAR;

ACCION A(REF ENTERO ENTER);
CARACTER C;
principio
    ESCRIBIR("HOLAA");
FIN

principio
    LEER(VARIABLE);
    BOO := VARIABLE < 10;
    SI BOO ENT
        ESCRIBIR("MENOR QUE 10");

    SI_NO 
        ESCRIBIR("MAYOR QUE 10");
    FSI 
fin