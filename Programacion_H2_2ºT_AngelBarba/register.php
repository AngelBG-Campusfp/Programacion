<?php
// Conexión a la base de datos
$conexion = new mysqli("localhost", "root", "curso", "gestorTareas");

if ($conexion->connect_error) {
    die("Error de conexión: " . $conexion->connect_error);
}

// Recibir datos del formulario
$nombre = $_POST['nombre'];
$email = $_POST['email'];
$passwd = password_hash($_POST['passwd'], PASSWORD_BCRYPT); // Encriptamos la contraseña
$fecha_registro = date('Y-m-d');

// Verificar si el email ya está registrado
$checkEmail = $conexion->prepare("SELECT email FROM usuarios WHERE email = ?");
$checkEmail->bind_param("s", $email);
$checkEmail->execute();
$result = $checkEmail->get_result();

if ($result->num_rows > 0) {
    echo "<script>alert('El correo ya está registrado.'); window.location.href='index.html';</script>";
} else {
    // Insertar en la base de datos
    $stmt = $conexion->prepare("INSERT INTO usuarios (nombre, email, passwd, fecha_registro) VALUES (?, ?, ?, ?)");
    $stmt->bind_param("ssss", $nombre, $email, $passwd, $fecha_registro);

    if ($stmt->execute()) {
        echo "<script>alert('Registro exitoso, ahora inicia sesión.'); window.location.href='login.html';</script>";
    } else {
        echo "<script>alert('Error al registrar. Inténtalo de nuevo.'); window.location.href='index.html';</script>";
    }

    $stmt->close();
}

$checkEmail->close();
$conexion->close();
?>
