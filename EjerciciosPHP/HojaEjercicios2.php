<?php

$frase_usuario = readline("Escribe una frase: ");

$contador = 0;

for ($i = 0;$i < strlen($frase_usuario); $i++ ) {
    if ($frase_usuario[$i] == " ") {
        $contador++;
    }
}

$contador++;

echo "La frase tiene $contador palabras.\n"
?>






<?php

$array = array(4,2,3,1);

sort($array);

echo "Array ordenado: ";
foreach ($array as $numero) {
    echo $numero . " ";
}
?>






<?php
do {
    $contraseña = readline("Escribe una contraseña: ");

    $caracteres = strlen($contraseña);
    $mayusculas = preg_match('/[A-Z]/', $contraseña);
    $numero = preg_match('/[0-9]/', $contraseña);

    if ($caracteres < 8) {
        echo "Debe contener al menos 8 caracteres.\n";
    }

    if ($mayusculas == 0) {
        echo "Debe contener al menos 1 mayúscula.\n";
    }

    if ($numero == 0) {
        echo "Debe contener al menos 1 número.\n";
    }

} while ($caracteres < 8 || $mayusculas == 0 || $numero == 0);

echo "Contraseña creada con éxito.\n";
?>





<?php

$nombres = array("Juan", "Ana", "Carlos", "María", "Luis", "Sofía");

$apellidos = array("Pérez", "González", "Rodríguez", "López", "Martínez", "Gómez");

$nombreAleatorio = $nombres[array_rand($nombres)];
$apellidoAleatorio = $apellidos[array_rand($apellidos)];

$nombreCompleto = $nombreAleatorio . " " . $apellidoAleatorio;

echo "Nombre completo aleatorio: " . $nombreCompleto;

?>






<?php

$dado = rand(1,6);

echo " Ha salido: " . $dado;

?>