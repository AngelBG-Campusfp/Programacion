<?php
require_once '../controlador/SociosController.php';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $titulo = $_POST['titulo'] ?? null;
    $descripcion = $_POST['descripcion'] ?? null; 
    $estado = $_POST['estado'] ?? null; 
    $fecha_creacion = $_POST['fecha_creacion'] ?? null;

    // Verificar que todos los campos estén llenos
    if ($titulo && $descripcion && $estado && $fecha_creacion) {
        $controller = new SociosController();
        $controller->agregarTarea($titulo, $descripcion, $estado, $fecha_creacion);

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
    <title>Agregar Tarea</title>
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
            padding: 40px;
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

        .form-label {
            font-weight: 600;
            color: #4B4F58;
        }

        .form-control {
            border-radius: 8px;
            padding: 12px;
            font-size: 1.1rem;
            border: 1px solid #ddd;
        }

        .form-control:focus {
            border-color: #6c5ce7;
            box-shadow: 0 0 5px rgba(108, 92, 231, 0.5);
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

        .btn-success {
            background-color: #28a745;
            color: #fff;
            border: none;
        }

        .btn-success:hover {
            background-color: #218838;
        }

        .btn-secondary {
            background-color: #6c757d;
            color: #fff;
            border: none;
        }

        .btn-secondary:hover {
            background-color: #5a6268;
        }

        .text-center {
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Agregar Nueva Tarea</h1>
        <form method="POST" class="mt-4">
            <div class="mb-3">
                <label for="titulo" class="form-label">Título:</label>
                <input type="text" id="titulo" name="titulo" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="descripcion" class="form-label">Descripción:</label>
                <input type="text" id="descripcion" name="descripcion" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="estado" class="form-label">Estado:</label>
                <select id="estado" name="estado" class="form-control" required>
                    <option value="">Seleccione un estado</option>
                    <option value="pendiente">Pendiente</option>
                    <option value="completada">Completada</option>
                </select>
            </div>
            <div class="mb-3">
                <label for="fecha_creacion" class="form-label">Fecha Creación:</label>
                <input type="date" id="fecha_creacion" name="fecha_creacion" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-success">Guardar</button>
            <a href="lista_socios.php" class="btn btn-secondary">Cancelar</a>
        </form>
    </div>
</body>
</html>

