<?php
require_once '../controlador/SociosController.php';

if (isset($_GET['id'])) {
    $id_socio = $_GET['id'];

    $controller = new SociosController();
    $controller->eliminarSocio($id_socio);

    header("Location: lista_socios.php");
    exit();
} else {
    echo "ID de socio no proporcionado.";
}
?>
