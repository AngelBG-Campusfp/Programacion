<?php
require_once '../controlador/SociosController.php';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $nombre_evento = $_POST['nombre_evento'];
    $fecha = $_POST['fecha'];
    $lugar = $_POST['lugar'];

    $controller = new EventosController();
    $controller->agregarEvento($nombre_evento, $fecha, $lugar);

    header("Location: lista_eventos.php");
    exit();
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Agregar Evento</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h1 class="text-center">Agregar Nuevo Evento</h1>
        <form method="POST" class="mt-4">
            <div class="mb-3">
                <label for="nombre_evento" class="form-label">Nombre:</label>
                <input type="text" id="nombre_evento" name="nombre_evento" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="fecha" class="form-label">Fecha:</label>
                <input type="date" id="fecha" name="fecha" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="lugar" class="form-label">Lugar:</label>
                <input type="text" id="lugar" name="lugar" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-success">Guardar</button>
            <a href="lista_eventos.php" class="btn btn-secondary">Cancelar</a>
        </form>
    </div>
</body>
</html>
