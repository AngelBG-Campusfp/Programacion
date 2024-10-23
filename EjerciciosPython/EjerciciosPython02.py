palabra_usuario = input("Esribe una palabra: ")
palabra_invertida = ""

for i in palabra_usuario:
    palabra_invertida = i + palabra_invertida

print(palabra_invertida)



suma_total = 0
contador = 0

while True:
    numero_usuario = int(input("Escribe un numero entero: "))

    if numero_usuario == 0:
        break

    suma_total += numero_usuario
    contador += 1

    if contador > 0:
        promedio = suma_total / contador
        print("El promedio de los numeros es: ", promedio)
    else:
        print("No se han ingresado numeros para calcular pormedio")


nombres = []

while True:
    nombre_usuario = input("Escribe un nombre de usuario (o 'fin' para terminar)")

    if nombre_usuario == "fin":
        break

    nombres.append(nombre_usuario)

print(nombres)



contraseña_usuario = "123456"

while True:
    contraseña = input("Ingresa tu contraseña: ")

    if contraseña != "123456":
        input("Contraseña incorrecta, intentalo de nuevo: ")

    else:
        print("Bienvenido")
        break
        



lista_numeros = []

while True:
    numeros = input("Escribe un numero entero (o 'hecho' para terminar) ")


    if numeros == "hecho":
        break

    lista_numeros.append(numeros)

    if lista_numeros:
        mayor = max(lista_numeros)
        print("El numero mayor es: ", mayor)
    else:
        print("No se ingresaron los numeros")


