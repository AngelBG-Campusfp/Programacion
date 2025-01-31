<?php
require_once '../controlador/SociosController.php';
$controller = new SociosController();
$socios = $controller->listarSocios();
$planes = $controller->obtenerPlanes();
$paquetes = $controller->obtenerPaquetes();
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Listado de Socios</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h1 class="text-center mb-4">Usuarios Registrados</h1>
        <table class="table table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Apellidos</th>
                    <th>Email</th>
                    <th>Edad</th>
                    <th>Tipo de Plan Base</th>
                    <th>Paquetes Adicionales</th>
                    <th>Duración de la suscripción</th>
                    <th>Coste Mensual</th>
                </tr>
            </thead>
            <tbody>
                <?php foreach ($socios as $socio): ?>
                    <tr>
                        <td><?= $socio['id'] ?></td>
                        <td><?= $socio['nombre'] ?></td>
                        <td><?= $socio['apellidos'] ?></td>
                        <td><?= $socio['correo'] ?></td>
                        <td><?= $socio['edad'] ?></td>
                        <td><?= $socio['plan_base'] ?></td>
                        <td><?= $socio['nombre_paquete_extra'] ?></td>
                        <td><?= $socio['duracion_suscripcion'] ?></td>
                        <td>
                            <a href="editar_socio.php?id=<?= $socio['id'] ?>" class="btn btn-dark btn-sm">Editar</a>
                            <a href="eliminar_socio.php?id=<?= $socio['id'] ?>" class="btn btn-danger btn-sm">Eliminar</a>
                        </td>
                    </tr>
                <?php endforeach; ?>
            </tbody>
        </table>
        <a href="alta_socio.php" class="btn btn-dark">Agregar un nuevo socio</a>
        
        <h2 class="mt-5">Planes de Suscripción</h2>
        <table class="table table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>Tipo de Plan</th>
                    <th>Precio Mensual (€)</th>
                </tr>
            </thead>
            <tbody>
                <?php foreach ($planes as $plan): ?>
                    <tr>
                        <td><?= $plan['plan_base'] ?></td>
                        <td><?= number_format($plan['costo_mensual'], 2) ?> €</td>
                    </tr>
                <?php endforeach; ?>
            </tbody>
        </table>
        
        <h2 class="mt-5">Paquetes Adicionales</h2>
        <table class="table table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>Pack</th>
                    <th>Precio Mensual (€)</th>
                </tr>
            </thead>
            <tbody>
                <?php foreach ($paquetes as $paquete): ?>
                    <tr>
                        <td><?= $paquete['nombre'] ?></td>
                        <td><?= number_format($paquete['costo_mensual'], 2) ?> €</td>
                    </tr>
                <?php endforeach; ?>
            </tbody>
        </table>
    </div>
</body>
</html>


