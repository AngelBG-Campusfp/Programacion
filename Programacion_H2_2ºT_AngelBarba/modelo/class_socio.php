<?php
require_once '../config/conexion.php';

class Socio {
    private $conexion;

    public function __construct() {
        $this->conexion = new Conexion();
    }

    public function agregarTarea($titulo, $descripcion, $estado, $fecha_creacion) {
        // Insertar el socio en la tabla usuarios
        $sql = "INSERT INTO tareas (titulo, descripcion, estado, fecha_creacion) 
                VALUES (?, ?, ?, ?)";
        $stmt = $this->conexion->conexion->prepare($sql);
        $stmt->bind_param('ssss',$titulo, $descripcion, $estado, $fecha_creacion);
        $stmt->execute();
        $id_usuario = $stmt->insert_id;
    }
    


    public function obtenerTarea() {
        $query = "SELECT * FROM tareas";  
        $stmt = $this->conexion->conexion->prepare($query);
        $stmt->execute();
        $result = $stmt->get_result();
        return $result->fetch_all(MYSQLI_ASSOC);
    }
    

    public function obtenerTareaPorId($id_tarea) {
        $query = "SELECT * FROM tareas WHERE id_tarea = ?";
        $stmt = $this->conexion->conexion->prepare($query);
        $stmt->bind_param("i", $id_tarea);
        $stmt->execute();
        $resultado = $stmt->get_result();
        return $resultado->fetch_assoc();
    }

    public function actualizarTarea($id_tarea, $titulo, $descripcion, $estado, $fecha_creacion) {
        $query = "UPDATE tareas SET titulo = ?, descripcion = ?, estado = ?, fecha_creacion = ? WHERE id_tarea = ?";
        $stmt = $this->conexion->conexion->prepare($query);
        $stmt->bind_param("ssssi", $titulo, $descripcion, $estado, $fecha_creacion, $id_tarea);
    
        if ($stmt->execute()) {
            echo "Tarea actualizada con éxito.";
        } else {
            echo "Error al actualizar la tarea: " . $stmt->error;
        }
    
        $stmt->close();
    }    

    public function eliminarTarea($id_tarea) {
        $query = "DELETE FROM tareas WHERE id_tarea = ?";
        $stmt = $this->conexion->conexion->prepare($query);
        $stmt->bind_param("i", $id_tarea);

        if ($stmt->execute()) {
            echo "Tarea eliminado con éxito.";
        } else {
            echo "Error al eliminar tarea: " . $stmt->error;
        }

        $stmt->close();
    }
}
?>
