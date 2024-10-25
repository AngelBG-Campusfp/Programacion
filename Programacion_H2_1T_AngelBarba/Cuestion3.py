dinero_ingresado = []
dinero_retirado = []
saldo_inicial = 0

# Pedir saldo inicial hasta que sea válido
while True:
    saldo_inicial = float(input("Saldo inicial: "))
    if saldo_inicial >= 0:
        print(f"\nSaldo inicial: {saldo_inicial}")
        break
    else:
        print("El valor no puede ser negativo. Escríbelo de nuevo.")

#Bucle para el programa en general
while True:
    # Mostrar el menú
    print("\nMENU:")
    print("1 - Ingresar Dinero")
    print("2 - Retirar Dinero")
    print("3 - Mostrar Saldo")
    print("4 - Estadísticas")
    print("5 - Salir")
    
    # Elegir una opción válida
    opcion = int(input("Elige una opción: "))
    while opcion not in [1, 2, 3, 4, 5]:
        print("Opción incorrecta. Elige de nuevo.")
        opcion = int(input("Elige una opción: "))

    if opcion == 1:  # Ingresar dinero
        ingreso = float(input("Cantidad a ingresar: "))
        while ingreso < 0:
            print("La cantidad no puede ser negativa.")
            ingreso = float(input("Cantidad a ingresar: "))
        saldo_inicial += ingreso
        dinero_ingresado.append(ingreso)
        print(f"Se han ingresado {ingreso} € | Saldo actual: {saldo_inicial} €.")

    elif opcion == 2:  # Retirar dinero
        retiro = float(input("Cantidad que quieres retirar retirar: "))
        while retiro < 0 or retiro > saldo_inicial:
            if retiro < 0:
                print("La cantidad no puede ser negativa.")
            elif retiro > saldo_inicial:
                print("No puedes retirar más dinero del que tienes.")
            retiro = float(input("Cantidad que quieres retirar: "))
        saldo_inicial -= retiro
        dinero_retirado.append(retiro)
        print(f"Se han retirado {retiro} € | Saldo actual: {saldo_inicial} €.")

    elif opcion == 3:  # Mostrar saldo
        print(f"\nTu saldo actual es: {saldo_inicial} €.")


    elif opcion == 5:  # Salir
        print("Saliendo del programa...")
        break


