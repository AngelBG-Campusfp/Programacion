<?php
class producto1 {
    private $nombre;
    private $precio;
    private $cantidad;

    public function __construct($nombre, $precio, $cantidad){
        $this->nombre = $nombre;
        $this->precio = $precio;
        $this->cantidad = $cantidad;
    }

    public function getNombre(){
        echo "Nombre: " . $this->nombre . "\n";
        return $this->nombre;
    }

    public function getPrecio(){
        echo "Precio: " . $this->precio . "€\n";
        return $this->precio;
    }

    public function getCantidad(){
        echo "Cantidad: " . $this->cantidad . "ud\n";
        return $this->cantidad;
    }

}

class productoImportado extends producto1 {
    private $impuestoAdicional;
    private $precioFinal;

    public function __construct($nombre, $precio, $cantidad, $impuestoAdicional){
        parent::__construct($nombre, $precio, $cantidad);
        $this->impuestoAdicional = $impuestoAdicional;
    }

    public function calcularPrecioFinal(){
        $precioBase = $this->getPrecio();
        $this->precioFinal = $precioBase * $this->impuestoAdicional;

        echo "El precio final es: " . $this->precioFinal . "€\n";
    }
}

$producto = new producto1("Ordenador", 400, 1);
$producto->getNombre();
$producto->getPrecio();
$producto->getCantidad();

$productoImportado = new productoImportado("Teclado", 20, 1, 1.21);
$productoImportado->getNombre();
$productoImportado->getPrecio();
$productoImportado->getCantidad();
$productoImportado->calcularPrecioFinal();

?>



<?php
class cuentaBancaria2 {
    private $titular;
    private $saldo;
    private $tipoDeCuenta;

    public function __construct($titular, $tipoDeCuenta){
        $this->titular = $titular;
        $this->saldo = 0;
        $this->tipoDeCuenta = $tipoDeCuenta;
    }

    public function depositar($cantidad){
        if ($cantidad >= 0) {
            $this->saldo += $cantidad;
            echo "El deposito se ha realizado con exito. Saldo actual: " . $this->saldo . "€\n";
        } else {
            echo "La cantidad a depositar debe ser mayor que cero.\n";
        }
    }

    public function retirar($cantidad){
        if ($cantidad >= 0 && $cantidad <= $this->saldo) {
            $this->saldo -= $cantidad;
            echo "La retirada se ha realizado con exito. Saldo actual: " . $this->saldo . "€\n";
        } elseif ($cantidad <= 0) {
            echo "La retirada debe ser mayor que 0.\n";
        } else {
            echo "Saldo insuficiente.\n";
        }
    }

    private function verificarSaldoSuficiente($cantidad){
        
    }

}


?>


