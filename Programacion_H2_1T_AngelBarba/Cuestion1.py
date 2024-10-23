print("\nMENU")
print("1.- Cuadrado")
print("2.- Rectangulo")
print("3.- Salir")

while True:
    Elegir_opcion = int(input("\nIngresa una opcion: "))
    if Elegir_opcion == 1:
        lado_cuadrado = int(input("\nDime el lado del cuadrado: "))
        for i in range(lado_cuadrado):
            print("*" * lado_cuadrado)
        print(f"Su area es: {lado_cuadrado * 2}")
        print(f"Su perimetro es: {lado_cuadrado * 4}")

    elif Elegir_opcion == 2:
        base_rectangulo = int(input("\nDime la base del rectangulo: "))
        altura_rectangulo = int(input("Dame la altura del rectangulo: "))
        for i in range(altura_rectangulo):
            print("*" * base_rectangulo)
        print(f"\nSu area es: {base_rectangulo * altura_rectangulo}")
        print(f"Su perimetro es: {base_rectangulo * 2 + altura_rectangulo * 2}")

    elif Elegir_opcion == 3:
        print("Saliendo...")
        break

    else:
        print("Opcion incorrecta")