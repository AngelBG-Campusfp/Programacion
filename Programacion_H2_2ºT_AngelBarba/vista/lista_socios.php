<?php
require_once '../controlador/SociosController.php';
$controller = new SociosController();
$tareas = $controller->listarTareas();
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Listado de Tareas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Estilos generales */
        body {
            background-color: #f5f5f5;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            color: #333;
        }

        .container {
            margin-top: 50px;
            background-color: #fff;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0px 8px 20px rgba(0, 0, 0, 0.1);
        }

        h1 {
            color: #4B4F58;
            font-size: 2.5rem;
            text-align: center;
            font-weight: 600;
            margin-bottom: 40px;
        }

        .table {
            border-radius: 10px;
            overflow: hidden;
        }

        .table th, .table td {
            text-align: center;
            padding: 15px;
            font-size: 1.1rem;
        }

        .table thead {
            background-color: #6c5ce7;
            color: white;
        }

        .table tbody tr {
            background-color: #f9f9f9;
            transition: background-color 0.3s ease;
        }

        .table tbody tr:hover {
            background-color: #e8e8e8;
        }

        .btn {
            border-radius: 8px;
            padding: 10px 20px;
            font-size: 1rem;
            font-weight: 500;
            transition: 0.3s;
        }

        .btn:hover {
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.2);
        }

        .btn-warning {
            background-color: #ffca2c;
            color: #fff;
            border: none;
        }

        .btn-warning:hover {
            background-color: #f4b600;
        }

        .btn-danger {
            background-color: #e74c3c;
            color: #fff;
            border: none;
        }

        .btn-danger:hover {
            background-color: #c0392b;
        }

        .btn-dark {
            background-color: #333;
            color: #fff;
            border: none;
        }

        .btn-dark:hover {
            background-color: #444;
        }

        .text-center {
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Tareas Registradas</h1>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Título</th>
                    <th>Descripción</th>
                    <th>Estado</th>
                    <th>Fecha Creación</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <?php if (empty($tareas)): ?>
                    <tr><td colspan="6" class="text-center">No hay tareas registradas.</td></tr>
                <?php else: ?>
                    <?php foreach ($tareas as $tarea): ?>
                        <tr>
                            <td><?= $tarea['id_tarea'] ?></td>
                            <td><?= $tarea['titulo'] ?></td>
                            <td><?= $tarea['descripcion'] ?></td>
                            <td><?= $tarea['estado'] ?></td>
                            <td><?= $tarea['fecha_creacion'] ?></td>
                            <td>
                                <!-- Botón para actualizar tarea -->
                                <a href="editar_socio.php?id_tarea=<?= $tarea['id_tarea'] ?>" 
                                class="btn btn-warning btn-sm">
                                    ✏️ Editar
                                </a>

                                <!-- Botón para eliminar tarea -->
                                <a href="eliminar_socio.php?id_tarea=<?= $tarea['id_tarea'] ?>" 
                                class="btn btn-danger btn-sm"
                                onclick="return confirm('¿Estás seguro de eliminar esta tarea?');">
                                    ❌ Eliminar
                                </a>
                            </td>
                        </tr>
                    <?php endforeach; ?>
                <?php endif; ?>
            </tbody>
        </table>
        <div class="text-center">
            <a href="alta_socio.php" class="btn btn-dark">Agregar una nueva tarea</a>
        </div>
    </div>
</body>
</html>




