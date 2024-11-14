import Fase2Operaciones

def mostrar_menu(conexion):
    while True:
        print("\n--- Menú de Gestión de Pedidos ---\n")
        print("1. Registrar Cliente")
        print("2. Ver todos los Clientes")
        print("3. Buscar Cliente por E-mail")
        print("4. Realizar Compra")
        print("5. Seguimiento de Compra")
        print("6. Salir")

        opcion = int(input("Seleccione una opción: "))

        if opcion == 1:
            Fase2Operaciones.registrar_cliente(conexion)
        elif opcion == 2:
            Fase2Operaciones.ver_clientes(conexion)
        elif opcion == 3:
            Fase2Operaciones.buscar_cliente(conexion)
        elif opcion == 4:
            Fase2Operaciones.realizar_compra(conexion)
        elif opcion == 5:
            Fase2Operaciones.seguimiento_compra()
        elif opcion == 6:
            print("Saliendo del sistema...")
            break
        else:
            print("Opción no válida. Intente de nuevo.")