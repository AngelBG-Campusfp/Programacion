from datetime import datetime

# Función para registrar un cliente
def registrar_cliente(conexion):
    cursor = conexion.cursor()
    
    nombre = input("Nombre: ")
    apellido = input("Apellido: ")
    email = input("E-mail: ")
    telefono = input("Telefono: ")
    direccion = input("Direccion: ")
    ciudad = input("Ciudad: ")
    codigo_postal = input("Codigo postal: ")

    crear_cliente = f"""
        INSERT INTO cliente (Nombre, Apellido, E_Mail, Telefono, Direccion, Ciudad, Codigo_postal)
        VALUES (%s, %s, %s, %s, %s, %s, %s)"""
    
    valores = (nombre, apellido, email, telefono, direccion, ciudad, codigo_postal)
    
    cursor.execute(crear_cliente, valores)

    conexion.commit()
    print("El cliente ha sido registrado correctamente.")

    cursor.close()


# Función para ver todos los clientes
def ver_clientes(conexion):
    cursor = conexion.cursor()
    
    ver_todos_clientes = "SELECT * FROM cliente"
    cursor.execute(ver_todos_clientes)
    clientes = cursor.fetchall()
    
    print("Clientes registrados:")
    for i in clientes:
        print(i)
    cursor.close()


# Función para buscar un cliente por E-mail
def buscar_cliente(conexion):
    cursor = conexion.cursor()
    
    email = input("Ingresa el E-mail del cliente que desea buscar: ")
    
    buscar_cliente_especifico = f"SELECT * FROM cliente WHERE E_Mail = %s"
    valores = (email,)
    
    cursor.execute(buscar_cliente_especifico, valores)
    cliente = cursor.fetchone()
    
    if cliente:
        print("Cliente encontrado:", cliente)
    else:
        print("No se encontró ningún cliente con ese E-mail.")
    cursor.close()




#----------------------------------------Combinacion de tablas---------------------------------------




# Función para realizar una compra
def realizar_compra(conexion):
    cursor = conexion.cursor()
    
    id_cliente = int(input("ID del cliente que desea realizar la compra: "))
    cursor.execute("SELECT * FROM productos")
    productos = cursor.fetchall()

    print("Productos disponibles:")
    for i in productos:
        print(f"ID: {i[0]}, Nombre: {i[1]}, Precio: {i[2]}")

    pedido_productos = []
    while True:
        id_producto = int(input("ID del producto a comprar (0 para finalizar): "))
        if id_producto == 0:
            break
        cantidad = int(input("Cantidad: "))
        precio = next(p[2] for p in productos if p[0] == id_producto)
        pedido_productos.append((id_producto, cantidad, precio * cantidad))

    fecha_pedido = datetime.now()
    
    # Insertar el pedido
    insertar_pedido = f"INSERT INTO pedidos (Id_Cliente, fecha_pedido) VALUES (%s, %s)"
    valores = (id_cliente, fecha_pedido)
    cursor.execute(insertar_pedido, valores)
    conexion.commit()
    pedido_id = cursor.lastrowid

    # Insertar los productos del pedido
    for id_producto, cantidad, precio in pedido_productos:
        insertar_prodcutos = f"""
            INSERT INTO pedido_detalle (Id_Pedido, Id_Producto, Cantidad, Precio)
            VALUES (%s, %s, %s, %s)"""
        valores = (pedido_id, id_producto, cantidad, precio)
        cursor.execute(insertar_prodcutos, valores)
    
    conexion.commit()
    print(f"Compra realizada con éxito. Número de pedido: {pedido_id}")
    cursor.close()


# Función para el seguimiento de una compra
def seguimiento_compra(conexion):
    cursor = conexion.cursor()
    
    id_pedido = int(input("Ingresa el número de pedido: "))
    
    seguir_pedido = f"""
        SELECT c.Nombre, c.Apellido, c.E_Mail, p.fecha_pedido, d.Id_Producto, d.Cantidad, d.Precio
        FROM pedidos p
        JOIN cliente c ON p.Id_Cliente = c.Id_Cliente
        JOIN pedido_detalle d ON p.Id_Pedido = d.Id_Pedido
        WHERE p.Id_Pedido = %s"""
    valores = (id_pedido,)
    
    cursor.execute(seguir_pedido, valores)
    detalles = cursor.fetchall()

    if detalles:
        print("Detalles del pedido:")
        for detalle in detalles:
            print(f"Cliente: {detalle[0]} {detalle[1]}, Email: {detalle[2]}, Fecha: {detalle[3]}")
            print(f"Producto ID: {detalle[4]}, Cantidad: {detalle[5]}, Precio: {detalle[6]}")
    else:
        print("No se encontró ningún pedido con ese número.")
    cursor.close()


