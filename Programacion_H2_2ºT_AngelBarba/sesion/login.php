<?php
session_start(); // Iniciar sesión para mantener al usuario logueado

// Conexión a la base de datos
$conexion = new mysqli("localhost", "root", "curso", "gestorTareas");

if ($conexion->connect_error) {
    die("Error de conexión: " . $conexion->connect_error);
}

// Recibir datos del formulario
$email = $_POST['email'];
$passwd = $_POST['passwd'];

// Verificar si el usuario existe
$stmt = $conexion->prepare("SELECT id_usuario, nombre, passwd FROM usuarios WHERE email = ?");
$stmt->bind_param("s", $email);
$stmt->execute();
$result = $stmt->get_result();

if ($result->num_rows > 0) {
    // Usuario encontrado, verificar contraseña
    $row = $result->fetch_assoc();
    if (password_verify($passwd, $row['passwd'])) {
        // Contraseña correcta: guardar datos en la sesión
        $_SESSION['id_usuario'] = $row['id_usuario'];
        $_SESSION['nombre'] = $row['nombre'];
        
        // Redirigir a lista_socios.php en la carpeta 'vista'
        header("Location: ../vista/lista_socios.php"); // Ajustado a la carpeta 'vista'
        exit();
    } else {
        // Contraseña incorrecta
        echo "<script>alert('Contraseña incorrecta. Inténtalo de nuevo.'); window.location.href='../login.html';</script>";
    }
} else {
    // Usuario no encontrado
    echo "<script>alert('El correo no está registrado.'); window.location.href='../login.html';</script>";
}

// Cerrar conexión
$stmt->close();
$conexion->close();
?>


