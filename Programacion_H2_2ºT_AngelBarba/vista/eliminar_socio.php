<?php
require_once '../controlador/SociosController.php';

if (isset($_GET['id_tarea'])) {
    $id_tarea = $_GET['id_tarea'];

    $controller = new SociosController();
    $controller->eliminarTarea($id_tarea);

    header("Location: lista_socios.php");
    exit();
} else {
    echo "ID de tarea no proporcionado.";
}
?>
