<?php
require_once '../controlador/SociosController.php';
$controller = new EventosController();
$evento = $controller->listarEventos();
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Listado de Eventos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-4">
        <h1 class="text-center mb-4">Eventos Registrados</h1>
        <table class="table table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Fecha</th>
                    <th>Lugar</th>
                </tr>
            </thead>
            <tbody>
                <?php foreach ($evento as $evento): ?>
                    <tr>
                        <td><?= $evento['id_evento'] ?></td>
                        <td><?= $evento['nombre_evento'] ?></td>
                        <td><?= $evento['fecha'] ?></td>
                        <td><?= $evento['lugar'] ?></td>
                        <td>
                            <a href="editar_evento.php?id=<?= $evento['id_evento'] ?>" class="btn btn-dark btn-sm">Editar</a>
                            <a href="eliminar_evento.php?id=<?= $evento['id_evento'] ?>" class="btn btn-danger btn-sm">Eliminar</a>
                        </td>
                    </tr>
                <?php endforeach; ?>
            </tbody>
        </table>
        <a href="alta_evento.php" class="btn btn-dark">Agregar un nuevo Evento</a>
    </div>
</body>
</html>

