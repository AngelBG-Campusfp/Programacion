<?php
require_once '../controlador/SociosController.php';

if (isset($_GET['id'])) {
    $id_evento = $_GET['id'];

    $controller = new EventosController();
    $controller->eliminarEvento($id_evento);

    header("Location: lista_eventos.php");
    exit();
} else {
    echo "ID de evento no proporcionado.";
}
?>
