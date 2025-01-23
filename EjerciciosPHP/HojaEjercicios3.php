<?php

function calculadora($a, $b, $operador) {
    try {
        if ($operador == "+") {
            return $a + $b;
        } elseif ($operador == "-") {
            return $a - $b;
        } elseif ($operador == "*") {
            return $a * $b;
        } elseif ($operador == "/") {
            //Antes de nada comprobar si $b es = 0, si lo es recopilar el error
            if ($b == 0) {
                throw new Exception("No se puede dividir entre 0.");
            }
            //Si $b no es = 0, devolver $a / $b
            return $a / $b;
        } else {
            //En otro caso recopilar otro error
            throw new Exception("El operador no es valido.");
        }
    // Try-catch 
    } catch (Exception $e) {
        echo "Error: " . $e->getmessage();
    }
}

echo calculadora(10, 5, '-'); //Devuelve 15
echo "\n";
echo calculadora(10, 0, '/'); //Devuelve "Error: No se puede dividir entre cero."

?>






<?php

function validarEmail($email) {
//variable para el archivo errores.log
$Archivo = "errores.log";
    //Si el e-mail es correcto, lo dice
    if (filter_var($email, FILTER_VALIDATE_EMAIL)){
        echo "El e-mail es correcto.\n";
    } else {
        //Si el e-mail no es correcto, imprime que no lo es y lo guarda en la variable $Archvio
        echo "Direccion de correo no válida.\n";
        file_put_contents($Archivo, FILE_APPEND);
    }
}

//Comprobar si los e-mail son validos o no
validarEmail("angel@campusfp.es");
validarEmail("angel@campusfp.com");
validarEmail("angelcampusfp.com");
validarEmail("angel@campusfpcom");

?>






<?php

?>






<?php

function tablasMultiplicar($numero) {

    try {
        if ($numero < 0) {
            throw new Exception("No se pueden introducir numeros negativos\n");
        } elseif (!is_numeric($numero ) || $numero != intval($numero)) {
            throw new Exception("No se pueden introducir numeros decimales.\n");
        } else {
            for ($i = 0; $i < 10; $i++) {
                echo "$numero * $i: " . $numero * $i . "\n";
            }
        }
    } catch (Exception $e) {
        echo "Error: " . $e->getMessage();
    }
}

tablasMultiplicar(4);
tablasMultiplicar(4.6);
tablasMultiplicar(-6);

?>






<?php

function convertirTemperaturas($numerico, $unidad) {

$Archivo2 = 'errores.log';

    try {
        if ($unidad == 'C') {
            echo "La temperatura en Celsius es ($numerico - 32) *5/9: " .($numerico - 32) *5/9 . "\n";
        } elseif ($unidad == 'F') {
            echo "La temperatura en Fahrenheit es ($numerico * 9/5) + 32: " . ($numerico *9/5) + 32 . "\n";
        } elseif ($unidad != 'C' || $unidad != 'F') {
            throw new Exception("Solo puedes convertir a Celsius o a Fahrenheit.\n");
        }
    } catch (Exception $e) {
        echo "Error: " . $e->getMessage();
        file_put_contents($Archivo2, FILE_APPEND);
    }
}

convertirTemperaturas(14, 'C');
convertirTemperaturas(15, 'B');
convertirTemperaturas(16, 'F');


?>