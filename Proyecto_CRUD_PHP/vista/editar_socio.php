<?php
require_once '../controlador/SociosController.php';

$controller = new SociosController();
$id_socio = $_GET['id'];
$socio = $controller->obtenerSocioPorId($id_socio);

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $nombre = $_POST['nombre'];
    $apellido = $_POST['apellido'];
    $email = $_POST['email'];
    $telefono = $_POST['telefono'];
    $fecha_nacimiento = $_POST['fecha_nacimiento'];

    $controller->actualizarSocio($id_socio, $nombre, $apellido, $email, $telefono, $fecha_nacimiento);

    header("Location: lista_socios.php");
    exit();
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar Socio</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h1 class="text-center">Editar Socio</h1>
        <form method="POST" class="mt-4">
            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre:</label>
                <input type="text" id="nombre" name="nombre" class="form-control" value="<?= $socio['nombre'] ?>" required>
            </div>
            <div class="mb-3">
                <label for="apellido" class="form-label">Apellido:</label>
                <input type="text" id="apellido" name="apellido" class="form-control" value="<?= $socio['apellido'] ?>" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email:</label>
                <input type="email" id="email" name="email" class="form-control" value="<?= $socio['email'] ?>" required>
            </div>
            <div class="mb-3">
                <label for="telefono" class="form-label">Teléfono:</label>
                <input type="text" id="telefono" name="telefono" class="form-control" value="<?= $socio['telefono'] ?>" required>
            </div>
            <div class="mb-3">
                <label for="fecha_nacimiento" class="form-label">Fecha de Nacimiento:</label>
                <input type="date" id="fecha_nacimiento" name="fecha_nacimiento" class="form-control" value="<?= $socio['fecha_nacimiento'] ?>" required>
            </div>
            <button type="submit" class="btn btn-success">Actualizar</button>
            <a href="lista_socios.php" class="btn btn-secondary">Cancelar</a>
        </form>
    </div>
</body>
</html>

