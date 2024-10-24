print("\nMENU")
print("1.- Cuadrado")
print("2.- Rectangulo")
print("3.- Salir")

while True:#Bucle para que vuelva a preguntarme 
    Elegir_opcion = int(input("\nIngresa una opcion: "))
    if Elegir_opcion == 1:
        lado_cuadrado = int(input("\nDime el lado del cuadrado: "))#Si elegir_opcion = 1 que me pida el lado del cuadrado
        for i in range(lado_cuadrado):#bucle for para contar cuantos "caracteres" hay en lado_cuadrado
            print("*" * lado_cuadrado)#Dibuja una fila de asteristicos segun el lado
        print(f"Su area es: {lado_cuadrado * 2}")
        print(f"Su perimetro es: {lado_cuadrado * 4}")

    elif Elegir_opcion == 2:
        base_rectangulo = int(input("\nDime la base del rectangulo: "))#Si elegir_opcion = 2 que me pida la base del rectangulo
        altura_rectangulo = int(input("Dame la altura del rectangulo: "))#Si elegir_opcion = 2 que me pida la altura del rectangulo
        for i in range(altura_rectangulo):#Esto se va a repetir tantas veces como la altura del rectangulo
            print("*" * base_rectangulo)#Dibuja una fila de asteristicos segun la base
        print(f"\nSu area es: {base_rectangulo * altura_rectangulo}")
        print(f"Su perimetro es: {base_rectangulo * 2 + altura_rectangulo * 2}")

    elif Elegir_opcion == 3:
        print("Saliendo...")#Si elegir_opcion = 3 Salir del programa
        break

    else:
        print("Opcion incorrecta")#Si elegir_opcion = otros numeros, vuelve al principio del bucle