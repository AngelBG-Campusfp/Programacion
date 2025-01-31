<?php
require_once '../config/conexion.php';

class Socio {
    private $conexion;

    public function __construct() {
        $this->conexion = new Conexion();
    }

    public function agregarSocio($nombre, $apellidos, $correo, $edad, $plan_base, $paquete, $duracion_suscripcion) {
        // Insertar el socio en la tabla usuarios
        $sql = "INSERT INTO usuarios (nombre, apellidos, correo, edad, plan_base, duracion_suscripcion) 
                VALUES (?, ?, ?, ?, ?, ?)";
        $stmt = $this->conexion->conexion->prepare($sql);
        $stmt->bind_param('ssssss', $nombre, $apellidos, $correo, $edad, $plan_base, $duracion_suscripcion);
        $stmt->execute();
        $id_usuario = $stmt->insert_id;
    
        // Insertar los paquetes del usuario en la tabla usuarios_paquetes
        if ($paquete) {
            $sql_paquete = "INSERT INTO usuarios_paquetes (id_usuario, id_paquete) VALUES (?, ?)";
            $stmt_paquete = $this->conexion->conexion->prepare($sql_paquete);
            foreach ($paquete as $id_paquete) {  // Asumir que $paquete es un array de IDs de paquetes
                $stmt_paquete->bind_param('ii', $id_usuario, $id_paquete);
                $stmt_paquete->execute();
            }
        }
    }
    


    public function obtenerSocios() {
        //$query = "SELECT * FROM usuarios";
        $query = "SELECT *, c.nombre as nombre_paquete_extra FROM usuarios u
        JOIN costos_paquetes_adicionales c ON u.id = c.id_paquete";
        $resultado = $this->conexion->conexion->query($query);
        $socios = [];
        while ($fila = $resultado->fetch_assoc()) {
            $socios[] = $fila;
        }
        return $socios;
    }

    public function obtenerSocioPorId($id_socio) {
        $query = "SELECT * FROM usuarios WHERE id = ?";
        $stmt = $this->conexion->conexion->prepare($query);
        $stmt->bind_param("i", $id_socio);
        $stmt->execute();
        $resultado = $stmt->get_result();
        return $resultado->fetch_assoc();
    }

    public function actualizarSocio($id, $nombre, $apellidos, $correo, $edad, $plan_base, $duracion_suscripcion) {
        $query = "UPDATE usuarios SET nombre = ?, apellidos = ?, correo = ?, edad = ?, plan_base = ?, duracion_suscripcion = ? WHERE id = ?";
        $stmt = $this->conexion->conexion->prepare($query);
        $stmt->bind_param("ssssssi", $nombre, $apellidos, $correo, $edad, $plan_base, $duracion_suscripcion, $id);    

        if ($stmt->execute()) {
            echo "Usuario actualizado con éxito.";
        } else {
            echo "Error al actualizar usuario: " . $stmt->error;
        }

        $stmt->close();
    }

    public function eliminarSocio($id_socio) {
        $query = "DELETE FROM usuarios WHERE id = ?";
        $stmt = $this->conexion->conexion->prepare($query);
        $stmt->bind_param("i", $id_socio);

        if ($stmt->execute()) {
            echo "Usuario eliminado con éxito.";
        } else {
            echo "Error al eliminar usuario: " . $stmt->error;
        }

        $stmt->close();
    }
}
?>
