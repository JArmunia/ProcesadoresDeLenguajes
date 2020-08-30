programa test_vectores2;

entero vector[3], vector2[3], vector3[3];

principio  
    vector[0] := 1;
    vector[1] := 2;
    vector[2] := 3;

    vector2[0] := vector[0] + 1;
    vector2[1] := vector[1] + 2;
    vector2[2] := vector[2] + 3;

    vector3 := vector2;
    escribir(vector2[0], " ", vector2[1], " ", vector2[2], " ");
    escribir(vector3[0], " ", vector3[1], " ", vector3[2]);

fin