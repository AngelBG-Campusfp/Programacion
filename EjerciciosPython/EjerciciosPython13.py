import numpy as np

#Generar numero aleatorio del 1 al 100 1o veces
numero_aleatorio = np.random.randint(1,101, size=10)

try:
    with open("numeros.txt", "w") as guardar_numeros:
        for i in numero_aleatorio:
            print(f"{i}\n")
except FileNotFoundError:
    print("El archivo no fue encontrado")

try:
    with open("numeros.txt", "r") as guardar_numeros:
        almacenar_numeros = np.array(guardar_numeros)
except FileNotFoundError:
    print("El archivo no fue encontrado")

print(almacenar_numeros)




#Ejercicio 2
grados_celsius = [15,16,18,20,22,25,30,28,24,19,17,15]

try:
    with open('Temperaturas.txt', 'w') as temperaturas:
        for i in grados_celsius:
            temperaturas.write(f"{i}\n")
except FileNotFoundError:
    print('El archivo no fue encontrado')

try:
    with open("temperaturas.txt", "r") as temepraturas:
        array1 = np.mean(grados_celsius)
        array2 = np.max(grados_celsius)
        array3 = np.min(grados_celsius)
except FileNotFoundError:
    print('El archivo no due encontrado')
