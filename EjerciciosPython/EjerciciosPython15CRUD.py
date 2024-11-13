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





