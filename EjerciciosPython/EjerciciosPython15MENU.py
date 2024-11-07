import EjerciciosPython15CRUD

#Funcion para imprimir el menu
#y hacer que sea funcional
def menu(conexion):
    while True:
        print('=== Gestion de Categorias ===')
        
        print('1. Crear una nueva categoria')
        print('2. Leer categorias existentes')
        print('3. Actualizar una categoria')
        print('4. Eliminar una categoria')
        print('5. Salir')
        opcion_usuario = int(input('Seleccione una opcion: '))

        #Si el usuario elige 1,
        #Llamamos a la funcion crear_categoria
        if opcion_usuario == 1:
            print(EjerciciosPython15CRUD.crear_categoria(conexion))
        
        #Si el usuario elige 2,
        #Llamamos a la funcion leer_categoria
        elif opcion_usuario == 2:
            print(EjerciciosPython15CRUD.leer_categoria(conexion))

        #Si el usuario elige 3,
        #Llamamos a la funcion actualizar_categoria
        elif opcion_usuario == 3:
            print(EjerciciosPython15CRUD.actualizar_categoria(conexion))

        #Si el usuario elige 4,
        #Llamamos a la funcion eliminar_categoria
        elif opcion_usuario == 4:
            print(EjerciciosPython15CRUD.eliminar_categoria(conexion))
        
        #Si el usuario elige cualquier otra opcion,
        # Sale del programa
        else:
            print('Saliendo del programa...')
            break
