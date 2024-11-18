#--------------------------------------Tabla clientes--------------------------------------

def crear_cliente(conexion):
    cursor = conexion.cursor()

    Nombre = input('\nIntroduce el nombre del nuevo cliente: ')
    edad = int(input('Introduce la edad del nuevo cliente: '))
    tipo_membresia = input('Introduce el tipo de membresia del nuevo cliente: ')

    nuevo_cliente = f""" 
    INSERT INTO clientes (nombre, edad, tipo_membresia) 
    VALUES (%s, %s,%s);
    """

    valores = (Nombre, edad, tipo_membresia)

    cursor.execute(nuevo_cliente, valores)
    cursor.commit()
    print('\nCliente creado correctamente.')

    cursor.close()


def leer_cliente(conexion):
    cursor = conexion.cursor()

    cursor.execute('SELECT * FROM clientes;\n')

    clientes = cursor.fetchall()

    print('=== Clientes en le centro deportivo ===')

    for i in clientes:
        print(f'ID: {i[0]}, Nombre: {i[1]}, Edad: {i[2]}, Membresia: {i[3]}')

    cursor.close()


def actualizar_cliente(conexion):
    cursor = conexion.cursor()

    Id_cliente = int(input('\nID del cliente que desea modificar: '))
    Nombre = input('Introduce el nuevo nombre del cliente: ')
    edad = int(input('Introduce la nueva edad del cliente: '))
    tipo_membresia = input('Introduce el nuevo tipo de membresia cliente: ')

    actualizado_de_cliente = f"""
    UPDATE clientes
    SET nombre = %s, edad = %s, tipo_membresia = %s
    WHERE id_cliente = %s
    """

    valores = (Nombre, edad, tipo_membresia, Id_cliente)

    cursor.execute(actualizado_de_cliente, valores)
    cursor.commit()

    cursor.close()


def eliminar_cliente(conexion):
    cursor = conexion.cursor()

    Id_cliente = int(input('\nID del cleinte que desea eliminar: '))
    
    eliminar_un_cliente = f"""
    DELETE FROM clientes 
    WHERE id_cliente = %s
    """

    valores = (Id_cliente,)

    cursor.execute(eliminar_un_cliente, Id_cliente)
    cursor.commit()

    cursor.close()









#--------------------------------------Tabla actividades--------------------------------------

def nueva_actividad(conexion):
    cursor = conexion.cursor()

    nombre_actividad = input('\nIntroduce el nombre de la actividad: ')
    horario = input('Introduce el horario de la actividad (Ejemplo, "Lunes 10:00 AM"): ')
    duracion = int(input('Introduce la duración de la actividad (en minutos): '))
    Id_entrenador = int(input('Introduce el ID del entrenador responsable: '))

    crear_nueva_actividad = f"""
    INSERT INTO actividades (nombre_actividad, horario, duracion, id_entrenador)
    VALUES (%s, %s, %s, %s)
    """

    valores = (nombre_actividad, horario, duracion, Id_entrenador)

    cursor.execute(crear_nueva_actividad, valores)
    cursor.commit()
    print('La nueva actividad se ha creado con exito!')
    cursor.close()


def leer_actividad(conexion):
    cursor = conexion.cursor()

    ver_actividades = """
    SELECT a.id_actividad, a.nombre_actividad, a.horario, a.duracion, e.nombre_entrenador
    FROM actividades a
    JOIN entrenadores e ON a.id_entrenador = e.id_entrenador
    """

    cursor.execute(ver_actividades)
    actividades = cursor.fetchall()

    print('\nLista de actividades:')
    for i in actividades:
        print(f'ID: {i[0]}, Nombre: {i[1]}, Horario: {i[2]}, Duración: {i[3]} minutos, Entrenador: {i[4]}')

    cursor.close()
    

def actualizar_actividad(conexion):
    cursor = conexion.cursor()

    Id_actividad = int(input('\nIntroduce el ID de la actividad que desea actualizar: '))
    nombre_actividad = input('Nombre de la nueva actividad: ')
    horario = input('Nuevo horario de la actividad (e.g., "Lunes 10:00 AM"): ')
    duracion = int(input('Nueva duracion de la actividad (en minutos): '))
    id_entrenador = int(input('ID del nuevo entrenador responsable: '))

    actualizado_de_actividades = f"""
    UPDATE actividades
    SET nombre_actividad = %s, horario = %s, duracion = %s, id_entrenador = %s
    WHERE id_actividad = %s
    """

    valores = (nombre_actividad, horario, duracion, id_entrenador, Id_actividad)

    cursor.execute(actualizado_de_actividades, valores)
    cursor.commit()
    print('La actividad ha sido actualizada con exito!')

    cursor.close()


def eliminar_actividad(conexion):
    cursor = conexion.cursor()

    Id_actividad = int(input('\nID de la actividad que desea eliminar: '))
    
    cursor.execute(f"DELETE FROM inscripciones WHERE id_actividad = %s", (Id_actividad,))

    cursor.execute(f"DELETE FROM actividades WHERE id_actividad = %s", (Id_actividad,))
    conexion.commit()

    print('La actividad ha sido eliminada correctamente!')









#--------------------------------------Tabla entrenadores--------------------------------------

def crear_entrenador(conexion):
    cursor = conexion.cursor()

    nombre_entrenador = input('\nIntroduce el nombre del entrenador: ')
    especialidad = input('Introduce la especialidad del entrenador: ')

    nuevo_entrenador = f"""
    INSERT INTO entrenadores (nombre_entrenador, especialidad) VALUES (%s, %s)
    """

    valores = (nombre_entrenador, especialidad)

    cursor.execute(nuevo_entrenador, valores)
    conexion.commit()
    print('\nSe ha creado con exito!')

    cursor.close()


def leer_entrenador(conexion):
    cursor = conexion.cursor()

    ver_entrenadores = """
    SELECT * FROM entrenadores
    """

    cursor.execute(ver_entrenadores)
    entrenadores = cursor.fetchall()

    print('\nEntrenadores: ')
    for i in entrenadores:
        print(f'ID: {i[0]}, Nombre: {i[1]}, Especialidad: {i[2]}')
    
    cursor.close()


def actualizar_entrenador(conexion):
    cursor = conexion.cursor()

    Id_entrenador = int(input('\nID del entrenador a actualizar: '))
    nombre = input('Nuevo nombre del entrenador: ')
    especialidad = input('Nueva especialidad del entrenador: ')

    actualizar_un_entrenador = f"""
    UPDATE entrenadores
    SET nombre_entrenador = %s, especialidad = %s
    WHERE id_entrenador = %s
    """

    valores = (nombre, especialidad, Id_entrenador)

    cursor.execute(actualizar_un_entrenador, valores)
    cursor.commit()
    print('\nSe ha actulizado correctamente')

    cursor.close()


def eliminar_entrenador(conexion):
    cursor = conexion.cursor()

    Id_entrenador = int(input('\nID del entrenador que desea eliminar: '))

    cursor.execute("DELETE FROM actividades WHERE id_entrenador = %s", (Id_entrenador,))

    cursor.execute("DELETE FROM entrenadores WHERE id_entrenador = %s", (Id_entrenador,))
    conexion.commit()
    print('\nSe ha eliminado correctamente!')








#--------------------------------------Tabla inscripciones--------------------------------------

def registrar_inscripcion(conexion):
    cursor = conexion.cursor()

    Id_cliente = int(input('\nID del cliente: '))
    Id_actividad = int(input('ID de la actividad: '))

    registro_de_inscripcion = f"""
    INSERT INTO inscripciones (id_cliente, id_actividad) VALUES (%s, %s)
    """

    valores = (Id_cliente, Id_actividad)

    cursor.execute(registro_de_inscripcion,valores)
    cursor.commit()
    print('\nLa inscripcion se ha registrado correctamente!')


def leer_inscripcion(conexion):
    cursor = conexion.cursor()

    leer_las_inscripciones = f"""
    SELECT i.id_inscripcion, c.nombre AS cliente, a.nombre_actividad AS actividad, a.horario
    FROM inscripciones i
    JOIN clientes c ON i.id_cliente = c.id_cliente
    JOIN actividades a ON i.id_actividad = a.id_actividad
    """

    cursor.execute(leer_las_inscripciones)
    inscripciones = cursor.fetchall()

    for i in inscripciones:
        print(f'ID Inscripción: {i[0]}, Cliente: {i[1]}, Actividad: {i[2]}, Horario: {i[3]}')

    cursor.close()

    