<?php
class persona {

    // Creo la clase con las propiedades
    public $nombre;
    public $edad;
    public $genero;

    // Metodo que imprime la presentacion
    public function presentar(){
        echo "Nombre: " . $this->nombre . "\nEdad: " . $this->edad . "\nGenero: " . $this->genero . ".";
    }

}

// Nueva instancia para agregar los datos 
$persona = new persona();
$persona->nombre = "Juan";
$persona->edad = "38";
$persona->genero = "Hombre";

// Lamar a la clase
$persona->presentar();

?>



<?php
class rectangulo {

    // Creo la clase con las propiedades
    public $base;
    public $altura;

    // metodo para trannsformar las propiedades a atributos de la funcion
    public function convertir($base, $altura){
        $this->base = $base;
        $this->altura = $altura;
    }

    // Metodo para imprimir el area del rectangulo
    public function calcularArea(){
        echo "El area del rectangulo es: " . ($this->base * $this->altura) . "";
    }

}

// Nueva instancia para agregar los datos 
$rectangulo = new rectangulo();
$rectangulo->convertir(10,5);
$rectangulo->calcularArea();

?>



<?php
class animal {
    // Creo la clase con las propiedades
    public $especie;

    // Metodo para imprimir el sonido de un animal cualquiera
    public function emitirSonido(){
        echo "Sonido de animal.";
    }
}

// Clase hija de animal
class perro extends animal {
    // Creo clase hija con las propiedades correspondientes
    public $raza;

    // Metodo para imprimir ladrido de perro
    public function emitirSonido(){
        echo "\nGuau Guau.";
    }
}

// Nueva instancia para agregar x datos 
$perro = new perro();

$perro->especie = "Perro";
$perro->raza = "Bulldog";

echo "Especie: " . $perro->especie . "";
echo "\nRaza: " . $perro->raza . "";

// Llamar a la clase
$perro->emitirSonido();

?>



<?php
class producto {
    // Creo la clase con las propiedades
    public $nombre2;
    public $precio;

    // Metodo para imprimir los detalles de un producto cualquiera
    public function mostrarDetalles(){
        echo "Nombre: " . $this->nombre2 . "\nPrecio: " . $this->precio . "";
    }

}

// Clase hija de animal 
class electrodomesticos extends producto {
    // Creo clase hija con las propiedades correspondientes
    public $consumo;

    // Metodo para mostrar detalles de el electrodomestico
    public function mostrarDetalles(){
        echo "\n\nNombre: " . $this->nombre2 . "\nPrecio: " . $this->precio . "\nConsumo: " . $this->consumo . "";
    }
}

// Nueva instancia para agregar x datos en prodcuto
$producto = new producto();
$producto->nombre2 = "Pack 10 Toallitas";
$producto->precio = "35€";

// Nueva instancia para agregar x datos en electrodomestico
$electrodomestico = new electrodomesticos();
$electrodomestico->nombre2 = "Aspirador";
$electrodomestico->precio = "249€";
$electrodomestico->consumo = "70w/H";

// Llamar a los dos metodos para que aparezcan en pantalla
$producto->mostrarDetalles();
$electrodomestico->mostrarDetalles();
?>



<?php
class conversorMoneda {
    // Creo la clase con las propiedades 
    public $euro;
    public $dolar;

    //Metodo para convertir de dolares a euros e imprimir el resultado
    public function convertirDolaresAEuros(){
        echo "La conversion de " . $this->dolar . "$ a euros es: " . $this->dolar * 0.9807 . "€";
    }

    //Metodo para convertir de euros a dolares e imprimir el resultado
    public function convertirEurosADolares(){
        echo "\nLa conversion de " . $this->euro . "€ a dolares es: " . $this->euro * 1.0216 . "$";
    }

}

// Nueva instancia le doy valor a los dolares
$euros = new conversorMoneda;
$euros->dolar = 4;

// Nueva instancia le doy valor a los euros
$dolares = new conversorMoneda;
$dolares->euro = 5;

// Llamar a los dos metodos para que aparezcan en pantalla
$euros->convertirDolaresAEuros();
$dolares->convertirEurosADolares();

?>
