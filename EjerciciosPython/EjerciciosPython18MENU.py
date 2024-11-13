import EjerciciosPython18CRUD

#Funcion para imprimir el menu
#y hacer que sea funcional

def menu_tablas(conexion):
    while True:
        print("\nMenú de opciones:")
        print("1. Operaciones sobre la tabla Producto")
        print("2. Operaciones sobre la tabla Categoría")
        print("3. Operaciones sobre la tabla Cliente")
        print('4. Operaciones sobre la tabla pedido')
        print("5. Salir\n")

        opcion_usuario_tablas = int(input('Selecciona con que tabla quieres operar (1,2,3,4 o 5 para salir): '))

        if opcion_usuario_tablas == 1:
            print(menu_producto(conexion))
        elif opcion_usuario_tablas == 2:
            print(menu_categoria(conexion))
        elif opcion_usuario_tablas == 3:
            print(menu_cliente(conexion))
        elif opcion_usuario_tablas == 4:
            print(menu_pedido(conexion))
        else:
            print('Saliendo...')
            break

def menu_categoria(conexion):
    while True:
        print('=== Gestion de Categorias ===')
        
        print('1. Crear una nueva categoria')
        print('2. Leer categorias existentes')
        print('3. Actualizar una categoria')
        print('4. Eliminar una categoria')
        print('5. Salir\n')
        opcion_usuario = int(input('Seleccione una opcion: '))

        #Si el usuario elige 1,
        #Llamamos a la funcion crear_categoria
        if opcion_usuario == 1:
            print(EjerciciosPython18CRUD.crear_categoria(conexion))
        
        #Si el usuario elige 2,
        #Llamamos a la funcion leer_categoria
        elif opcion_usuario == 2:
            print(EjerciciosPython18CRUD.leer_categoria(conexion))

        #Si el usuario elige 3,
        #Llamamos a la funcion actualizar_categoria
        elif opcion_usuario == 3:
            print(EjerciciosPython18CRUD.actualizar_categoria(conexion))

        #Si el usuario elige 4,
        #Llamamos a la funcion eliminar_categoria
        elif opcion_usuario == 4:
            print(EjerciciosPython18CRUD.eliminar_categoria(conexion))
        
        #Si el usuario elige cualquier otra opcion,
        # Sale del programa
        else:
            print('Saliendo del programa...')
            break

def menu_producto(conexion):
    while True:
        print('=== Gestion de Productos ===')

        print("1. Crear producto")
        print("2. Leer producto")
        print("3. Actualizar producto")
        print("4. Eliminar producto")
        print("5. Salir\n")
        opcion_usuario = int(input('Seleccione una opcion: '))

            #Si el usuario elige 1,
            #Llamamos a la funcion crear_producto
        if opcion_usuario == 1:
            print(EjerciciosPython18CRUD.crear_producto(conexion))
            
        #Si el usuario elige 2,
        #Llamamos a la funcion leer_producto
        elif opcion_usuario == 2:
            print(EjerciciosPython18CRUD.leer_producto(conexion))

        #Si el usuario elige 3,
        #Llamamos a la funcion actualizar_producto
        elif opcion_usuario == 3:
            print(EjerciciosPython18CRUD.actualizar_producto(conexion))

        #Si el usuario elige 4,
        #Llamamos a la funcion eliminar_producto
        elif opcion_usuario == 4:
            print(EjerciciosPython18CRUD.eliminar_producto(conexion))
            
        #Si el usuario elige cualquier otra opcion,
        # Sale del programa
        else:
            print('Saliendo del programa...')
            break

def menu_cliente(conexion):
    while True:
        print('=== Gestión de Productos ===')
        print("1. Crear producto")
        print("2. Leer producto")
        print("3. Actualizar producto")
        print("4. Eliminar producto")
        print("5. Salir\n")

        opcion_usuario = int(input('Seleccione una opción: '))

        #Si el usuario elige 1,
        #Llamamos a la funcion crear_cliente
        if opcion_usuario == 1:
            print(EjerciciosPython18CRUD.crear_cliente(conexion))
        
        #Si el usuario elige 2,
        #Llamamos a la funcion leer_cliente
        elif opcion_usuario == 2:
            print(EjerciciosPython18CRUD.leer_cliente(conexion))

        #Si el usuario elige 3,
        #Llamamos a la funcion actualizar_cliente
        elif opcion_usuario == 3:
            print(EjerciciosPython18CRUD.actualizar_cliente(conexion))

        #Si el usuario elige 4,
        #Llamamos a la funcion eliminar_cliente
        elif opcion_usuario == 4:
            print(EjerciciosPython18CRUD.eliminar_cliente(conexion))
        
        #Si el usuario elige 5,
        #Salir
        elif opcion_usuario == 5:
            print('Saliendo del programa...')
            break

def menu_pedido(conexion):
      while True:
        print('=== Gestión de Pedidos ===')
        print("1. Crear pedido")
        print("2. Leer pedidos")
        print("3. Actualizar pedido")
        print("4. Eliminar pedido")
        print("5. Salir\n")
        opcion_usuario = int(input('Seleccione una opción: '))

        #Si el usuario elige 1,
        #Llamamos a la funcion crear_pedido
        if opcion_usuario == 1:
            print(EjerciciosPython18CRUD.crear_pedido(conexion))

        #Si el usuario elige 2,
        #Llamamos a la funcion leer_pedido
        elif opcion_usuario == 2:
            print(EjerciciosPython18CRUD.leer_pedido(conexion))

        #Si el usuario elige 3,
        #Llamamos a la funcion actualizar_pedido
        elif opcion_usuario == 3:
            print(EjerciciosPython18CRUD.actualizar_pedido(conexion))

        #Si el usuario elige 4,
        #Llamamos a la funcion eliminar_pedido
        elif opcion_usuario == 4:
            print(EjerciciosPython18CRUD.eliminar_pedido(conexion))

        #Si el usuario elige 5,
        #Salir
        elif opcion_usuario == 5:
            print('Saliendo del programa...')
            break