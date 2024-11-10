import EjerciciosPython15MENU

#----------------------------------------------------------------Tabla Categoria-----------------------------------------------------------------------#
#Creo una funcion 
#para que el usuario cree una categoria
def crear_categoria(conexion):
    #Creamos el cursor
    cursor = conexion.cursor()
    id_Categoria = int(input('Ingresa el ID de la nueva categoria: '))
    Nombre_Categoria = input('Ingresa el nombre de la nueva categoria: ')
   
   #Creamos la sentencia SQL
    nueva_categoria = f"""INSERT INTO categoria (idcategoria, categoria)
    VALUES (%s, %s);
     """
    
    #Asignamos los valores para %s
    valores = (id_Categoria, Nombre_Categoria)

    #Hacmeos que se ejecute la sentencia 
    # con los valores que añada el usuario
    cursor.execute(nueva_categoria, valores)
    conexion.commit()
    print('Catgoria creada \n')

    #Cerramos el cursor
    cursor.close()


#Creo una funcion que lea todas las 
#categorias que hay en la tabla
def  leer_categoria(conexion):
    #Creo el cursor
    cursor = conexion.cursor()

    #Creamos la sentencia SQL
    cursor.execute("SELECT * FROM categoria;\n")
    #recuperamos los resultados
    categorias = cursor.fetchall()
    
    print("=== Listado de Categorías ===")
    #Bucle para sacar todas los id y nombres de categorias
    for i in categorias:
        print(f"ID: {i[0]}, Nombre: {i[1]}")

    #Cerramos el cursor
    cursor.close()


#Creo una funcion 
#que actualice la categoria que quiera el usuario
def actualizar_categoria(conexion):
    #Creo el cursor
    cursor = conexion.cursor()
    id_Categoria2 = int(input('ID de la categoria quye desea modificar: '))
    nombre_nuevacategoria = input('Nombre para la categoria que desea modificar: ')
    
    #Creamos la sentencia SQL
    actualizar_registro = f""" UPDATE categoria
    SET categoria = %s WHERE idcategoria = %s; """

    #Asignamos los valores para %s
    valores = (nombre_nuevacategoria, id_Categoria2)

    #Hacmeos que se ejecute la sentencia 
    # con los valores que añada el usuario
    cursor.execute(actualizar_registro, valores)
    conexion.commit()
    print('Categoria Actualizada con exito\n')
    #Cerramos el cursor
    cursor.close()


#Creo una funcion 
#que elimine una categoria a eleccion del usuario
def eliminar_categoria(conexion):
    #Creamos el cursor
    cursor = conexion.cursor()
    id_Categoria3 = int(input('ID de la categoria que desea eliminar: '))
    
    #Creamos la sentencia SQL
    eliminar_registro = f""" DELETE FROM categoria
    WHERE idcategoria = %s; """

    #Asignamos los valores para %s
    valores = (id_Categoria3,)
    
    #Hacmeos que se ejecute la sentencia 
    # con los valores que añada el usuario
    cursor.execute(eliminar_registro, valores)
    conexion.commit()
    print('Categoria eliminada con exito\n')

    #Cerramos el cursor
    cursor.close()





#----------------------------------------------------------------Tabla Producto-----------------------------------------------------------------------#




def crear_producto(conexion):
    # Creamos el cursor
    cursor = conexion.cursor()

    # Pedimos los datos al usuario
    id_producto = int(input('Ingresa el ID del nuevo producto: '))
    nombre_producto = input('Ingresa el nombre del producto: ')
    id_categoria = int(input('Ingresa el ID de la categoría: '))
    medida = input('Ingresa la medida del producto: ')
    precio = int(input('Ingresa el precio del producto: '))
    stock = int(input('Ingresa el stock disponible del producto: '))

    # Creamos la sentencia SQL
    nuevo_producto = f"""
        INSERT INTO producto (idproducto, nombre, idcategoria, medida, precio, stock)
        VALUES (%s, %s, %s, %s, %s, %s);
    """
    
    # Asignamos los valores para %s
    valores = (id_producto, nombre_producto, id_categoria, medida, precio, stock)

    # Ejecutamos la sentencia
    cursor.execute(nuevo_producto, valores)
    conexion.commit()
    print('Producto creado con éxito\n')

    # Cerramos el cursor
    cursor.close()


def leer_producto(conexion):
    # Creamos el cursor
    cursor = conexion.cursor()

    # Creamos la sentencia SQL para seleccionar todos los productos
    cursor.execute("SELECT * FROM producto;")
    productos = cursor.fetchall()

    print("=== Listado de Productos ===")
    for producto in productos:
        print(f"ID: {producto[0]}, Nombre: {producto[1]}, Categoría ID: {producto[2]}, Medida: {producto[3]}, Precio: {producto[4]}, Stock: {producto[5]}")

    # Cerramos el cursor
    cursor.close()


def actualizar_producto(conexion):
    # Creamos el cursor
    cursor = conexion.cursor()

    # Pedimos al usuario el ID del producto a actualizar
    id_producto = int(input('Ingresa el ID del producto que deseas actualizar: '))

    # Pedimos los nuevos datos
    nombre_producto = input('Ingresa el nuevo nombre del producto: ')
    id_categoria = int(input('Ingresa el nuevo ID de la categoría: '))
    medida = input('Ingresa la nueva medida del producto: ')
    precio = int(input('Ingresa el nuevo precio del producto: '))
    stock = int(input('Ingresa el nuevo stock del producto: '))

    # Creamos la sentencia SQL para actualizar el producto
    actualizar_producto_sql = f"""
        UPDATE producto
        SET nombre = %s, idcategoria = %s, medida = %s, precio = %s, stock = %s
        WHERE idproducto = %s;"""

    # Asignamos los valores para %s
    valores = (nombre_producto, id_categoria, medida, precio, stock, id_producto)

    # Ejecutamos la sentencia
    cursor.execute(actualizar_producto_sql, valores)
    conexion.commit()
    print('Producto actualizado con éxito\n')

    # Cerramos el cursor
    cursor.close()


def eliminar_producto(conexion):
    # Creamos el cursor
    cursor = conexion.cursor()

    # Pedimos el ID del producto a eliminar
    id_producto = int(input('Ingresa el ID del producto que deseas eliminar: '))

    # Creamos la sentencia SQL para eliminar el producto
    eliminar_producto_sql = f"""
        DELETE FROM producto
        WHERE idproducto = %s;"""

    # Asignamos el valor para %s
    valores = (id_producto,)

    # Ejecutamos la sentencia
    cursor.execute(eliminar_producto_sql, valores)
    conexion.commit()
    print('Producto eliminado con éxito\n')

    # Cerramos el cursor
    cursor.close()




#----------------------------------------------------------------Tabla Cliente-----------------------------------------------------------------------#




def crear_cliente(conexion):
    cursor = conexion.cursor()

    # Pedimos los datos al usuario
    id_cliente = input('Ingresa el ID del nuevo cliente (5 caracteres): ')
    cia = input('Ingresa el nombre de la compañía: ')
    contacto = input('Ingresa el nombre del contacto: ')
    cargo = input('Ingresa el cargo del contacto: ')
    direccion = input('Ingresa la dirección del cliente: ')
    ciudad = input('Ingresa la ciudad del cliente: ')
    region = input('Ingresa la región del cliente: ')
    cp = input('Ingresa el código postal del cliente: ')
    pais = input('Ingresa el país del cliente: ')
    tlf = input('Ingresa el teléfono del cliente: ')
    fax = input('Ingresa el fax del cliente: ')

    nuevo_cliente = f"""
        INSERT INTO cliente (idcliente, cia, contacto, cargo, direccion, ciudad, region, cp, pais, tlf, fax)
        VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s);"""

    # Asignamos los valores para %s
    valores = (id_cliente, cia, contacto, cargo, direccion, ciudad, region, cp, pais, tlf, fax)

    # Ejecutamos la sentencia
    cursor.execute(nuevo_cliente, valores)
    conexion.commit()
    print('Cliente creado con éxito\n')

    # Cerramos el cursor
    cursor.close()

def leer_cliente(conexion):
    # Creamos el cursor
    cursor = conexion.cursor()

    # Creamos la sentencia SQL para seleccionar todos los clientes
    cursor.execute("SELECT * FROM cliente;")
    clientes = cursor.fetchall()

    print("=== Listado de Clientes ===")
    for cliente in clientes:
        print(f"ID: {cliente[0]}, Compañía: {cliente[1]}, Contacto: {cliente[2]}, Cargo: {cliente[3]}, Dirección: {cliente[4]}, Ciudad: {cliente[5]}, Región: {cliente[6]}, CP: {cliente[7]}, País: {cliente[8]}, Teléfono: {cliente[9]}, Fax: {cliente[10]}")

    # Cerramos el cursor
    cursor.close()


def actualizar_cliente(conexion):
    # Creamos el cursor
    cursor = conexion.cursor()

    # Pedimos al usuario el ID del cliente a actualizar
    id_cliente = input('Ingresa el ID del cliente que deseas actualizar (5 caracteres): ')

    # Pedimos los nuevos datos
    cia = input('Ingresa el nuevo nombre de la compañía: ')
    contacto = input('Ingresa el nuevo nombre del contacto: ')
    cargo = input('Ingresa el nuevo cargo del contacto: ')
    direccion = input('Ingresa la nueva dirección del cliente: ')
    ciudad = input('Ingresa la nueva ciudad del cliente: ')
    region = input('Ingresa la nueva región del cliente: ')
    cp = input('Ingresa el nuevo código postal del cliente: ')
    pais = input('Ingresa el nuevo país del cliente: ')
    tlf = input('Ingresa el nuevo teléfono del cliente: ')
    fax = input('Ingresa el nuevo fax del cliente: ')

    # Creamos la sentencia SQL para actualizar el cliente
    actualizar_cliente_sql = f"""
        UPDATE cliente
        SET cia = %s, contacto = %s, cargo = %s, direccion = %s, ciudad = %s, region = %s, cp = %s, pais = %s, tlf = %s, fax = %s
        WHERE idcliente = %s;"""

    # Asignamos los valores para %s
    valores = (cia, contacto, cargo, direccion, ciudad, region, cp, pais, tlf, fax, id_cliente)

    # Ejecutamos la sentencia
    cursor.execute(actualizar_cliente_sql, valores)
    conexion.commit()
    print('Cliente actualizado con éxito\n')

    # Cerramos el cursor
    cursor.close()


def eliminar_cliente(conexion):
    # Creamos el cursor
    cursor = conexion.cursor()

    # Pedimos el ID del cliente a eliminar
    id_cliente = input('Ingresa el ID del cliente que deseas eliminar (5 caracteres): ')

    # Creamos la sentencia SQL para eliminar el cliente
    eliminar_cliente_sql = f"""
        DELETE FROM cliente
        WHERE idcliente = %s;"""

    # Asignamos el valor para %s
    valores = (id_cliente,)

    # Ejecutamos la sentencia
    cursor.execute(eliminar_cliente_sql, valores)
    conexion.commit()
    print('Cliente eliminado con éxito\n')

    # Cerramos el cursor
    cursor.close()





