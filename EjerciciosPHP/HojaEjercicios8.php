<?php
class cuentaBancaria {
    // Creo la clase con las propiedades
    public $titular;
    public $saldo;
    public $tipoDeCuenta;

    // Creo el metodo depositar dinero con unas condiciones especificas
    public function depositar($cantidad){
        if ($cantidad >= 0) {
            $this->saldo += $cantidad;
            echo "El deposito se ha realizado con exito. Saldo actual: " . $this->saldo . "€\n";
        } else {
            echo "La cantidad a depositar debe ser mayor que cero.\n";
        }
    }

    // Creo el metodo retirar dinero con unas condiciones especificas
    public function retirar($cantidad){
        if ($cantidad >=0 && $cantidad <= $this->saldo) {
            $this->saldo -= $cantidad;
            echo "La retirada se ha realizado con exito. Saldo actual: " . $this->saldo . "€\n";
        } elseif ($cantidad <= 0) {
            echo "La cantidad a retirar debe ser mayor que 0.\n";
        } else {
            echo "Saldo insuficiente.\n";
        }
    }

    // Creo el metodo mostar info para que muestre todas las propiedades
    public function mostrarInfo(){
        echo "\nTitular: " . $this->titular . "\nTipo de cuenta: " . $this->tipoDeCuenta . "\nSaldo: " . $this->saldo . "€";
    }
}

// Nueva instancia para agregar los datos a las propiedades
$cuenta = new cuentaBancaria();
$cuenta->titular = "Angel Barba";
$cuenta->saldo  = 100000;
$cuenta->tipoDeCuenta = "Cuenta personal";

// Llamo a los metodos y le agrego un valor para que hagan su trabajo
$cuenta->depositar(500);
$cuenta->retirar(200);
$cuenta->mostrarInfo();


/* echo "Bienvenido A La App De BBVA";
echo "\n\n1. Depositar Efectivo";
echo "\n1. Retirar Efectivo";
echo "\n3. Mostrar Informacion De La Cuenta";

$seleccion_usuario = readline("\nElige Una Opcion: ");

if ($seleccion_usuario == 1) {
    $cantidad = readline("Ingresa la cantidad a depositar: ");
    $cuenta->depositar($cantidad);
} elseif ($seleccion_usuario == 2) {
    $cantidad = readline("Ingresa la cantidad a retirar: ");
    $cuenta->retirar($cantidad);
} elseif ($seleccion_usuario == 3) {
    $cuenta->mostrarInfo();
} else {
    echo "Opcion no valida";
} */
?>



<?php
class tarea {
    // Creo la clase con las propiedades
    public $nombre;
    public $descripcion;
    public $fechaLimite;
    public $estado;

    // Creo el metodo marcar como completado que hace su funcion correctamente
    public function marcarComoCompletada() {
        $this->estado = "Completada";
        echo "\n\nLa tarea '" . $this->nombre . "' ha sido marcada como completada";
    }

    // Creo el metodo editar descripcion que hace su funcion correctamente
    public function editarDescripcion($nuevaDescripcion) {
        $this->descripcion = $nuevaDescripcion;
        echo "\nLa descripcion de la tarea '" . $this->nombre . "' ha sido actualizada";
    }

    // Creo el metodo mostrar tarea  para que muestre todas las propiedades
    public function mostrarTarea() {
        echo "\n\nNombre: " . $this->nombre . "\nDescripcion: " . $this->descripcion . "\nFecha limite:" . $this->fechaLimite . "\nEstado:" . $this->estado . "";
    }
}

// Creo un array
$tareas = [];

// Nueva instancia para agregar datos a las propiedades
$tarea1 = new tarea();
$tarea1->nombre = "PHP - Hoja Ejercicios 1";
$tarea1->descripcion = "Hacer los ejercicios de clases";
$tarea1->fechaLimite = "14-01-2025";
$tarea1->estado = "Asignado\n";

// Nueva instancia para agregar datos a las propiedades
$tarea2 = new tarea();
$tarea2->nombre = "PHP - Hoja Ejercicios 2";
$tarea2->descripcion = "Hacer los ejercicios de clases";
$tarea2->fechaLimite = "18-01-2025";
$tarea2->estado = "Asignado";

// Añado las dos instancias a la lista de array
$tareas[] = $tarea1;
$tareas[] = $tarea2;

// Recorro los elementos del array y los gaurdo en una variable que a la vez ejecuta un metodo
echo "Tareas antes de marcar como completadas:\n";
foreach ($tareas as $tarea) {
    $tarea->mostrarTarea();
}

// Marcar la primera tarea como completada
$tareas[0]->marcarComoCompletada();

// Editar la descripción de la segunda tarea
$tareas[1]->editarDescripcion("Enviar la tarea en Word o PDF");

// Recorro los elementos del array y los gaurdo en una variable que a la vez ejecuta un metodo
echo "\n\nTareas después de las actualizaciones:\n";
foreach ($tareas as $tarea) {
    $tarea->mostrarTarea();
}

?>



<?php
class empleado {
    public $nombre2;
    public $sueldo;
    public $añosExperiencia;

    public function calcularBonus(){
        $bonus = ($this->añosExperiencia / 2) + ($this->sueldo * 0.05);
        return $bonus;
    }

    public function mostrarDetalles(){
        echo "\n\nNombre: " . $this->nombre2 . "\nSueldo: " . $this->sueldo . "\nAños de experiencia: " . $this->añosExperiencia . "";
    }

}

class consultor extends empleado {
    public $horasPorProyecto;

    public function calcularBonus2(){
        if ($this->horasPorProyecto >= 100) {
            $bonus2 = ($this->sueldo *0.03);
            return $bonus2;
        } else {
            echo "No has trabajado mas de 100 Horas.";
        }
        
    }

}

$empleado = new empleado();
$empleado->nombre2 = "David Guapo";
$empleado->sueldo = 50000;
$empleado->añosExperiencia = 12;

$consultor = new consultor();
$consultor->nombre2 = "Patricia Gonzalez";
$consultor->sueldo = 60000;
$consultor->añosExperiencia = 24;
$consultor->horasPorProyecto = 150;

$empleado->mostrarDetalles();
echo "\nBonus Total: ". $empleado->calcularBonus() . "€";

$consultor->mostrarDetalles();
echo "\nBonus por experiencia: " . $consultor->calcularBonus() . "€\n";
echo "Bonus por horas trabajadas: " . $consultor->calcularBonus2() . "€\n";
echo "Bonus total: " . ($consultor->calcularBonus() + $consultor->calcularBonus2()) . "€\n";

?>



<?php
class carrito {
    public $productos = [];

    public function agregarProducto($nombre, $precio, $cantidad){
        echo "Nombre: " . $this->$nombre . "Precio: " . $this->$precio . "Cantidad: " . $this->$cantidad . "";
    }
    public function quitarProducto(){
        
    }
    public function calcularTotal(){
        
    }

    public function mostrarDetalleCarrito(){
        
    }
    

}

?>



<?php
class personaje{
    public $nombre3;
    public $nivel;
    public $puntosVida;
    public $puntosAtaque;

    public function atacar(personaje $objetivo){
        if ($this->puntosAtaque >= $this->puntosVida){
            $objetivo->puntosVida = 0;
        }else {
            $objetivo->puntosVida -= $this->puntosAtaque;
        }
        echo "{$this->nombre3} ataca a {$objetivo->nombre3}, haciendo {$this->puntosAtaque} de daño.\n";
        echo "Vida restante de {$objetivo->nombre3}: {$objetivo->puntosVida}.\n";
    }

    public function curarse(){
        $curacion = 10;

        $this->puntosVida += $curacion;
        
        echo "{$this->nombre3} ha usado una pocion.\n";
        echo "Se ha racuperado {$curacion} de vida.\n";
    }

    public function subirNivel(){
        $this->nivel = 1;
        $this->puntosAtaque += 5;
        $this->puntosVida += 15;

        echo "{$this->nombre3} ha subido a nivel {$this->nivel}.\n";
        echo "Puntos de ataque: {$this->puntosAtaque} / Puntos de vida: {$this->puntosVida}.";
    }

}

$personaje1 = new personaje();
$personaje1->nombre3 = "Juan";  
$personaje1->nivel = 1; 
$personaje1->puntosVida = 100;  
$personaje1->puntosAtaque = 20;  

$personaje2 = new personaje();
$personaje2->nombre3 = "Ana";  
$personaje2->nivel = 1;
$personaje2->puntosVida = 120; 
$personaje2->puntosAtaque = 15;

// Ejemplo de uso
$personaje1->atacar($personaje2); 
$personaje2->curarse();           
$personaje1->subirNivel();        

?>