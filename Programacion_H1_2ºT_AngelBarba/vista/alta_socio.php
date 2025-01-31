<?php
require_once '../controlador/SociosController.php';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $nombre = $_POST['nombre'] ?? null;
    $apellidos = $_POST['apellidos'] ?? null; 
    $correo = $_POST['correo'] ?? null; 
    $edad = $_POST['edad'] ?? null;
    $plan_base = $_POST['plan_base'] ?? null;
    $paquete = $_POST['paquetes'] ?? null;
    $duracion_suscripcion = $_POST['duracion_suscripcion'] ?? null;

    // Verificar que todos los campos estén llenos
    if ($nombre && $apellidos && $correo && $edad && $plan_base && $paquete && $duracion_suscripcion) {
        $controller = new SociosController();
        $controller->agregarSocio($nombre, $apellidos, $correo, $edad, $plan_base, $paquete, $duracion_suscripcion);

        header("Location: lista_socios.php");
        exit();
    } else {
        echo "<script>alert('Todos los campos son obligatorios.');</script>";
    }
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Agregar Socio</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h1 class="text-center">Agregar Nuevo Socio</h1>
        <form method="POST" class="mt-4">
            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre:</label>
                <input type="text" id="nombre" name="nombre" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="apellidos" class="form-label">Apellidos:</label>
                <input type="text" id="apellidos" name="apellidos" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="correo" class="form-label">Email:</label>
                <input type="email" id="correo" name="correo" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="edad" class="form-label">Edad:</label>
                <input type="text" id="edad" name="edad" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="plan_base" class="form-label">Plan Base:</label>
                <select id="plan_base" name="plan_base" class="form-control" required>
                    <option value="">Seleccione un plan</option>
                    <option value="Basico">Básico</option>
                    <option value="Estandar">Estándar</option>
                    <option value="Premium">Premium</option>
                </select>
            </div>
            <div class="mb-3">
                <label for="paquetes" class="form-label">Paquetes Adicionales:</label>
                <select id="paquetes" name="paquetes" class="form-control" multiple required>
                    <option value="Infantil">Pack Infantil</option>
                    <option value="Deporte">Pack Deporte</option>
                    <option value="Cine">Pack Cine</option>
                </select>
            </div>
            <div class="mb-3">
                <label for="duracion_suscripcion" class="form-label">Duración de la Suscripción:</label>
                <select id="duracion_suscripcion" name="duracion_suscripcion" class="form-control" required>
                    <option value="">Seleccione duración</option>
                    <option value="1 mes">1 Mes</option>
                    <option value="3 meses">3 Meses</option>
                    <option value="6 meses">6 Meses</option>
                    <option value="1 año">1 Año</option>
                </select>
            </div>
            <button type="submit" class="btn btn-success">Guardar</button>
            <a href="lista_socios.php" class="btn btn-secondary">Cancelar</a>
        </form>
    </div>
</body>
</html>
