<?php
class Libro{

    public $titulo;
    public $autor;
    public $paginas;

    public function mostrarInfo(){
        echo "Titulo: " . $this->titulo . "\nAutor: " . $this->autor . "\nNumero de paginas: " . $this->paginas . ".";

    }

}

$miLibro = new Libro();
$miLibro->titulo = "Los secretos de la humanidad";
$miLibro->autor = "Oswal Harmoniang";
$miLibro->paginas = "456";

$miLibro->mostrarInfo();
?>




<?php
class circulo{
    public $radio;

    public function calcularArea(){
        echo "El area del circulo es:" . $this->radio * 3.14 . ".";
    }
}

$miCirculo = new circulo();
$miCirculo->radio = 5;

$miCirculo->calcularArea();

?>


<?php
    class vehiculo{
        public $marca;

        public function encender(){
            echo "Coche encendido";
        }
    }

    class coche extends vehiculo{
        public $modelo;
    }

    $miCoche = new coche();
    $miCoche->marca = "Seat";
    $miCoche->modelo = "Ibiza";

    echo "Marca del coche: " . $miCoche->marca . ".";
    echo "Modelo del coche: " . $miCoche->modelo . ".";

    $miCoche->encender();

?>


<?php
    class empleado{
        public $nombre;
        public $sueldo;

        public function mostrarDetalles(){
            echo "Nombre: " . $this->nombre . "\nSueldo: " . $this->sueldo . ".";
        }

    }

    class Gerente extends Empleado {
        public $departamento;
    
        public function mostrarDetalles() {
            echo "\nNombre: " . $this->nombre . "\nSueldo: " . $this->sueldo . "\nDepartamento: " . $this->departamento . "";
        }
    }

    // Instancia de Empleado
$empleado = new Empleado();
$empleado->nombre = "Juan López";
$empleado->sueldo = 3000;

$empleado->mostrarDetalles();

// Instancia de Gerente
$gerente = new Gerente();
$gerente->nombre = "Ana Martínez";
$gerente->sueldo = 7000;
$gerente->departamento = "Finanzas \n";

$gerente->mostrarDetalles();

?>

<?php
class calculadora{
    public $sumar;
    public $restar;
    public $multiplicacion;
    public $division;

    public function sumar($a, $b) {
        return $a + $b;
    }

    public function restar($a, $b) {
        return $a - $b;
    }

    public function multiplicacion($a, $b) {
        return $a * $b;
    }

    public function division($a, $b) {
        if ($b == 0) {
            return "Error: División por cero no permitida.";
        }
        return $a / $b;
    }
}

$calculadora = new Calculadora();

echo "\nSuma: " . $calculadora->sumar(10, 5) . "";
echo "\nResta: " . $calculadora->restar(10, 5) . "";
echo "\nMultiplicación: " . $calculadora->multiplicacion(10, 5) . "";
echo "\nDivisión: " . $calculadora->division(10, 5) . "";
echo "\nDivisión por cero: " . $calculadora->division(10, 0) . "";
?>