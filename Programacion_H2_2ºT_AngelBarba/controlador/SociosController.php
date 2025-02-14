<?php
require_once '../modelo/class_socio.php';

class SociosController {
    private $modelo;
    private $conexion;

    public function __construct() {
    $this->modelo = new Socio();
    $this->conexion = (new Conexion())->conexion; // Acceder a la conexión real
}

    public function agregarTarea($titulo, $descripcion, $estado, $fecha_creacion) {
        $this->modelo->agregarTarea($titulo, $descripcion, $estado, $fecha_creacion);
    }    

    public function listarTareas() {
        return $this->modelo->obtenerTarea();
    }

    public function obtenerTareaPorId($id_tarea) {
        return $this->modelo->obtenerTareaPorId($id_tarea);
    }

    public function actualizarTarea($id_tarea, $titulo, $descripcion, $estado, $fecha_creacion) {
        $this->modelo->actualizarTarea($id_tarea, $titulo, $descripcion, $estado, $fecha_creacion);
    }    

    public function eliminarTarea($id_tarea) {
        $this->modelo->eliminarTarea($id_tarea);
    }
    
}
?>
