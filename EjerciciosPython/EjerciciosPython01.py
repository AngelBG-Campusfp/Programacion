numero1 = int(input("Primer numero: "))
numero2 = int(input("Segundo numero: "))

operacion = input("Elige la operacion que quieras realizar con estos numeros: ")

if operacion == "suma":
    print(numero1 + numero2)
elif operacion == "resta":
    print(numero1 - numero2)
elif operacion == "multiplicacion":
    print(numero1 * numero2)
elif operacion == "division":
    if numero2 == 0:
        print("Error, porfavor introduzca un numero distinto a cero")
    else:
        print(numero1 / numero2)




numero = int(input("Escribe un numero: "))

if numero % 2 == 0:
    print("El numero", numero, "es par")
else: 
    print("El numero", numero, "es impar") 


Numero_entero = int(input("Escribe un numero entero positivo: "))

if Numero_entero >0:
    suma = sum(range(1, Numero_entero + 1))
    print("La suma de todos los numeros desde 1 hasta", Numero_entero,"es: ", suma)
else:
    print("Este numero no es postivio.")


Cadena_texto = input("Introduce una cadena de texto")

vocales = "aeiouAEIOU"

contador_vocales = 0

for caracter in Cadena_texto:
    if caracter in vocales:
        contador_vocales = contador_vocales + 1

print("La cantidad de vocales que hay son: ", contador_vocales)


