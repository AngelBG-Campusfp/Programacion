<?php
session_start();

// Verifica si el usuario está logueado
if (!isset($_SESSION['email'])) {
    // Si no está logueado, redirige al inicio de sesión
    header("Location: login.php");
    exit();
}

// Conexión a la base de datos
$servername = "localhost";
$username = "root"; // Tu usuario de MySQL
$password = "curso"; // Tu contraseña de MySQL
$dbname = "gestorTareas";

$conn = new mysqli($servername, $username, $password, $dbname);

// Verificar la conexión
if ($conn->connect_error) {
    die("Conexión fallida: " . $conn->connect_error);
}

$email = $_SESSION['email'];

// Obtener el nombre del usuario desde la base de datos
$sql = "SELECT nombre FROM usuarios WHERE email = '$email'";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // Obtener el nombre
    $row = $result->fetch_assoc();
    $nombre = $row['nombre'];
} else {
    echo "Error al obtener los datos del usuario.";
    exit();
}

$conn->close();
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Panel de Control - Gestor de Tareas</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }
        h2 {
            color: #4CAF50;
        }
        button {
            width: 100%;
            padding: 10px;
            background-color: #f44336;
            color: #fff;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }
        button:hover {
            background-color: #d32f2f;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>Bienvenido, <?php echo htmlspecialchars($nombre); ?>!</h2>
        <p>¡Estás logueado correctamente!</p>

        <!-- Aquí puedes agregar tareas y otras funcionalidades -->
        <button onclick="window.location.href='logout.php'">Cerrar sesión</button>
    </div>

</body>
</html>
