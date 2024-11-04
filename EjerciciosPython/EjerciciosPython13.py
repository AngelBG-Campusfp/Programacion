import numpy as np
import random

#Generar numero aleatorio del 1 al 100 1o veces
numero_aleatorio = np.random.randint(1,101, size=10)

try:
    #Crear archivo txt y hacer que salga un nº aleatorio
    with open("numeros.txt", "w") as guardar_numeros:
        for i in numero_aleatorio:
            print(f"{i}\n")
except FileNotFoundError:
    print("El archivo no fue encontrado")

try:
    #Abrir el archivo txt y guardara los numeros random en un array de numoy
    with open("numeros.txt", "r") as guardar_numeros:
        almacenar_numeros = np.array(guardar_numeros)
except FileNotFoundError:
    print("El archivo no fue encontrado")

print(almacenar_numeros)









""" #Ejercicio 2
grados_celsius = [15,16,18,20,22,25,30,28,24,19,17,15]

try:
    with open('Temperaturas.txt', 'w') as temperaturas:
        for i in grados_celsius:
            temperaturas.write(f"{i}\n")
except FileNotFoundError:
    print('El archivo no fue encontrado')

try:
    #Abrir el archivo y guardar los siguientes valores dentro del array
    with open("Temperaturas.txt", "r") as tempraturas:
        leer_lineas = temperaturas.readlines()
        pasar_enteros = np.array(int)
except FileNotFoundError:
    print('El archivo no fue encontrado')

promedio = np.mean(pasar_enteros)
promedio = np.max(pasar_enteros)
promedio = np.min(pasar_enteros) """









""" def leer_notas_estudiantes(nombre_archivo):
    #Lee las notas de estudiantes desde un archivo y las almacena en un array bidimensional.
    archivo = open('Estudiantes.txt', 'r')
    lista_notas = []
    for linea in archivo:
        calificaciones = linea.strip().split(',')
        calificaciones = [int(nota) for nota in calificaciones]
        lista_notas.append(calificaciones)
    archivo.close()
    return np.array(lista_notas)


def calcular_promedios_estudiantes(notas):
    #Calcula el promedio de cada estudiante y el promedio general de la clase.
    promedios_estudiantes = np.mean(notas, axis=1)
    promedio_clase = np.mean(notas)
    return promedios_estudiantes, promedio_clase


def main():
    notas = leer_notas_estudiantes('notas_estudiantes.txt')
    promedios_estudiantes, promedio_clase = calcular_promedios_estudiantes(notas)
    print("Promedio de cada estudiante:", promedios_estudiantes)
    print(f"Promedio general de la clase: {promedio_clase:.2f}")


main() """









""" # Paso 1: Crear el archivo con números enteros aleatorios
def crear_archivo_valores():
    with open('valores.txt', 'w') as archivo:
        for _ in range(15):
            valor = random.randint(-50, 50)  # Genera un número entero aleatorio entre -50 y 50
            archivo.write(str(valor) + "\n")  # Escribir el número en una nueva línea

# Paso 2: Leer números enteros desde un archivo y almacenarlos en un array de Numpy
def leer_valores(nombre_archivo):
    #Lee números enteros desde un archivo y los almacena en un array de Numpy.
    with open(nombre_archivo, 'r') as archivo:
        lista_valores = []
        for linea in archivo:
            valor = int(linea.strip())
            lista_valores.append(valor)
    return np.array(lista_valores)

# Paso 3: Filtrar los valores positivos
def filtrar_valores_positivos(valores):
    #Devuelve un array con solo los valores positivos de un array dado.
    valores_positivos = []
    for valor in valores:
        if valor > 0:
            valores_positivos.append(valor)
    return np.array(valores_positivos)

# Paso 4: Guardar los valores positivos en un archivo
def guardar_valores_en_archivo(valores, nombre_archivo):
    #Guarda un array en un archivo, cada número en una línea.
    with open(nombre_archivo, 'w') as archivo:
        for valor in valores:
            archivo.write(str(valor) + "\n")

# Paso 5: Función principal
def main():
    crear_archivo_valores()  # Crea el archivo con valores aleatorios
    valores = leer_valores('valores.txt')  # Lee los valores del archivo
    valores_positivos = filtrar_valores_positivos(valores)  # Filtra los valores positivos
    guardar_valores_en_archivo(valores_positivos, 'valores_positivos.txt')  # Guarda los positivos en un nuevo archivo
    print("Valores positivos guardados en valores_positivos.txt")

# Ejecutar el programa principal
main() """









""" def generar_matriz_aleatoria(filas=3, columnas=3, rango=(1, 10)):
    #Genera una matriz de tamaño especificado con valores enteros aleatorios en el rango dado.
    return np.random.randint(rango[0], rango[1] + 1, (filas, columnas))


def guardar_matriz_en_archivo(matriz, nombre_archivo):
    #Guarda una matriz en un archivo, cada fila en una línea con valores separados por comas.
    archivo = open(nombre_archivo, 'w')
    for fila in matriz:
        archivo.write(','.join(str(valor) for valor in fila) + "\n")
    archivo.close()


def leer_matriz_desde_archivo(nombre_archivo):
    #Lee una matriz desde un archivo y la convierte en un array bidimensional de Numpy.
    archivo = open(nombre_archivo, 'r')
    lista_matriz = []
    for linea in archivo:
        fila = linea.strip().split(',')
        fila = [int(valor) for valor in fila]
        lista_matriz.append(fila)
    archivo.close()
    return np.array(lista_matriz)


def main():
    matriz = generar_matriz_aleatoria()
    guardar_matriz_en_archivo(matriz, 'matriz.txt')
    matriz_leida = leer_matriz_desde_archivo('matriz.txt')
    print("Matriz leída desde el archivo:\n", matriz_leida)


main() """
