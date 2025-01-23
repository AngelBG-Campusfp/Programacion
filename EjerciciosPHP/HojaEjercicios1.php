<?php
//Ejercicio 1
$numero1 = readline('Escribe el primer numero: ');
$numero2 = readline("Escribe el segundo numero: ");

$eleccion_usuario = readline("Que deseas hacer (sumar, restar, multiplicar o dividir): \n");

if ($eleccion_usuario == 'sumar') {
    echo 'La suma da: '. $numero1+$numero2;
} elseif ($eleccion_usuario == 'restar') {
    echo 'La resta da: '. $numero1-$numero2;
} elseif ($eleccion_usuario == 'multiplicar') {
    echo 'La multiplicacion da: '. $numero1*$numero2;
} else {
    echo 'La division da: '. $numero1/$numero2;
}

?>





<?php
//Ejercicio 2

$numero3 = readline("Escribe un numero: ");

for ($i = 1; $i <= 10; $i++ ) {
    echo "$numero3 x $i = ". $numero3*$i . "\n"  ;
}

?>





<?php
//Ejercicio 3
$numero4 = readline("Ingresa un numero: ");

for ($i = 2;$i < 100;$i++) {
    if ($numero4 % $i == 0) {
        echo "Es primo";
        break;
    } elseif ($numero4 % $i != 0) {
        echo "No es primo";
        break;
    }
}

?>





<?php
//Ejercicio 4

$aleatorio = rand(1, 50);



while (true) {
    $numero5 = readline("Ingresa un numero: ");
    if ($numero5 < $aleatorio) {
        echo "El numero es mayor.";
    } elseif ($numero5 > $aleatorio) {
        echo "El numero es menor.";
    } else {
        echo "Has acertado el numero!!!.";
        break;
    }
}
    



?>





<?php
//Ejercicio 5


?>

