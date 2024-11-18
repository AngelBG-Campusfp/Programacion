import EjerciciosPython19CRUD

def menu_principal(conexion):
    while True:
        print('=== MENU PRINCIPAL ===')
        print('\n1.- Operar con la tabla CLIENTES')
        print('2.- Operar con la tabla ACTIVIDADES')
        print('3.- Operar con la tabla ENTRENADORES')
        print('4.- Operar con la tabla INSCRIPCIONES')
        print('5.- Salir')
        
        eleccion_usuario = int(input('\nSelecciona una opcion (1,2,3,4 o 5): '))

        while True:
            if eleccion_usuario == 1:
                print('=== MENU TABLA CLIENTES ===')
                print('\n1.- Crear cliente')
                print('2.- Ver clientes')
                print('3.- Actualizar cliente')
                print('4.- Eliminar cliente')
                print('5.- Volver atrás')

                eleccion_usuario_cliente = int(input('\nSelecciona una opcion (1,2,3,4 o 5): '))
                
                if eleccion_usuario_cliente == 1:
                    print(EjerciciosPython19CRUD.crear_cliente(conexion))
                if eleccion_usuario_cliente == 2:
                    print(EjerciciosPython19CRUD.leer_cliente(conexion))
                if eleccion_usuario_cliente == 3:
                    print(EjerciciosPython19CRUD.actualizar_cliente(conexion))
                if eleccion_usuario_cliente == 4:
                    print(EjerciciosPython19CRUD.eliminar_cliente(conexion))
                if eleccion_usuario_cliente == 5:
                    break
                else:
                    print('Seleccione una opcion.')
            

            if eleccion_usuario == 2:
                print('=== MENU TABLA ACTIVIDADES ===')
                print('\n1.- Crear actividades')
                print('2.- Ver actividades')
                print('3.- Actualizar actividades')
                print('4.- Eliminar actividades')
                print('5.- Volver atrás')

                eleccion_usuario_cliente = int(input('\nSelecciona una opcion (1,2,3,4 o 5): '))
                
                if eleccion_usuario_cliente == 1:
                    print(EjerciciosPython19CRUD.nueva_actividad(conexion))
                if eleccion_usuario_cliente == 2:
                    print(EjerciciosPython19CRUD.leer_actividad(conexion))
                if eleccion_usuario_cliente == 3:
                    print(EjerciciosPython19CRUD.actualizar_actividad(conexion))
                if eleccion_usuario_cliente == 4:
                    print(EjerciciosPython19CRUD.eliminar_actividad(conexion))
                if eleccion_usuario_cliente == 5:
                    break
                else:
                    print('Seleccione una opcion.')


            if eleccion_usuario == 3:
                print('=== MENU TABLA ENTRENADORES ===')
                print('\n1.- Crear entrenador')
                print('2.- Ver entrenador')
                print('3.- Actualizar entrenador')
                print('4.- Eliminar entrenador')
                print('5.- Volver atrás')

                eleccion_usuario_cliente = int(input('\nSelecciona una opcion (1,2,3,4 o 5): '))
                
                if eleccion_usuario_cliente == 1:
                    print(EjerciciosPython19CRUD.crear_entrenador(conexion))
                if eleccion_usuario_cliente == 2:
                    print(EjerciciosPython19CRUD.leer_entrenador(conexion))
                if eleccion_usuario_cliente == 3:
                    print(EjerciciosPython19CRUD.actualizar_entrenador(conexion))
                if eleccion_usuario_cliente == 4:
                    print(EjerciciosPython19CRUD.eliminar_entrenador(conexion))
                if eleccion_usuario_cliente == 5:
                    break
                else:
                    print('Seleccione una opcion.')

            
            if eleccion_usuario == 4:
                print('=== MENU TABLA INSCRIPCIONES ===')
                print('\n1.- Registrar inscripcion')
                print('2.- Leer incripciones')
                print('3.- Volver atrás')

                eleccion_usuario_cliente = int(input('\nSelecciona una opcion (1,2 o 3): '))
                
                if eleccion_usuario_cliente == 1:
                    print(EjerciciosPython19CRUD.registrar_inscripcion(conexion))
                if eleccion_usuario_cliente == 2:
                    print(EjerciciosPython19CRUD.leer_inscripcion(conexion))
                if eleccion_usuario_cliente == 3:
                    break
                else:
                    print('Seleccione una opcion.')

            if eleccion_usuario == 5:
                print('Saliendo...')
                break