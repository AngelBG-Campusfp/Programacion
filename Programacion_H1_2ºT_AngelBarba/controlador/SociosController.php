<?php
require_once '../modelo/class_socio.php';

class SociosController {
    private $modelo;
    private $conexion;

    public function __construct() {
    $this->modelo = new Socio();
    $this->conexion = (new Conexion())->conexion; // Acceder a la conexión real
}

    public function agregarSocio($id, $nombre, $apellido, $correo, $edad, $plan_base, $duracion_suscripcion) {
        $this->modelo->agregarSocio($id, $nombre, $apellido, $correo, $edad, $plan_base, $duracion_suscripcion);
    }    

    public function listarSocios() {
        return $this->modelo->obtenerSocios();
    }

    public function obtenerSocioPorId($id_socio) {
        return $this->modelo->obtenerSocioPorId($id_socio);
    }

    public function actualizarSocio($id_socio, $nombre, $apellido, $correo, $edad, $plan_base, $duracion_suscripcion) {
        $this->modelo->actualizarSocio($id_socio, $nombre, $apellido, $correo, $edad, $plan_base, $duracion_suscripcion);
    }    

    public function eliminarSocio($id_socio) {
        $this->modelo->eliminarSocio($id_socio);
    }

    public function obtenerPlanes() {
        $sql = "SELECT plan_base, costo_mensual FROM costos_planes_base";
        $stmt = $this->conexion->prepare($sql);
        $stmt->execute();
        $resultado = $stmt->get_result();
        return $resultado->fetch_all(MYSQLI_ASSOC);
    }
    
    public function obtenerPaquetes() {
        $sql = "SELECT p.nombre, c.costo_mensual FROM paquetes p 
                JOIN costos_paquetes_adicionales c ON p.id = c.id_paquete";
        $stmt = $this->conexion->prepare($sql);
        $stmt->execute();
        $resultado = $stmt->get_result();
        return $resultado->fetch_all(MYSQLI_ASSOC);
    }
    
}
?>
