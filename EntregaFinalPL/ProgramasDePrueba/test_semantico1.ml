programa test_semantico1;

%%
    Test de parametros por valor y referencia
%%

entero variable;

accion acc(val entero valor, valor1 ; ref entero referencia);

    principio
        acc(1, 10, referencia);
        acc(referencia, referencia, referencia);
        acc(valor, valor, valor); % Error, no se puede pasar un valor por referencia
        acc(valor, valor, 19); % Error

        referencia:= 10; 
        valor := 10; % Error
        referencia := valor;
        referencia := referencia + 10;

        leer(valor); % Error
        escribir(valor, referencia);

    fin


principio
   acc(10, variable);
   acc(variable, variable);
   acc(10, 10); % Error
   leer(10); % Error
fin